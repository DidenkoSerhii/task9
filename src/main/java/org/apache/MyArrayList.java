package org.apache;

public class MyArrayList {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(Object value) {
        if (size == elements.length) {
            
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }


    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return elements[index];


    }


 public static class Main {
        public static void main(String[] args) {
            MyArrayList list = new MyArrayList();
            list.add("Hello");
            list.add("World");
            System.out.println("Size: " + list.size());
            System.out.println("Get 0: " + list.get(0));
            System.out.println("Get 1: " + list.get(1));
            list.remove(0);
            System.out.println("Size after removing element 0: " + list.size());
            System.out.println("Get 0 after removing element 0: " + list.get(0));
            list.clear();
            System.out.println("Size after calling clear(): " + list.size());
        }
    }
}
