package oop.practice.lab3;

import java.util.LinkedList;

public class SimpleQueue<T> implements Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void enqueue(T element) {
        list.addLast(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
