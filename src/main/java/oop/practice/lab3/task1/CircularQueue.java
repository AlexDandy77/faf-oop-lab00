package oop.practice.lab3.task1;

public class CircularQueue<T> implements Queue<T> {
    private T[] elements;       // Array to store elements
    private int capacity;       // Maximum size of the queue
    private int head;           // Index of the front element
    private int tail;           // Index where the next element will be added
    private int size;           // Current number of elements

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        elements[tail] = element;               // Add element at tail
        tail = (tail + 1) % capacity;           // Wrap around if needed
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T front = elements[head];
        head = (head + 1) % capacity;           // Move head forward
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
