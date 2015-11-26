package sim.gate.cell;

import sim.gate.cell.gate.*;

public class Cell {
    protected Gate gate;
    protected int gateType;

    public Cell() {
        gateType = 0;
        selectGate(gateType);

    }
    public Cell(int gateType) {
        this.gateType = gateType;
        selectGate(gateType);
    }

    protected void selectGate(int gateType) {
        this.gateType = gateType;
        switch (gateType) {
            case 0: gate = new Always0(); break;
            case 1: gate = new Nor(); break;
            case 2: gate = new AAndNotB(); break;
            case 3: gate = new NotB(); break;
            case 4: gate = new NotAAndB(); break;
            case 5: gate = new NotA(); break;
            case 6: gate = new Xor(); break;
            case 7: gate = new Nand(); break;
            case 8: gate = new And(); break;
            case 9: gate = new Xnor(); break;
            case 10: gate = new TransferA(); break;
            case 11: gate = new AOrNotB(); break;
            case 12: gate = new TransferB(); break;
            case 13: gate = new NotAOrB(); break;
            case 14: gate = new Or(); break;
            default: gate = new Always1(); break;
        }
    }
    public final boolean getInputA() {
        return gate.getInputA();
    }
    public final boolean getInputB() {
        return gate.getInputB();
    }
    public final boolean getOutput() {
        return gate.getOutput();
    }
    public final void setInputA(boolean inputA) {
        gate.setInputA(inputA);
    }
    public final void setInputB(boolean inputB) {
        gate.setInputB(inputB);
    }
    @Override
    public String toString() {
        return gate.toString();
    }



}
