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
    public ResponseEntity<CartResponse> createCart(@RequestBody CartRequest request){
        return new ResponseEntity<>(new CartResponse(this.service.create(request)),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable("id")long cartId){
        return new ResponseEntity<>(new CartResponse(this.service.getById(cartId)), HttpStatus.OK);
    }
}
