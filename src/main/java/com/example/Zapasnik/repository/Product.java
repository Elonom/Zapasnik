package com.example.Zapasnik.repository;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "min_acceptable_value", nullable = false)
    private int minAccValue;

    @Column(name = "picture_number", nullable = false)
    private String pictureNumber;


    public Product() {
    }

    public Product(int id, String productName, int amount, int minAccValue, String pictureNumber) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.minAccValue = minAccValue;
        this.pictureNumber = pictureNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinAccValue() {
        return minAccValue;
    }

    public void setMinAccValue(int minAccValue) {
        this.minAccValue = minAccValue;
    }

    public String getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(String pictureNumber) {
        this.pictureNumber = pictureNumber;
    }
}
