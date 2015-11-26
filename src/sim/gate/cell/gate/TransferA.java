package sim.gate.cell.gate;

import sim.gate.cell.Gate;

public class TransferA extends Gate {
    @Override
    protected boolean internalFunction() {
        return inputA;
    }
}
