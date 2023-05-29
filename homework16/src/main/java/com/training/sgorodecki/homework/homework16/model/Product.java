package com.training.sgorodecki.homework.homework16.model;

import java.math.BigDecimal;

public class Product {

   private String name;
   private Integer id;
   private BigDecimal price;

    public Product(String name, Integer id, BigDecimal price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price + " $" ;
    }
}
