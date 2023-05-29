package com.training.sgorodecki.homework4.homework4_2;

public class SortingChoice implements Sorter {

    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int position = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    position = j;
                    min = array[j];
                }
            }
            array[position] = array[i];
            array[i] = min;
        }
        return array;
    }
}

