package sk.stuba.fei.uim.oop.assignment3.product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product create(ProductRequest request);
    Product getById(long productId);
    Product updateOfProduct(long productId, ProductRequest request);
    boolean deleteProduct(long productId);
    ProductAmount getAmountOfProduct(long productId);
    ProductAmount increaseAmountOfProduct(long productId, ProductRequest productRequest);
}
