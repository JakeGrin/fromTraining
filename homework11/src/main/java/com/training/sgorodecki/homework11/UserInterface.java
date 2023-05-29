package com.training.sgorodecki.homework11;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private final Processor processor = new Processor();
    private final InputManager inputManager = new InputManager();
    private final InputOutput inputOutput = new InputOutput();
    private static final String COMMAND_MESSAGE = "Type ENTER for creating object in file system" + "\n" +
            "Type PRINT for printing file system" + "\n" + "Type EXIT for exit" + "\n" +
            "Type DOWNLOAD for downloading last state of system" + "\n" + "Type UPLOAD for saving current state of system";
    private static final String FILE_SYSTEM_IS_SAVED = "File system is saved";
    private static final String LAST_STATE_IS_DOWNLOADED = "Last state is downloaded";
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
            case DOWNLOAD:
                processor.downloadRootFromLastState(inputOutput.readStateOfSystem());
                System.out.println(LAST_STATE_IS_DOWNLOADED);
                workWithUser();
                break;
            case UPLOAD:
                inputOutput.writeStateOfSystem(processor.getRoot());
                System.out.println(FILE_SYSTEM_IS_SAVED);
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
