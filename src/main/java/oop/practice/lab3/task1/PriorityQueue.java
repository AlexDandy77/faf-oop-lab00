package oop.practice.lab3.task1;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    private Comparable<T>[] elements; // Use Comparable for sorting
    private int capacity;
    private int size;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Comparable[capacity]; // Explicitly create an array of Comparable
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        // Find the correct position for the new element
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (element.compareTo((T) elements[i]) < 0) {
                elements[i + 1] = elements[i]; // Shift larger elements to the right
            } else {
                break; // Stop when the correct position is found
            }
        }

        // Insert the new element
        elements[i + 1] = element;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) elements[--size]; // Remove the last element (highest-priority)
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
