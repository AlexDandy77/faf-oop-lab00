package oop.practice.lab3.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testSimpleQueue() {
        Queue<Integer> queue = new SimpleQueue<>(5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Verify size
        assertEquals(3, queue.size());

        // Dequeue elements and verify order
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());

        // Verify size after dequeues
        assertEquals(1, queue.size());

        // Add more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // Verify dequeue order
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertEquals(50, queue.dequeue());

        // Test empty queue behavior
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);
    }

    @Test
    void testCircularQueue() {
        Queue<Integer> queue = new CircularQueue<>(3);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Verify full queue behavior
        assertThrows(IllegalStateException.class, () -> queue.enqueue(40));

        // Dequeue elements
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());

        // Add more elements to wrap around
        queue.enqueue(40);
        queue.enqueue(50);

        // Verify dequeue order after wrap-around
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertEquals(50, queue.dequeue());

        // Test empty queue behavior
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);
    }

    @Test
    void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(5);

        // Enqueue elements
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(10);

        // Verify size
        assertEquals(3, queue.size());

        // Verify dequeue order (priority order)
        assertEquals(30, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(10, queue.dequeue());

        // Test empty queue behavior
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);

        // Add more elements
        queue.enqueue(50);
        queue.enqueue(40);

        // Verify dequeue order
        assertEquals(50, queue.dequeue());
        assertEquals(40, queue.dequeue());
    }
}
