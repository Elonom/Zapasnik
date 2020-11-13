package com.example.Zapasnik.service;

import com.example.Zapasnik.repository.Product;
import com.example.Zapasnik.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ProductUpdator {

    private final ProductRepository productRepository;

    @Autowired
    public ProductUpdator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product update(Product product){
        Product productToUpdate = productRepository.findById(product.getId()).orElseThrow(()->{throw new NoSuchElementException();
        });
        if(product.getProductName() != null){
            productToUpdate.setProductName(product.getProductName());
        }
        if(product.getAmount() < 0){
            productToUpdate.setAmount(product.getAmount());
        }
        if(product.getMinAccValue() < 0){
            productToUpdate.setMinAccValue(product.getMinAccValue());
        }
        if(product.getPictureNumber() != null){
            productToUpdate.setPictureNumber(product.getPictureNumber());
        }
        return productRepository.save(productToUpdate);

    }


}
