package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.contents.Contents;
import sk.stuba.fei.uim.oop.assignment3.contents.ContentsRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import java.util.Optional;

@Service
public class CartService implements ICartService {
    private CartRepository repository;

    @Autowired
    private ContentsRepository contentsRepository;

    @Autowired
    private IProductService productService;

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
        Optional<Cart> cartOpt = this.repository.findById(cartId);
        if (!cartOpt.isPresent()){
            throw new NotFoundException();
        }
        Cart cart = cartOpt.get();
        if(cart.isPayed()){
            throw new BadRequestException();
        }

        Product product = this.productService.getById(request.getProductId());

        if(product.getAmount() >= request.getAmount()) {

            for(var c : contentsRepository.findAll()){
                if (c.getProductId()==request.getProductId()){
                    c.setAmount(c.getAmount()+ request.getAmount());
                    product.setAmount(product.getAmount()- request.getAmount());
                    this.productService.save(product);
                    return this.repository.save(cart);
                }
            }
            product.setAmount(product.getAmount()- request.getAmount());

            Contents contents = new Contents(product, request.getAmount());

            contents = this.contentsRepository.save(contents);

            cart.getShoppingCart().add(contents);

            this.productService.save(product);
        }else {
            throw new BadRequestException();
        }
        return this.repository.save(cart);
    }

    @Override
    public String payForCart(long cartId) {
        Optional<Cart> cartOpt = this.repository.findById(cartId);
        if (!cartOpt.isPresent()){
            throw new NotFoundException();
        }
        Cart cart = cartOpt.get();
        if (cart.isPayed()){
            throw  new BadRequestException();
        }
        double priceCount = 0;
        for(var a : cart.getShoppingCart()){
            Product product = productService.getById(a.getProductId());
            priceCount = priceCount + a.getAmount()*product.getPrice();
        }
        cart.setPayed(true);
        this.repository.save(cart);
        return ""+priceCount;
    }
}
