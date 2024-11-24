package oop.practice.lab3;

public class CircularQueue<T> implements Queue<T> {
    private T[] buffer;
    private int head, tail, count;

    public CircularQueue(int capacity) {
        buffer = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
        count = 0;
    }

    @Override
    public void enqueue(T element) {
        if (count == buffer.length) {
            throw new IllegalStateException("Queue is full.");
        }
        buffer[tail] = element;
        tail = (tail + 1) % buffer.length;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T element = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
