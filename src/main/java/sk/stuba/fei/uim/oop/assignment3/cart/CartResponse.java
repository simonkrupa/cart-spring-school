package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import java.util.List;

@Getter
public class CartResponse {
    private Long id;
    private List<Product> shoppingList;
    private boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.payed = cart.isPayed();
        this.shoppingList = cart.getShoppingCart();
    }
}
