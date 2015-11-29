package sim.gate.cell;

import sim.gate.cell.gate.EGate;
import sim.gate.cell.gate.Gate;
import sim.gate.cell.gate.GateFactory;

public class Cell {
    protected Gate gate;

    public Cell() {
        selectGate(EGate.Always0);
    }

    public Cell(int gateTypeId) {
        selectGate(gateTypeId);
    }

    public Cell(EGate gateName) {
        selectGate(gateName);
    }

    public void selectGate(int gateTypeId) {
        gate = GateFactory.createGate(gateTypeId);
    }

    public void selectGate(EGate gateName) {
        gate = GateFactory.createGate(gateName);
    }

    public final boolean getInputA() {
        return gate.getInputA();
    }

    public final void setInputA(boolean inputA) {
        gate.setInputA(inputA);
    }

    public final boolean getInputB() {
        return gate.getInputB();
    }

    public final void setInputB(boolean inputB) {
        gate.setInputB(inputB);
    }

    public final boolean getOutput() {
        return gate.getOutput();
    }

    @Override
    public String toString() {
        return gate.toString();
    }

}
