package sk.stuba.fei.uim.oop.assignment3.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setPrice(request.getPrice());
        newProduct.setUnit(request.getUnit());
        return this.repository.save(newProduct);
    }

    @Override
    public Product getById(long productId) {
        return this.repository.findById(productId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Product updateOfProduct(long productId, ProductRequest request) {
        if(request.getName() != null) {
            this.repository.findById(productId).get().setName(request.getName());
        }
        if (request.getDescription() != null) {
            this.repository.findById(productId).get().setDescription(request.getDescription());
        }
        return this.repository.findById(productId).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean deleteProduct(long productId) {
        boolean isDeleted = this.repository.findById(productId).isPresent();
        if (isDeleted){this.repository.deleteById(productId);}
        return isDeleted;
    }

    @Override
    public ProductAmount getAmountOfProduct(long productId) {
        if(this.repository.findById(productId).isPresent()) {
            ProductAmount productAmount = new ProductAmount();
            productAmount.setAmount(this.repository.findById(productId).get().getAmount());
            return productAmount;
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public Product increaseAmountOfProduct(long productId, ProductRequest productRequest) {
        this.repository.findById(productId).get().setAmount(this.repository.findById(productId).get().getAmount()+productRequest.getAmount());
        return this.repository.findById(productId).get();
    }
}
