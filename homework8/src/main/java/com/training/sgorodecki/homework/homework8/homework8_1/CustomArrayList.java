package com.training.sgorodecki.homework.homework8.homework8_1;

import java.util.Arrays;

public class CustomArrayList<E> {
    public static final int MAX_CAPACITY = 5;

    private int size;
    private Object[] elements = new Object[MAX_CAPACITY];

    public int size() {
        return size;
    }

    public boolean add(E e) {
        if (size < MAX_CAPACITY) {
            elements[size] = e;
            size++;
            return true;
        } else {
            throw new IndexOutOfBoundsCustomException("List is full and consist five elements");
        }
    }

    public E get(int index) {
        if (index < MAX_CAPACITY) {
            return (E) elements[index];
        } else {
            throw new IndexOutOfBoundsCustomException("Index is bigger than max capacity:" + MAX_CAPACITY);
        }
    }

    public E remove(int index) {
        if (index < MAX_CAPACITY) {
            E removedElement = (E) elements[index];
            if (index == size - 1) {
                elements[index] = null;
            } else {
                for (int i = index; i < size - 1; i++) {
                    elements[i] = elements[i + 1];
                }
                elements[size - 1] = null;
            }
            size--;
            return removedElement;
        } else {
            throw new IndexOutOfBoundsCustomException("Index is bigger than max capacity:" + MAX_CAPACITY);
        }
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
            size = 0;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}