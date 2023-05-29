package com.training.sgorodecki.homework5;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessorTest extends TestCase {
    private Processor processor;
    private File file;
    private Folder folder;
    private Folder folder1;
    private String[] strings;

    public void setUp() throws Exception {
        processor = new Processor();
        file = new File("cc.txt");
        folder = new Folder("aa");
        folder1 = new Folder("bb");
        strings = new String[]{"aa", "bb", "cc.txt"};
    }

    @Test
    public void testGetFoldersAndFileFromInput() {
        Map<File, List<Folder>> expected = new HashMap<>();
        List<Folder> list = new ArrayList<>();
        list.add(folder);
        list.add(folder1);
        expected.put(file, list);

        Map<File, List<Folder>> actual = processor.getFoldersAndFileFromInput(strings);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCompletedFolderFromMap() {
        Map<File, List<Folder>> map = new HashMap<>();
        List<Folder> list = new ArrayList<>();
        list.add(folder);
        list.add(folder1);
        map.put(file, list);

        folder1.setFiles(List.of(file));
        folder.setFolders(List.of(folder1));
        List<Folder> rootList = new ArrayList<>();
        rootList.add(folder);

        Folder expected = new Folder("root");
        expected.setFolders(rootList);

        Folder actual = processor.getCompletedFolderFromMap(map);

        Assert.assertEquals(expected, actual);
    }

}