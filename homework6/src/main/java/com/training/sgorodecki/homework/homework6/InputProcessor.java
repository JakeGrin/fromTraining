package com.training.sgorodecki.homework.homework6;

import java.util.Scanner;

public class InputProcessor {
    public String getInputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please,enter text");
        return scanner.nextLine();
    }
}
