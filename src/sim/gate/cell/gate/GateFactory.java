package sim.gate.cell.gate;

import sim.gate.cell.gate.type.*;

public final class GateFactory {
    private GateFactory() {

    }

    public static Gate createGate(int gateId) {
        Gate gate;
        switch (gateId) {
            case 0:
                gate = new Always0();
                break;
            case 1:
                gate = new Nor();
                break;
            case 2:
                gate = new AAndNotB();
                break;
            case 3:
                gate = new NotB();
                break;
            case 4:
                gate = new NotAAndB();
                break;
            case 5:
                gate = new NotA();
                break;
            case 6:
                gate = new Xor();
                break;
            case 7:
                gate = new Nand();
                break;
            case 8:
                gate = new And();
                break;
            case 9:
                gate = new Xnor();
                break;
            case 10:
                gate = new TransferA();
                break;
            case 11:
                gate = new AOrNotB();
                break;
            case 12:
                gate = new TransferB();
                break;
            case 13:
                gate = new NotAOrB();
                break;
            case 14:
                gate = new Or();
                break;
            default:
                gate = new Always1();
                break;
        }
        return gate;
    }

    public static Gate createGate(EGate gateName) {
        Gate gate;
        switch (gateName) {
            case Always0:
                gate = new Always0();
                break;
            case Nor:
                gate = new Nor();
                break;
            case AAndNotB:
                gate = new AAndNotB();
                break;
            case NotB:
                gate = new NotB();
                break;
            case NotAAndB:
                gate = new NotAAndB();
                break;
            case NotA:
                gate = new NotA();
                break;
            case Xor:
                gate = new Xor();
                break;
            case Nand:
                gate = new Nand();
                break;
            case And:
                gate = new And();
                break;
            case Xnor:
                gate = new Xnor();
                break;
            case TransferA:
                gate = new TransferA();
                break;
            case AOrNotB:
                gate = new AOrNotB();
                break;
            case TransferB:
                gate = new TransferB();
                break;
            case NotAOrB:
                gate = new NotAOrB();
                break;
            case Or:
                gate = new Or();
                break;
            default:
                gate = new Always1();
                break;
        }
        return gate;
    }


}
