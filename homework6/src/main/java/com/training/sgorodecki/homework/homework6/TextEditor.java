package com.training.sgorodecki.homework.homework6;

import java.util.*;

public class TextEditor {

    private static final String SPACE = " ";
    private static final String RETREAT = "   ";
    private static final String COLON = ":";

    public List<String> getListOfWords(String input) {
        String inputWithoutPunctuations = removePunctuationMarks(input);
        String[] arrayOfWords = inputWithoutPunctuations.split(SPACE);
        return Arrays.asList(arrayOfWords);
    }

    private String removePunctuationMarks(String input) {
        input = input.replaceAll("\\p{Punct}|\\d", "");
        return input;
    }

    public Set<String> getFirstLetters(List<String> listOfWords) {
        Set<String> firstLetters = new HashSet<>();
        for (String word : listOfWords) {
            char letter = word.toLowerCase().charAt(0);
            firstLetters.add(String.valueOf(letter));
        }
        return firstLetters;
    }

    public Set<String> getSetOfUniqueWords(List<String> listOfWords) {
        return new HashSet<>(listOfWords);
    }

    public Map<String, List<String>> findCoincidenceWordsAndLetters(Set<String> firstLetters, Set<String> setOfUniqueWords) {
        Map<String, List<String>> coincidenceWordsAndLetters = new TreeMap<>();
        for (String letter : firstLetters) {
            List<String> listOfWords = new ArrayList<>();
            for (String word : setOfUniqueWords) {
                if (word.toLowerCase().startsWith(letter.toLowerCase())) {
                    listOfWords.add(word);
                }
                coincidenceWordsAndLetters.put(letter, listOfWords);
            }
        }
        return coincidenceWordsAndLetters;
    }

    public void printEditedText(Map<String, List<String>> mapWord, List<String> wordList) {
        for (Map.Entry<String, List<String>> entry : mapWord.entrySet()) {
            System.out.println(entry.getKey().toUpperCase() + COLON + SPACE + getFirstValue(entry) + SPACE + Collections.frequency(wordList, getFirstValue(entry)));
            int size = entry.getValue().size();
            for (int i = 1; i < size; i++) {
                String uniqueWord = entry.getValue().get(i);
                System.out.println(RETREAT + uniqueWord + SPACE + Collections.frequency(wordList, uniqueWord));
            }
        }
    }

    private String getFirstValue(Map.Entry<String, List<String>> entry) {
        return entry.getValue().get(0);
    }
}