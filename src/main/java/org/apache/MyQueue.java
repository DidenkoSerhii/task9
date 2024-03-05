package org.apache;

public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        Object value;
        Node next;

        Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (size == 0) {
            head = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.value;
    }

    public Object   poll() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object value = head.value;
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
        return value;
    }   public static class Main {
        public static void main(String[] args) {
            MyQueue queue = new MyQueue();

            queue.add("First");
            queue.add("Second");
            queue.add("Third");

            System.out.println("Size: " + queue.size());

            System.out.println("Peek: " + queue.peek());

            System.out.println("Poll: " + queue.poll());

            System.out.println("Size after poll: " + queue.size());

            queue.clear();

            System.out.println("Size after clearing: " + queue.size());
        }
    }
}