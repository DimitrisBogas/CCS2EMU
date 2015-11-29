package sim.gate.cell.gate.type;

import sim.gate.cell.gate.Gate;

public class Nand extends Gate {
    @Override
    protected boolean internalFunction() {
        return !(inputA && inputB);
    }
}
