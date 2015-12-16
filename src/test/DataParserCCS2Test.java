package test;

import org.junit.Test;
import sim.gate.grid.CCS2Configuration;
import sim.gate.parser.DataParserCCS2;

import static org.junit.Assert.assertEquals;

public class DataParserCCS2Test {
    private DataParserCCS2 parser;
    private CCS2Configuration config;

    @org.junit.Before
    public void setUp() throws Exception {
        config = new CCS2Configuration();
        parser = new DataParserCCS2(config);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void cell4BitShouldReturn2() {
        byte input = 2;
        byte expected = 2;
        byte actual = parser.cell4Bit(input);
        assertEquals(expected, actual);
    }

    @Test
    public void cell4BitShouldReturn10() {
        byte input = 0b01101010;
        byte expected = 0b00001010;
        byte actual = parser.cell4Bit(input);
        assertEquals(expected, actual);
    }

}