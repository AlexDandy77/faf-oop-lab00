package oop.practice.lab3;

import java.util.PriorityQueue;

public class PriorityQueueImpl<T extends Comparable<T>> implements Queue<T> {
    private PriorityQueue<T> priorityQueue = new PriorityQueue<>();

    @Override
    public void enqueue(T element) {
        priorityQueue.add(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return priorityQueue.poll();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }
}
