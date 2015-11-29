package sim.gate.cell;

import sim.gate.cell.gate.EGate;
import sim.gate.cell.gate.Gate;
import sim.gate.cell.gate.GateFactory;

public class Cell {
    protected Gate gate;

    public Cell() {
        selectGate(EGate.Always0.getGate());
    }

    public Cell(int gateTypeId) {
        selectGate(gateTypeId);
    }

    public Cell(Gate gateClass) {
        selectGate(gateClass);
    }

    public void selectGate(int gateTypeId) {
        gate = GateFactory.createGateWithId(gateTypeId);
    }

    public void selectGate(Gate gateClass) {
        gate = gateClass;
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

    public Gate getGate() {
        return gate;
    }

    public int getGateId() {
        int gateTypeId = -1;
        for (EGate gate : EGate.values()) {
            if (gate.getGate() == this.gate) {
                gateTypeId = gate.ordinal();
                break;
            }
        }
        return gateTypeId;
    }

    @Override
    public String toString() {
        return gate.toString();
    }

}
