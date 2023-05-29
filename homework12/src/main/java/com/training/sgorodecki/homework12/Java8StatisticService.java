package com.training.sgorodecki.homework12;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8StatisticService implements StatisticService {

    private static final String FIRST_LETTER_UPPERCASE = "^[A-Z].*";
    private static final String FIRST_LETTER_LOWERCASE = "^[a-z].*";

    @Override
    public long countEvenNumbers(List<Long> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Long::sum)
                .orElseThrow(() -> new UnsupportedOperationException("list is empty"));
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        return numbers.stream()
                .distinct()
                .map(number -> (long) Math.pow(number, 2))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings) {

        List<String> allWords = strings.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<Character> wordsUpperLetter = allWords.stream()
                .filter(s -> s.length() > 1)
                .filter(s -> s.matches(FIRST_LETTER_UPPERCASE))
                .map(s -> s.charAt(s.length() - 1))
                .collect(Collectors.toList());

        Set<String> wordsLowerLetter = allWords.stream()
                .filter(s -> s.matches(FIRST_LETTER_LOWERCASE))
                .collect(Collectors.toSet());

        return wordsUpperLetter.stream()
                .collect(Collectors.toMap(k -> k, v -> getLowerCaseWords(wordsLowerLetter, v)));
    }

    private List<String> getLowerCaseWords(Set<String> wordSet, char lastLetter) {
        return wordSet.stream()
                .filter(s -> s.endsWith(String.valueOf(lastLetter)))
                .collect(Collectors.toList());
    }
}