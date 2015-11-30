package sim.gate.playground;

import sim.gate.cell.Cell;
import sim.gate.cell.gate.EGate;

public class TestEnum implements ITest {
    @Override
    public void execute() {
        scenario3();
    }

    private void scenario1() {
        for (EGate gate : EGate.values()) {
            System.out.println(gate.getGate());
        }
    }

    private void scenario2() {
        System.out.println(EGate.values()[15].getGate());
    }

    private void scenario3() {
        int gateId = EGate.Or.ordinal();
        Cell cell = new Cell(gateId);

        System.out.println(cell.getGateId());
        System.out.println(EGate.values()[cell.getGateId()]);
    }
}
