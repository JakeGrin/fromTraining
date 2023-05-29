package com.training.sgorodecki.homework.homework6;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();
        String text = inputProcessor.getInputText();

        TextEditor textEditor = new TextEditor();
        List<String> listOfWords = textEditor.getListOfWords(text);

        Set<String> setOfUniqueWords = textEditor.getSetOfUniqueWords(listOfWords);

        Set<String> firstLetters = textEditor.getFirstLetters(listOfWords);

        Map<String, List<String>> coincidenceWordsAndLetters = textEditor.findCoincidenceWordsAndLetters(firstLetters, setOfUniqueWords);

        textEditor.printEditedText(coincidenceWordsAndLetters, listOfWords);
    }
}