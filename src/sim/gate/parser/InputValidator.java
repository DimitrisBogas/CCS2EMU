package sim.gate.parser;

public class InputValidator {
    private int inputs;
    private int gridRows;
    private int gridCols;
    private int outputs;
    private int expectedArraySize;
    private byte[] inputArray;


    //validates:
    // correct array size
    // invalid configuration
    public void calculateExpectedArraySize() {
        // TODO: 2/12/15
        expectedArraySize = (gridCols * gridRows) + gridRows + outputs;

    }

    public void checkForInvalidConfiguration() {

    }


}
