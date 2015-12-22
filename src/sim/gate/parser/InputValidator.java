package sim.gate.parser;

import sim.gate.grid.CCS2CircuitConfiguration;

public class InputValidator {
    private CCS2CircuitConfiguration grid;
    private int expectedArraySize;


    //validates:
    // correct array size
    // invalid configuration // TODO: 9/12/15  
    public int calculateExpectedArraySize() {
        return (grid.rows * grid.cols) + grid.rows + grid.outputs;
    }

    public void checkForInvalidConfiguration() {

    }


}
