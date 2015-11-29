package sim.gate.cell.gate;

import sim.gate.cell.gate.type.*;

public enum EGate {
    Always0(new Always0()),
    Nor(new Nor()),
    AAndNotB(new AAndNotB()),
    NotB(new NotB()),
    NotAAndB(new NotAAndB()),
    NotA(new NotA()),
    Xor(new Xor()),
    Nand(new Nand()),
    And(new And()),
    Xnor(new Xnor()),
    TransferA(new TransferA()),
    AOrNotB(new AOrNotB()),
    TransferB(new TransferB()),
    NotAOrB(new NotAOrB()),
    Or(new Or()),
    Always1(new Always1());

    private Gate gate;

    EGate(Gate gate) {
        this.gate = gate;
    }

    public Gate getGate() {
        return gate;
    }


}
