package sim.gate.cell.gate.type;

import sim.gate.cell.gate.Gate;

public class Xor extends Gate {
    @Override
    protected boolean internalFunction() {
        return inputA ^ inputB;
    }
}