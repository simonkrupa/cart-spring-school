package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.contents.ContentsResponse;

import java.util.ArrayList;
import java.util.List;


@Getter
public class CartResponse {
    private Long id;
    private List<ContentsResponse> shoppingList = new ArrayList<>();
    private boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.payed = cart.isPayed();
        for(var p : cart.getShoppingCart()) {
            ContentsResponse c = new ContentsResponse(p);
            shoppingList.add(c);
        }
    }
}
