package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.contents.Contents;
import sk.stuba.fei.uim.oop.assignment3.contents.ContentsResponse;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {
    private Long id;
    private List<ContentsResponse> shoppingList = new ArrayList<>();
    // private List<CartIdAmountRequest> shopList = new ArrayList<>();
    private boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.payed = cart.isPayed();
        for(var p : cart.getShoppingCart()) {
            ContentsResponse c = new ContentsResponse(p);
            //c.setProductId(p.getId());
            //c.setAmount(p.getAmount());
            shoppingList.add(c);
        }




        /*for(var p : cart.getShoppingCart()){
            CartIdAmountRequest c = new CartIdAmountRequest();
            c.setProductId(p.getId());
            c.setAmount(p.getAmount());
            shopList.add(c);
        }*/
    }
}
