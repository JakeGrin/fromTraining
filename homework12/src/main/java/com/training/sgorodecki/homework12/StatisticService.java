package com.training.sgorodecki.homework12;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StatisticService {
    /**
     * Use this method to find a count of even numbers.
     *
     * @param numbers list of longs to count
     * @return sum of even numbers
     */

    long countEvenNumbers(List<Long> numbers); // just warm up :)

    /**
     * Use this method to get list of all distinct numbers square
     * sorted in ascending order
     *
     * @param numbers list of longs
     * @return list of all distinct numbers squares sorted in ascending order
     */
    List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers);

    /**
     * @param strings set of lists with words, can contain empty strings
     *                in lowe cases
     * @return map where the key is the last letter of the word in upper case
     * and value is a list of lower case words ended this letter
     */
    Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings);
}
