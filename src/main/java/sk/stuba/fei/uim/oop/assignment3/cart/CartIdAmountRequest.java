package sk.stuba.fei.uim.oop.assignment3.cart;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartIdAmountRequest {
    private long productId;
    private int amount;
}
