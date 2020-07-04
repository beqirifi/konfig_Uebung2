import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerQueueTestGeneric {
    private static int testnmr = 1;

    @BeforeEach
    public void setup() {
        System.out.println("Start unit " + testnmr);
    }

    @AfterEach
    public void end() {
        System.out.println("Unit test number " + testnmr + " finished");
        testnmr++;
    }

    /**
     * 1. Testing if the method offer() is adding Object to the queue.
     * 2. Testing if the method peek() is showing the head of queue.
     * */
    @Test
    @DisplayName("Testing method offer and peek with Object type of Integer ")
    public void testingOfferAndPeek() {
        QueueGeneric<Integer> sq = new QueueGeneric<>(4);
        assertTrue(sq.offer(1));
        assertEquals(sq.peek(), 1);
        assertTrue(sq.offer(2));
        assertEquals(sq.peek(), 1);
        assertTrue(sq.offer(3));
        assertEquals(sq.peek(), 1);
        assertTrue(sq.offer(4));
        assertEquals(sq.peek(), 1);
        assertFalse(sq.offer(5));
    }

    /**
     * 1. Testing if the method offer() is adding Object to the queue.
     * 2. Testing if the method peek() is showing the head of queue.
     * 3. Testing if the method poll() is showing the head of the queue and if it deletes it.
     * */
    @Test
    @DisplayName("Testing methods poll and peek ")
    public void testingPollAndPeek() {
        QueueGeneric<Double> sq = new QueueGeneric<>(4);
        sq.offer(1.0);
        sq.offer(2.1);
        sq.offer(4.1234);
        assertEquals(sq.peek(), 1.0);
        assertEquals(sq.poll(), 1.0);
        assertEquals(sq.peek(), 2.1);
        assertEquals(sq.peek(), 2.1);
        assertEquals(sq.poll(), 2.1);
        assertEquals(sq.peek(), 4.1234);
        sq.poll();
        assertNull(sq.peek());
    }

    /**
     * 1. Testing if the method offer() is adding Object to the queue.
     * 2. Testing if the method element() is showing the head of queue.
     *    and if it throws an exception when list is empty.
     * 3. Testing if the method remove() is removing the head of the queue
     *    and if it throws an exception when list is empty.
     * */
    @Test
    @DisplayName("Testing methods element and remove")
    public void testingElement() {
        QueueGeneric<Integer> sq = new QueueGeneric<>(4);
        sq.offer(1);
        sq.offer(2);
        sq.offer(3);
        assertEquals(sq.element(), 1);
        sq.remove();
        assertEquals(sq.element(), 2);
        sq.remove();
        assertEquals(sq.element(), 3);
        sq.remove();
        assertThrows(NoSuchElementException.class, () -> sq.element());
        assertThrows(NoSuchElementException.class,()->sq.remove());
    }
}

