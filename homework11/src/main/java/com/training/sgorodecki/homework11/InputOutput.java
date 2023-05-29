package com.training.sgorodecki.homework11;

import java.io.*;

public class InputOutput {
    private static final String INTEND = "";
    private static final String ROOT_STORAGE = "StateOfSystem.bin";

    public void writeStateOfSystem(Folder folder) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ROOT_STORAGE))) {
            outputStream.writeObject(folder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Folder readStateOfSystem() {
        Folder folder;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ROOT_STORAGE))) {
            folder = (Folder) inputStream.readObject();
            folder.printFolderWithFile(INTEND);
        } catch (IOException | ClassNotFoundException e) {
            return new Folder("root");
        }
        return folder;
    }
}