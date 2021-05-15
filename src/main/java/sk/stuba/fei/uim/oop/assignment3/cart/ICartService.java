package sk.stuba.fei.uim.oop.assignment3.cart;

public interface ICartService {
    Cart create(CartRequest request);
    Cart getById(long cartId);
}
