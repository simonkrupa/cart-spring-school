package sk.stuba.fei.uim.oop.assignment3.contents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;
    private int amount;

    public Contents(Product product, int amount) {
        this.productId = product.getId();
        this.amount = amount;
    }

}


