package com.training.sgorodecki.homework5;

import java.util.List;
import java.util.Objects;

public class Folder {
    private String name;
    private List<File> files;
    private List<Folder> folders;

    private static final String SLASH = "/";
    private static final String START_INTEND = "   ";

    public Folder(String name) {
        this.name = name;
    }

    public Folder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public void printFolderWithFile(String intend) {
        System.out.println(intend + name + SLASH);
        intend = intend + START_INTEND;
        List<Folder> folders = getFolders();
        printFolder(intend, folders);
    }

    private void printFolder(String intend, List<Folder> folders) {
        if (Objects.nonNull(folders)) {
            for (Folder folder : folders) {
                intend = intend + START_INTEND;
                System.out.println(intend + folder.getName() + SLASH);
                printFolder(intend, folder.getFolders());

                if (Objects.nonNull(folder.getFiles())) {
                    printFile(intend, folder);
                }
                intend = START_INTEND;
            }
        }
    }

    private void printFile(String intend, Folder folder) {
        for (File file : folder.getFiles()) {
            if (Objects.nonNull(file)) {
                intend = intend + START_INTEND;
                System.out.println(intend + file.toString());
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return Objects.equals(name, folder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}