package com.example.Zapasnik.web;

import com.example.Zapasnik.repository.Product;
import com.example.Zapasnik.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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


}
