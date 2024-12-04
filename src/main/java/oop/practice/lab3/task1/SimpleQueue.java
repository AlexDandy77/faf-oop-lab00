package oop.practice.lab3.task1;

public class SimpleQueue<T> implements Queue<T> {
    private T[] elements;   // Array to store elements
    private int capacity;   // Maximum size of the queue
    private int size;       // Current number of elements

    public SimpleQueue(int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        elements[size++] = element; // Add element at the end
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T front = elements[0];
        // Shift all elements to the left
        for (int i=1; i<size; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        return front;
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
