package org.apache;

import java.util.Arrays;

public class MyHashMap {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node[] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    public void put(Object key, Object value) {
        if (loadFactor() > DEFAULT_LOAD_FACTOR) {
            resizeTable(table.length * 2);
        }

        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    public Object get(Object key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void remove(Object key) {
        int index = hash(key);
        Node current = table[index];
        Node previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    private float loadFactor() {
        return (float) size / table.length;
    }

    private void resizeTable(int newLength) {
        Node[] newTable = new Node[newLength];

        for (Node node : table) {
            Node current = node;
            while (current != null) {
                Node next = current.next;
                int index = hash(current.key);
                current.next = newTable[index];
                newTable[index] = current;
                current = next;
            }
        }

        table = newTable;
    }

    private int hash(Object key) {
        int hash = key.hashCode();
        return Math.abs(hash % table.length);
    }

    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }public static class Main {
        public static void main(String[] args) {
            MyHashMap map = new MyHashMap();

            map.put("One", 1);
            map.put("Two", 2);
            map.put("Three", 3);

            System.out.println("Size: " + map.size());

            System.out.println("Value for key 'Two': " + map.get("Two"));

            map.remove("Two");

            System.out.println("Size after removal: " + map.size());

            map.clear();

            System.out.println("Size after clearing: " + map.size());
        }
    }
}