package com.training.sgorodecki.homework.homework14.service;

public class Main {
    public static void main(String[] args) {
        try {
            String mode = args[0];
            String method = args[1];
            String argument = args[2];
            Strategy strategy = new Strategy();
            strategy.execute(mode, method, argument);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new UnsupportedOperationException("Enter all parameters");
        }
    }
}