package oop.practice.lab3.task1;

public interface Queue<T> {
    void enqueue(T element);  // Add an element to the queue
    T dequeue();              // Remove and return the front element
    boolean isEmpty();        // Check if the queue is empty
    int size();               // Get the number of elements
}
