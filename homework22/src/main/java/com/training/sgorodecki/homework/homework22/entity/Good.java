package com.training.sgorodecki.homework.homework22.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.ZERO;

@Entity
@Table(name = "good")
public class Good {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    public Good() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price + " $";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id == good.id &&
                Objects.equals(name, good.name) &&
                price.compareTo(good.price) == ZERO.intValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}