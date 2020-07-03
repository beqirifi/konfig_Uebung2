import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

class StringQueueTest {
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

    @Test
    @DisplayName("Testing method offer and peek")
    public void testingOfferAndPeek() {
        StringQueue sq=new StringQueue(4);
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
        assertNull(sq.peek());
    }

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
    }
}