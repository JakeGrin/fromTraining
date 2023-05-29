package com.training.sgorodecki.homework11;

import java.util.Scanner;

public class InputManager {

    private static final String START_MESSAGE = "Please,enter path to folder or file";
    private static final String SLASH = "/";
    private static final String DOT = ".";

    public String[] getScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(START_MESSAGE);
        String input = scanner.nextLine();
        if (isValid(input)) {
            return input.split(SLASH);
        } else {
            throw new UnsupportedOperationException("Unsupported data input");
        }
    }

    private boolean isValid(String input) {
        if (!input.contains(SLASH)) {
            return false;
        }
        String[] split = input.split(SLASH);
        for (int i = 0; i < split.length - 1; i++) {
            if (split[i].contains(DOT)) {
                return false;
            }
        }
        return true;
    }
}
