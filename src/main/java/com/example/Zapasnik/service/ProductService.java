package com.example.Zapasnik.service;

import com.example.Zapasnik.repository.Product;
import com.example.Zapasnik.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductUpdator productUpdator;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductUpdator productUpdator) {
        this.productRepository = productRepository;
        this.productUpdator = productUpdator;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
       return productRepository.save(product);
    }

    public Product removeById(int id){
        Product product = productRepository.findAll().stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .orElseThrow(
                        ()->{throw new NoSuchElementException("Product not found");
                        }
                );
        productRepository.deleteById(id);
        return product;

    }

    public Product updateProduct(Product product){
        return productUpdator.update(product);
    }


}
