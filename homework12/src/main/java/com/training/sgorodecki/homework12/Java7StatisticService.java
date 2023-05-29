package com.training.sgorodecki.homework12;

import java.util.*;

public class Java7StatisticService implements StatisticService {

    private static final String FIRST_LETTER_UPPERCASE = "^[A-Z].*";
    private static final String FIRST_LETTER_LOWERCASE = "^[a-z].*";

    @Override
    public long countEvenNumbers(List<Long> numbers) {
        if (!numbers.isEmpty()) {
            long sum = 0;
            for (Long number : numbers) {
                if (number % 2 == 0) {
                    sum = sum + number;
                }
            }
            return sum;
        } else {
            throw new UnsupportedOperationException("list is empty");
        }
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        Set<Long> set = new TreeSet<>(numbers);
        List<Long> list = new ArrayList<>();
        for (Long number : set) {
            list.add((long) Math.pow(number, 2));
        }
        return list;
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings) {
        Set<String> wordSet = new HashSet<>();
        for (List<String> list : strings) {
            wordSet.addAll(list);
        }
        Map<Character, List<String>> map = new HashMap<>();
        putLetterAndListOfWordsInMap(wordSet, map);
        return map;
    }

    private void putLetterAndListOfWordsInMap(Set<String> wordSet, Map<Character, List<String>> map) {
        for (String string : wordSet) {
            if (string.matches(FIRST_LETTER_UPPERCASE) && (string.length() > 1)) {
                char lastLetter = string.charAt(string.length() - 1);
                List<String> listWordsInLowerCase = getLowerCaseWords(wordSet, lastLetter);
                map.put(lastLetter, listWordsInLowerCase);
            }
        }
    }

    private List<String> getLowerCaseWords(Set<String> wordSet, char lastLetter) {
        List<String> listWordsInLowerCase = new ArrayList<>();
        for (String str : wordSet) {
            if (str.matches(FIRST_LETTER_LOWERCASE) && str.endsWith(String.valueOf(lastLetter))) {
                listWordsInLowerCase.add(str);
            }
        }
        return listWordsInLowerCase;
    }
}