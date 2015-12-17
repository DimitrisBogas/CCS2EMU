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

        int j = 0;
        for (int i = 1; i < configuration.rows + 1; i++) {
            configuration.cell.add(firstColumnCell(dataInput[j], dataInput[++j])); // only fist cell uses 2 bytes
            for (j++; j < (configuration.cols + 1) * i; j++) {
                configuration.cell.add(anyOtherCell(dataInput[j])); // every other uses 1 byte
            }
        }
        configuration.outMux = new int[configuration.outputs]; // outputs
        for (int i = 0; i < configuration.outputs; i++) {
            configuration.outMux[i] = dataInput[i + j]; // continue from where we left
        }

        return configuration;
    }

    private CellWithInputMux firstColumnCell(int firstVar, int secondVar) {
        CellWithInputMux cell = new CellWithInputMux();
        cell.mux1SetSelectLinesNumber(calculateSelectLinesNumberFromInputs(configuration.inputs));
        cell.mux2SetSelectLinesNumber(calculateSelectLinesNumberFromInputs(configuration.inputs));
        cell.mux1SetSelectedInput(inputMuxA4Bit(firstVar));
        cell.mux2SetSelectedInput(inputMuxB4Bit(firstVar));
        cell.selectGate(cell4Bit(secondVar));
        return cell;
    }

    private CellWithInputMux anyOtherCell(int var) {
        CellWithInputMux cell = new CellWithInputMux();
        cell.mux1SetSelectLinesNumber(1);
        cell.mux2SetSelectLinesNumber(1);
        cell.mux1SetSelectedInput(inputMuxA2Bit(var));
        cell.mux2SetSelectedInput(inputMuxB2Bit(var));
        cell.selectGate(cell4Bit(var));
        return cell;
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
        return Bitwise.lowNibble(var);
    }

    private int inputMuxB4Bit(int var) {
        return Bitwise.highNibble(var);
    }

    private int cell4Bit(int var) {
        return Bitwise.lowNibble(var);
    }

    private int inputMuxA2Bit(int var) {
        return Bitwise.highNibbleLowSemiNibble(var);
    }

    private int inputMuxB2Bit(int var) {
        return Bitwise.highNibbleHighSemiNibble(var);
    }

    private int output(int var) {
        return var;
    }

}
