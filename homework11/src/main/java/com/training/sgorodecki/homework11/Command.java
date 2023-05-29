package com.training.sgorodecki.homework11;

public enum Command {
    ENTER("enter"),
    PRINT("print"),
    EXIT("exit"),
    DEFAULT(""),
    DOWNLOAD("download"),
    UPLOAD("upload");

    private final String userString;

    Command(String userString) {
        this.userString = userString;
    }

    public String getUserString() {
        return userString;
    }

    public static Command command(String userString) {
        for (Command command : values()) {
            if (command.getUserString().equalsIgnoreCase(userString)) {
                return command;
            }
        }
        return DEFAULT;
    }
}
