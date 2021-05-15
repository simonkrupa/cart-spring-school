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
    public Cart create(CartRequest request) {
        Cart newCart = new Cart();
        newCart.setPayed(request.isPayed());
        return this.repository.save(newCart);
    }

    @Override
    public Cart getById(long cartId) {
        return this.repository.findById(cartId).orElseThrow(NotFoundException::new);
    }
}
