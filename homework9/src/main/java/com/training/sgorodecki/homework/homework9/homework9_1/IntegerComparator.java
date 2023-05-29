package com.training.sgorodecki.homework.homework9.homework9_1;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int sumOfO1 = getSum(o1);
        int sumOfO2 = getSum(o2);
        return sumOfO1 - sumOfO2;
    }

    private int getSum(Integer integer) {
        int sum = 0;
        while (integer != 0) {
            sum += integer % 10;
            integer /= 10;
        }
        return sum;
    }
}