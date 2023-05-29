package com.training.sgorodecki.homework.homework9.homework9_1;

import java.util.Arrays;

public class ArraySorter {
    public Integer[] sortArray(Integer[] numbers) throws Exception {
        if (numbers == null || numbers.length == 0) {
            throw new UnsupportedOperationException("Array is empty");
        } else {
            Arrays.sort(numbers, new IntegerComparator());
            System.out.println(Arrays.toString(numbers));
            return numbers;
        }
    }
}
