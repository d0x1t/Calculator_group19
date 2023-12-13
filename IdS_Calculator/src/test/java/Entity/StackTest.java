package Entity;

import calculator.Entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack stack = new Stack(null);

    @Test
    public void testSwapTSW01() {
        stack.push("1");
        stack.push("2");
        stack.swap();
        assertEquals("1", stack.pop());
        assertEquals("2", stack.pop());
    }

    @Test
    public void testOverTSO01() {
        stack.push("1");
        stack.push("2");
        stack.over();
        assertEquals("1", stack.pop());
        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
    }

    @Test
    public void testClearTSC01() {
        stack.push("1");
        stack.push("2");
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testClearTSC02() {
        stack.push("3");
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testDupTSP01() {
        stack.push("1");
        stack.dup();
        assertEquals("1", stack.pop());
        assertEquals("1", stack.pop());
    }

    @Test
    public void testDupTSP02() {
        stack.push("2");
        stack.push("3");
        stack.dup();
        assertEquals("3", stack.pop());
        assertEquals("3", stack.pop());
        assertEquals("2", stack.pop());
    }

    @Test
    public void testDropTSD01() {
        stack.push("1");
        stack.push("2");
        stack.drop();
        assertEquals("1", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testDropTSD02() {
        stack.push("3");
        stack.drop();
        assertTrue(stack.isEmpty());
    }
}
