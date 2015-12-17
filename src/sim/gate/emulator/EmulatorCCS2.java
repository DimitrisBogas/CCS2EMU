package sim.gate.emulator;

import sim.gate.grid.CCS2Configuration;
import sim.gate.grid.GridCCS2;
import sim.gate.parser.DataParserCCS2;

public class EmulatorCCS2 {
    GridCCS2 simGrid;
    DataParserCCS2 parser;
    CCS2Configuration config;

    public EmulatorCCS2() {
        simGrid = new GridCCS2();
        config = new CCS2Configuration();

    }

    public void setupCircuit(int inputs, int outputs, int rows, int cols) {
        config.inputs = inputs;
        config.outputs = outputs;
        config.rows = rows;
        config.cols = cols;
        parser = new DataParserCCS2(config);
    }

    public int emulate(int[] inputString) {
        parser.setDataInput(inputString);
        config = parser.parse();
        boolean[] results = simGrid.emulate(new boolean[]{false, false}); // TODO: 18/12/2015  iterator
        return 1; // TODO: 18/12/2015 change me
    }



}
