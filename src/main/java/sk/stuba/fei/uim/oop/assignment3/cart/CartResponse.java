package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;

@Getter
public class CartResponse {
    private boolean payed;

    public CartResponse(Cart cart) {
        this.payed = cart.isPayed();
    }
}
