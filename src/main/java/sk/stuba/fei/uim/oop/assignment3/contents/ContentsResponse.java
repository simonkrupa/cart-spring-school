package sk.stuba.fei.uim.oop.assignment3.contents;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentsResponse {

    private Long productId;
    private int amount;

    public ContentsResponse(Contents contents) {
        this.amount = contents.getAmount();
        this.productId = contents.getProductId();
    }
}
