package com.training.sgorodecki.homework.homework17.services;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.training.sgorodecki.homework.homework17.model.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

public class BucketService {


    private static BucketService instance;

    private Multimap<String, Product> multimap = ArrayListMultimap.create();

    public Multimap<String, Product> getMultimap() {
        return multimap;
    }

    public void setMultimap(Multimap<String, Product> multimap) {
        this.multimap = multimap;
    }

    public static synchronized BucketService getInstance() {
        if (instance == null) {
            instance = new BucketService();
        }
        return instance;
    }

    public String makeUserBucket(String username) {
        Collection<Product> productCollection = getMultimap().get(username);
        return productCollection
                .stream()
                .map(product -> "<li>" + product.toString() + "</li>")
                .collect(Collectors.joining());
    }

    public BigDecimal makeTotalCost(String username) {
        Collection<Product> productCollection = getMultimap().get(username);
        return productCollection
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add).get();
    }

}
