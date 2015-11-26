package sim.gate.cell.gate;

import sim.gate.cell.Gate;

public class Or extends Gate {
    @Override
    protected boolean internalFunction() {
        return inputA || inputB;
    }

}