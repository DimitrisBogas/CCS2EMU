package sim.gate.cell.gate;

import sim.gate.cell.Gate;

public class Xor extends Gate {
    @Override
    protected boolean internalFunction() {
        return inputA ^ inputB;
    }
}
