package com.training.sgorodecki.homework11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processor {

    private Folder root;
    private List<Folder> rootList;

    public Processor() {
        this.root = new Folder("root");
        this.rootList = new ArrayList<>();
        root.setFolders(rootList);
    }
    public Folder getRoot() {
        return root;
    }

    public void setRoot(Folder root) {
        this.root = root;
    }

    public Map<File, List<Folder>> getFoldersAndFileFromInput(String[] split) {
        Map<File, List<Folder>> map = new HashMap<>();
        List<Folder> folders = new ArrayList<>();
        File file = null;
        for (String string : split) {
            if (string.contains(".")) {
                file = new File(string);
            } else {
                Folder folder = new Folder(string);
                folders.add(folder);
            }
        }
        map.put(file, folders);
        return map;
    }

    public Folder getCompletedFolderFromMap(Map<File, List<Folder>> map) {
        Folder folder;
        List<Folder> folders = new ArrayList<>();
        folders = addFileIntoFolder(map, folders);
        folder = getFolderWithInnerFolders(folders);
        rootList.add(folder);
        return root;
    }

    private Folder getFolderWithInnerFolders(List<Folder> folders) {
        Folder folder = null;
        for (int i = folders.size() - 1; i > 0; i--) {
            folder = folders.get(i);
            folders.get(i - 1).setFolders(List.of(folder));
            folders.remove(i);
            folder = folders.get(0);
        }
        return folder;
    }

    private List<Folder> addFileIntoFolder(Map<File, List<Folder>> map, List<Folder> folders) {
        File file;
        for (Map.Entry<File, List<Folder>> entry : map.entrySet()) {
            file = entry.getKey();
            folders = entry.getValue();
            folders.get(folders.size() - 1).setFiles(new ArrayList<>());
            folders.get(folders.size() - 1).getFiles().add(file);
        }
        return folders;
    }
    public void downloadRootFromLastState(Folder folder){
        this.root = folder;
    }
}
