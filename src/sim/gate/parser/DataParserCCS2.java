package sim.gate.parser;

import sim.gate.cell.CellWithInputMux;
import sim.gate.grid.CCS2Configuration;

public class DataParserCCS2 {

    private int[] dataInput;
    private CCS2Configuration configuration;

    public DataParserCCS2(CCS2Configuration configuration) {
        this.configuration = configuration;
    }

    public CCS2Configuration parse() {
        validateInput();

        CellWithInputMux tempCell = new CellWithInputMux();

        int j = 0;
        for (int i = 1; i <= configuration.rows; i++) {
            // only fist cell uses 2 bytes
            tempCell.mux1SetSelectLinesNumber(calculateSelectLinesNumberFromInputs(configuration.inputs));
            tempCell.mux2SetSelectLinesNumber(calculateSelectLinesNumberFromInputs(configuration.inputs));
            tempCell.mux1SetSelectedInput(inputMuxA4Bit(dataInput[j]));
            tempCell.mux2SetSelectedInput(inputMuxB4Bit(dataInput[j]));
            j++;
            tempCell.selectGate(cell4Bit(dataInput[j]));
            configuration.cell.add(tempCell);

            for (j++; j < (configuration.cols + 1) * i; j++) { // every other uses 1 byte
                tempCell.mux1SetSelectLinesNumber(1); // 1 by the ccs2 hardware implementation
                tempCell.mux2SetSelectLinesNumber(1);
                tempCell.mux1SetSelectedInput(inputMuxA2Bit(dataInput[j]));
                tempCell.mux2SetSelectedInput(inputMuxB2Bit(dataInput[j]));
                tempCell.selectGate(cell4Bit(dataInput[j]));
                configuration.cell.add(tempCell);
            }
        }
        configuration.outMux = new int[configuration.outputs]; // outputs
//        for (int i = 0; i < configuration.outputs; i++) {
//            configuration.outMux[i] = dataInput[i];
//        }
        System.arraycopy(dataInput, 0, configuration.outMux, 0, configuration.outputs);

        return configuration;
    }

    private int calculateSelectLinesNumberFromInputs(int inputs) {
        int var = 1;
        int i;
        for (i = 0; i < 32; i++) { //the int is 32 bits
            if (inputs <= var) {
                break;
            } else {
                var = var << 1;
            }

        }
        return i;
    }

    private void validateInput() {
        assert (!(dataInput == null || configuration == null));
        assert ((configuration.cols >= 1 && configuration.rows >= 1));
    }

    public CCS2Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(CCS2Configuration configuration) {
        this.configuration = configuration;
    }

    public int[] getDataInput() {
        return dataInput;
    }

    public void setDataInput(int[] dataInput) {
        this.dataInput = dataInput;
    }

    private int inputMuxA4Bit(int var) {
        return Bitwise.returnThe4LowBits(var);
    }

    private int inputMuxB4Bit(int var) {
        return Bitwise.shift4AndReturnThe4LowBits(var);
    }

    private int cell4Bit(int var) {
        return Bitwise.returnThe4LowBits(var);
    }

    private int inputMuxA2Bit(int var) {
        return Bitwise.shift4AndReturnThe2LowBits(var);
    }

    private int inputMuxB2Bit(int var) {
        return Bitwise.shift6AndReturnThe2LowBits(var);
    }

    private int output(int var) {
        return var;
    }

}
