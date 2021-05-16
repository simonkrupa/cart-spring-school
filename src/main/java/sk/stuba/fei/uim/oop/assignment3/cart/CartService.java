package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

@Service
public class CartService implements ICartService {
    private CartRepository repository;
    @Autowired
    private ICartService cartService;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart create() {
        Cart newCart = new Cart();
        return this.repository.save(newCart);
    }

    @Override
    public Cart getById(long cartId) {
        return this.repository.findById(cartId).orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean deleteCart(long cartId) {
        boolean isDeleted = this.repository.findById(cartId).isPresent();
        if (isDeleted){this.repository.deleteById(cartId);}
        return isDeleted;
    }

    @Override
    public Cart addProductToCart(long cartId, CartIdAmountRequest request) {
        return null;//this.repository.findById(cartId).get().getShoppingCart().add(request);
    }
}
