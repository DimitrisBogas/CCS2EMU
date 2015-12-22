package test;

import sim.gate.grid.CCS2CircuitConfiguration;
import sim.gate.parser.DataParserCCS2;

public class DataParserCCS2Test {
    private DataParserCCS2 parser;
    private CCS2CircuitConfiguration config;

    @org.junit.Before
    public void setUp() throws Exception {
        config = new CCS2CircuitConfiguration();
        parser = new DataParserCCS2(config);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

}