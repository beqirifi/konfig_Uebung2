import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StringQueueTestGeneric {
        private static int testnmr = 1;

        @BeforeEach
        public void setup() {
            System.out.println("Start unit "+testnmr);
        }

        @AfterEach
        public void end() {
            System.out.println("Unit test number "+testnmr+" finished");
            testnmr++;
        }

        /**
         * 1. Testing if the method offer() is adding Object to the queue.
         * 2. Testing if the method peek() is showing the head of queue.
         * */
        @Test
        @DisplayName("Testing methods offer and peek")
        public void testingOfferAndPeek() {
            QueueGeneric<String> sq=new QueueGeneric<String>(4);
            assertTrue(sq.offer("1st"));
            assertEquals(sq.peek(), "1st");
            assertTrue(sq.offer("2nd"));
            assertEquals(sq.peek(), "1st");
            assertTrue(sq.offer("3rd"));
            assertEquals(sq.peek(), "1st");
            assertTrue(sq.offer("4th"));
            assertEquals(sq.peek(), "1st");
            assertFalse(sq.offer("5th"));
        }

        /**
         * 1. Testing if the method offer() is adding Object to the queue.
         * 2. Testing if the method peek() is showing the head of queue.
         * 3. Testing if the method poll() is showing the head of the queue and if it deletes it.
         * */
        @Test
        @DisplayName("Testing methods poll and peek ")
        public void testingPollAndPeek() {
            StringQueue sq=new StringQueue(4);
            sq.offer("1st");
            sq.offer("2nd");
            sq.offer("3rd");
            assertEquals(sq.peek(),"1st");
            assertEquals(sq.poll(),"1st");
            assertEquals(sq.peek(),"2nd");
            assertEquals(sq.peek(),"2nd");
            assertEquals(sq.poll(),"2nd");
            assertEquals(sq.peek(),"3rd");
            sq.poll();
            assertNull(sq.poll());
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
        public void testingElement(){
            StringQueue sq= new StringQueue(4);
            sq.offer("1st");
            sq.offer("2nd");
            sq.offer("3rd");
            assertEquals(sq.element(),"1st");
            sq.remove();
            assertEquals(sq.element(),"2nd");
            sq.remove();
            assertEquals(sq.element(),"3rd");
            sq.remove();
            assertThrows(NoSuchElementException.class,()->sq.element());
            assertThrows(NoSuchElementException.class,()->sq.remove());
        }
    }
