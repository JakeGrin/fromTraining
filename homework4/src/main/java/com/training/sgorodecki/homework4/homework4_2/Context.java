package com.training.sgorodecki.homework4.homework4_2;

public class Context {
    private Sorter sorter;

    public Sorter getSorter() {
        return sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public int[] manage(int[] array) {
        return sorter.sort(array);
    }
}

