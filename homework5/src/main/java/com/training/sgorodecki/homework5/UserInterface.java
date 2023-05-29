package com.training.sgorodecki.homework5;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private final Processor processor = new Processor();
    private final InputManager inputManager = new InputManager();

    private static final String COMMAND_MESSAGE = "Type ENTER for creating object in file system" + "\n" +
            "Type PRINT for printing file system" + "\n" + "Type EXIT for exit";
    private static final String WORK_IS_FINISHED = "Work is finished";
    private static final String WRONG_COMMAND = "Wrong command";

    public void workWithUser() {

        System.out.println(COMMAND_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Command command = Command.command(input);

        switch (command) {
            case ENTER:
                Map<File, List<Folder>> folders = processor.getFoldersAndFileFromInput(inputManager.getScanner());
                processor.getCompletedFolderFromMap(folders);
                workWithUser();
                break;
            case PRINT:
                processor.getRoot().printFolderWithFile("");
                workWithUser();
                break;
            case EXIT:
                System.out.println(WORK_IS_FINISHED);
                break;
            case DEFAULT:
                System.out.println(WRONG_COMMAND);
                workWithUser();
                break;
        }
    }
}
