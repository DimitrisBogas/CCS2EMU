package sim.gate.cell;

import sim.gate.cell.gate.Gate;

public class CellWithInputMux {
    private Cell cell;
    private Mux mux1;
    private Mux mux2;

    public CellWithInputMux() {
        cell = new Cell();
        mux1 = new Mux();
        mux2 = new Mux();
    }

    private boolean output() {
        cell.setInputA(mux1.getOutput());
        cell.setInputB(mux2.getOutput());
        return cell.getOutput();
    }

    public boolean getOutput() {
        return output();
    }

    public void selectGate(int gateTypeId) {
        cell.selectGate(gateTypeId);
    }

    public void selectGate(Gate gateClass) {
        cell.selectGate(gateClass);
    }

    public void mux1SetInputs(boolean[] inputs) {
        mux1.setInputs(inputs);
    }

    public void mux2SetInputs(boolean[] inputs) {
        mux2.setInputs(inputs);
    }

    public void mux1SetSelectedInput(int selectedInput) {
        mux1.setSelectedInput(selectedInput);
    }

    public void mux2SetSelectedInput(int selectedInput) {
        mux2.setSelectedInput(selectedInput);
    }

    public int mux1GetMaxInputs() {
        return mux1.getMaxInputs();
    }

    public int mux2GetMaxInputs() {
        return mux2.getMaxInputs();
    }

    public void mux1SetSelectLinesNumber(int selectLinesNumber) {
        mux1.setSelectLinesNumber(selectLinesNumber);
    }

    public void mux2SetSelectLinesNumber(int selectLinesNumber) {
        mux2.setSelectLinesNumber(selectLinesNumber);
    }

    public boolean mux1GetOutput() {
        return mux1.getOutput();
    }

    public boolean mux2GetOutput() {
        return mux2.getOutput();
    }

}
