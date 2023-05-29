package com.training.sgorodecki.homework3.homework3_2;

import java.util.Arrays;

public class Median {

    /**
     * method description - evaluate median of array of integers .
     *
     * @param - variable arr
     * @result -  result is median of array
     */
    public static float median(int[] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            int i = arr.length / 2;
            float result = (float) (arr[i] + arr[i - 1]) / 2;
            return result;
        } else {
            int i = arr.length / 2;
            return arr[i];
        }
    }

    /**
     * method description - evaluate median of array of doubles .
     *
     * @param - variable arr
     * @result -  result is median of array
     */
    public static double median(double[] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            int i = arr.length / 2;
            double result = (arr[i] + arr[i - 1]) / 2;
            return result;
        } else {
            int i = arr.length / 2;
            return arr[i];
        }
    }
}