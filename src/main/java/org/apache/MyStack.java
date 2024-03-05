package org.apache;

public class MyStack {
    private Object[] elements;
    private int size;

    public MyStack() {
        elements = new Object[10];
        size = 0;
    }

    public void push(Object value) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size] = value;
        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        Object value = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return value;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        return elements[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }public static class Main {
        public static void main(String[] args) {
            MyStack stack = new MyStack();

            stack.push("One");
            stack.push("Two");
            stack.push("Three");

            System.out.println("Size: " + stack.size());

            System.out.println("Peek: " + stack.peek());

            System.out.println("Pop: " + stack.pop());

            System.out.println("Size after pop: " + stack.size());

            stack.clear();

            System.out.println("Size after clearing: " + stack.size());
        }
    }
}