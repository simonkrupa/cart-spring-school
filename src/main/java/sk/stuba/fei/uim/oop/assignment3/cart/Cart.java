package sk.stuba.fei.uim.oop.assignment3.cart;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.contents.Contents;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean payed;

    @OneToMany
    private List<Contents> shoppingCart = new ArrayList<>();


}
