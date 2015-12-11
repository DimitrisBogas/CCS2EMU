package sim.gate.parser;

import sim.gate.grid.CCS2Configuration;

public class InputValidator {
    private CCS2Configuration grid;
    private int expectedArraySize;


    //validates:
    // correct array size
    // invalid configuration // TODO: 9/12/15  
    public void calculateExpectedArraySize() {
        expectedArraySize = (grid.rows * grid.cols) + grid.rows + grid.outputs;

    }

    public void checkForInvalidConfiguration() {

    }


}
