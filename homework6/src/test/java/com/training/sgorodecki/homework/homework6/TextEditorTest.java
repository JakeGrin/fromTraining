package com.training.sgorodecki.homework.homework6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TextEditorTest {
    private static final String WORD_FOR_EXAMPLE_FIRST = "Hello";
    private static final String WORD_FOR_EXAMPLE_SECOND = "World";
    private static final String TEXT = "Hello World";
    private static final String FIRST_LETTER_FOR_FIRST_WORD = "h";
    private static final String FIRST_LETTER_FOR_SECOND_WORD = "w";
    private TextEditor textEditor;

    @Before
    public void setUp() {
        textEditor = new TextEditor();
    }

    @Test
    public void testGetListOfWords() {
        List<String> expected = new ArrayList<>();
        expected.add(WORD_FOR_EXAMPLE_FIRST);
        expected.add(WORD_FOR_EXAMPLE_SECOND);
        String words = TEXT;

        List<String> actual = textEditor.getListOfWords(words);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstLetters() {
        Set<String> expected = new HashSet<>();
        expected.add(FIRST_LETTER_FOR_FIRST_WORD);
        expected.add(FIRST_LETTER_FOR_SECOND_WORD);
        List<String> words = new ArrayList<>();
        words.add(WORD_FOR_EXAMPLE_FIRST);
        words.add(WORD_FOR_EXAMPLE_SECOND);

        Set<String> actual = textEditor.getFirstLetters(words);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSetOfUniqueWords() {
        Set<String> expected = new HashSet<>();
        expected.add(WORD_FOR_EXAMPLE_FIRST);
        List<String> words = new ArrayList<>();
        words.add(WORD_FOR_EXAMPLE_FIRST);
        words.add(WORD_FOR_EXAMPLE_FIRST);

        Set<String> actual = textEditor.getSetOfUniqueWords(words);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindCoincidenceWordsAndLetters() {
        Map<String, List<String>> expected = new TreeMap<>();
        expected.put(FIRST_LETTER_FOR_FIRST_WORD, List.of(WORD_FOR_EXAMPLE_FIRST));
        expected.put(FIRST_LETTER_FOR_SECOND_WORD, List.of(WORD_FOR_EXAMPLE_SECOND));
        Set<String> letter = new HashSet<>();
        letter.add(FIRST_LETTER_FOR_FIRST_WORD);
        letter.add(FIRST_LETTER_FOR_SECOND_WORD);
        Set<String> words = new HashSet<>();
        words.add(WORD_FOR_EXAMPLE_FIRST);
        words.add(WORD_FOR_EXAMPLE_SECOND);

        Map<String, List<String>> actual = textEditor.findCoincidenceWordsAndLetters(letter, words);

        Assert.assertEquals(expected, actual);
    }
}