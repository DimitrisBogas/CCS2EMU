package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sim.gate.parser.Bitwise;

import static org.junit.Assert.assertEquals;

public class BitwiseTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHighNibbleHighSemiNibbleShouldReturn0() throws Exception {
        int input = 0b00110000;
        int expected = 0b00000000;
        int actual = Bitwise.highNibbleHighSemiNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHighNibbleHighSemiNibbleShouldReturn1() throws Exception {
        int input = 0b01100000;
        int expected = 0b00000001;
        int actual = Bitwise.highNibbleHighSemiNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHighNibbleHighSemiNibbleShouldReturn3() throws Exception {
        int input = -1;
        int expected = 0b00000011;
        int actual = Bitwise.highNibbleHighSemiNibble(input);
        assertEquals(expected, actual);
    }


    @Test
    public void testLowNibbleShouldReturn2() {
        int input = 2;
        int expected = 2;
        int actual = Bitwise.lowNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLowNibbleShouldReturn10() {
        int input = 0b01101010;
        int expected = 0b00001010;
        int actual = Bitwise.lowNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLowNibbleShouldReturn15() {
        int input = -1;
        int expected = 0b00001111;
        int actual = Bitwise.lowNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLowNibbleShouldReturn14() {
        int input = -2;
        int expected = 0b00001110;
        int actual = Bitwise.lowNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLowNibbleShouldNotAssert() {
        for (int i = 0; i < 256 + 2; i++) {
            assertEquals(i % 16, Bitwise.lowNibble(i));
        }
    }

    @Test
    public void testHighNibbleLowSemiNibbleShouldReturn0() throws Exception {
        int input = 0b11001111;
        int expected = 0b00000000;
        int actual = Bitwise.highNibbleLowSemiNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHighNibbleLowSemiNibbleShouldReturn2() throws Exception {
        int input = 0b01100000;
        int expected = 0b00000010;
        int actual = Bitwise.highNibbleLowSemiNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHighNibbleLowSemiNibbleShouldReturn3() throws Exception {
        int input = -1;
        int expected = 0b00000011;
        int actual = Bitwise.highNibbleLowSemiNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHighNibbleShouldReturn2() throws Exception {
        int input = 0b00100000;
        int expected = 0b00000010;
        int actual = Bitwise.highNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHighNibbleShouldReturn8() throws Exception {
        int input = 0b10000000;
        int expected = 0b00001000;
        int actual = Bitwise.highNibble(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHighNibbleShouldReturn15() throws Exception {
        int input = -2;
        int expected = 0b00001111;
        int actual = Bitwise.highNibble(input);
        assertEquals(expected, actual);
    }
}