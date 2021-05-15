package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return new ProductResponse(this.service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
        return new ResponseEntity<>(new ProductResponse(this.service.getById(productId)), HttpStatus.OK);
        //return new ProductResponse(this.service.getById(productId));
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") long productId, @RequestBody ProductRequest request) {
        return new ProductResponse(this.service.updateOfProduct(productId, request));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long productId){
        this.service.deleteProduct(productId);
    }

    @GetMapping("/{id}/amount")
    public ProductAmount getAmount(@PathVariable("id") long productId){
        return this.service.getAmountOfProduct(productId);
    }

    @PostMapping("/{id}/amount")
    public ProductResponse increaseAmount(@PathVariable("id") long productId, @RequestBody ProductRequest request){
        return new ProductResponse(this.service.increaseAmountOfProduct(productId,request));
    }

}
