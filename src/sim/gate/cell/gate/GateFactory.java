package sim.gate.cell.gate;

public final class GateFactory {
    private GateFactory() {

    }

    public static Gate createGateWithId(int gateId) {
        return EGate.values()[gateId].getGate();
    }


}
