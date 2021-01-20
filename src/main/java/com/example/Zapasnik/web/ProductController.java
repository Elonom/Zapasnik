package com.example.Zapasnik.web;

import com.example.Zapasnik.registration.repository.ZapUser;
import com.example.Zapasnik.registration.service.ZapUserDto;
import com.example.Zapasnik.registration.service.ZapUserService;
import com.example.Zapasnik.repository.Product;
import com.example.Zapasnik.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {


    private final ProductService productService;
    private final ZapUserService zapUserService;

    @Autowired
    public ProductController(ProductService productService, ZapUserService zapUserService) {
        this.productService = productService;
        this.zapUserService = zapUserService;
    }


    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("product/{id}")
    public Product deleteProduct(@PathVariable int id){
        return productService.removeById(id);
    }

    @PutMapping
    public Product changeProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PostMapping("/signup")
    public ZapUserDto addUser(ZapUser zapUser){
        return zapUserService.addUser(zapUser);
    }


}
