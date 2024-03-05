package org.apache;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value, tail, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next != null) {
                current.next.prev = current;
            } else {
                tail = current;
            }
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;


    }   public static class Main {
        public static void main(String[] args) {
            MyLinkedList linkedList = new MyLinkedList();

            linkedList.add("First");
            linkedList.add("Second");
            linkedList.add("Third");

            System.out.println("Size: " + linkedList.size());

            System.out.println("Value at index 1: " + linkedList.get(1));

            linkedList.remove(1);

            System.out.println("Size after removal: " + linkedList.size());

            linkedList.clear();

            System.out.println("Size after clearing: " + linkedList.size());
        }
    }
}