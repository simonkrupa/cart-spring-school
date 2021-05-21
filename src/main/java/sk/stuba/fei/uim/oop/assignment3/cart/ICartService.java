package sk.stuba.fei.uim.oop.assignment3.cart;

import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.product.ProductRequest;

public interface ICartService {
    Cart create();
    Cart getById(long cartId);
    boolean deleteCart(long cartId);
    Cart addProductToCart(long cartId, CartIdAmountRequest request);
}
