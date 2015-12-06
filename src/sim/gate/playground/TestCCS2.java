package sim.gate.playground;

import sim.gate.grid.GridCCS2;

public class TestCCS2 implements ITest {
    @Override
    public void execute() {
        scenario1();
    }

    private void scenario1() {
        // TODO: 2/12/15 test rs latch in ccs2
        GridCCS2 grid = new GridCCS2();

        grid.setupGridDimensions(2, 2);

    }
}
