package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService service;


    @PostMapping()
    public ResponseEntity<CartResponse> createCart(){
        return new ResponseEntity<>(new CartResponse(this.service.create()),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable("id")long cartId){
        return new ResponseEntity<>(new CartResponse(this.service.getById(cartId)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") long cartId){
        if(this.service.deleteCart(cartId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<CartResponse> addProductToCart(@PathVariable("id") long cartId, @RequestBody CartIdAmountRequest request){
        return null;//return new ResponseEntity<>(new CartResponse(this.service.))
    }
}
