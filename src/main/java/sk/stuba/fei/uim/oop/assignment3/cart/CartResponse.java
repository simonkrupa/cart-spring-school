package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CartResponse {
    private Long id;
   private List<Product> shoppingList;
   // private List<CartIdAmountRequest> shopList = new ArrayList<>();
    private boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.payed = cart.isPayed();
        this.shoppingList = cart.getShoppingCart();
        /*for(var p : cart.getShoppingCart()){
            CartIdAmountRequest c = new CartIdAmountRequest();
            c.setProductId(p.getId());
            c.setAmount(p.getAmount());
            shopList.add(c);
        }*/
    }
}
