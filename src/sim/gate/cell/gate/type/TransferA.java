package sim.gate.cell.gate.type;

import sim.gate.cell.gate.Gate;

public class TransferA extends Gate {
    @Override
    protected boolean internalFunction() {
        return inputA;
    }
}
