package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return this.repository.findById(productId);
    }

    @Override
    public Product updateOfProduct(long productId, ProductRequest request) {
        if(request.getName() != null) {
            this.repository.findById(productId).setName(request.getName());
        }
        if (request.getDescription() != null) {
            this.repository.findById(productId).setDescription(request.getDescription());
        }
        return this.repository.findById(productId);
    }

    @Override
    public void deleteProduct(long productId) {
        this.repository.deleteById(productId);
    }

    @Override
    public ProductAmount getAmountOfProduct(long productId) {
        ProductAmount productAmount = new ProductAmount();
        productAmount.setAmount(this.repository.findById(productId).getAmount());
        return productAmount;
    }

    @Override
    public Product increaseAmountOfProduct(long productId, ProductRequest productRequest) {
        this.repository.findById(productId).setAmount(this.repository.findById(productId).getAmount()+productRequest.getAmount());
        return this.repository.findById(productId);
    }
}
