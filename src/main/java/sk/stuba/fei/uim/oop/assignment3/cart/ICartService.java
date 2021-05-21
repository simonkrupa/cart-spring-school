package sk.stuba.fei.uim.oop.assignment3.cart;


public interface ICartService {
    Cart create();
    Cart getById(long cartId);
    boolean deleteCart(long cartId);
    Cart addProductToCart(long cartId, CartIdAmountRequest request);
    String payForCart(long cartId);
}
