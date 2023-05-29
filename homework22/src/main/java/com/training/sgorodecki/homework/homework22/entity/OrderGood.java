package com.training.sgorodecki.homework.homework22.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_good")
public class OrderGood {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "good_id")
    private int goodId;

    @Column(name = "order_id")
    private int orderId;

    public OrderGood() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
