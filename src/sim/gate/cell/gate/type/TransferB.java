package sim.gate.cell.gate.type;

import sim.gate.cell.gate.Gate;

public class TransferB extends Gate {
    @Override
    protected boolean internalFunction() {
        return inputB;
    }
}
