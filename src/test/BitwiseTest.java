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
    public void testInputMuxB2BitShouldReturn0() throws Exception {
        int input = 0b00110000;
        int expected = 0b00000000;
        int actual = Bitwise.shift6AndReturnThe2LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxB2BitShouldReturn1() throws Exception {
        int input = 0b01100000;
        int expected = 0b00000001;
        int actual = Bitwise.shift6AndReturnThe2LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxB2BitShouldReturn3() throws Exception {
        int input = -1;
        int expected = 0b00000011;
        int actual = Bitwise.shift6AndReturnThe2LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCell4BitShouldReturn2() {
        int input = 2;
        int expected = 2;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCell4BitShouldReturn10() {
        int input = 0b01101010;
        int expected = 0b00001010;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCell4BitShouldReturn15() {
        int input = -1;
        int expected = 0b00001111;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCell4BitShouldReturn14() {
        int input = -2;
        int expected = 0b00001110;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCell4BitShouldNotAssert() {
        for (int i = 0; i < 256 + 2; i++) {
            assertEquals(i % 16, Bitwise.returnThe4LowBits(i));
        }
    }

    @Test
    public void testInputMuxA4BitShouldReturn2() {
        int input = 2;
        int expected = 2;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxA4BitShouldReturn10() {
        int input = 0b01101010;
        int expected = 0b00001010;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxA4BitShouldReturn15() {
        int input = -1;
        int expected = 0b00001111;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxA4BitShouldReturn14() {
        int input = -2;
        int expected = 0b00001110;
        int actual = Bitwise.returnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxA4BitShouldNotAssert() {
        for (int i = 0; i < 256 + 2; i++) {
            assertEquals(i % 16, Bitwise.returnThe4LowBits(i));
        }
    }

    @Test
    public void testInputMuxA2BitShouldReturn0() throws Exception {
        int input = 0b11001111;
        int expected = 0b00000000;
        int actual = Bitwise.shift4AndReturnThe2LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxA2BitShouldReturn2() throws Exception {
        int input = 0b01100000;
        int expected = 0b00000010;
        int actual = Bitwise.shift4AndReturnThe2LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxA2BitShouldReturn3() throws Exception {
        int input = -1;
        int expected = 0b00000011;
        int actual = Bitwise.shift4AndReturnThe2LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxB4BitShouldReturn2() throws Exception {
        int input = 0b00100000;
        int expected = 0b00000010;
        int actual = Bitwise.shift4AndReturnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxB4BitShouldReturn8() throws Exception {
        int input = 0b10000000;
        int expected = 0b00001000;
        int actual = Bitwise.shift4AndReturnThe4LowBits(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testInputMuxB4BitShouldReturn15() throws Exception {
        int input = -2;
        int expected = 0b00001111;
        int actual = Bitwise.shift4AndReturnThe4LowBits(input);
        assertEquals(expected, actual);
    }
}