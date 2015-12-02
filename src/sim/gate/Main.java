package sim.gate;

import sim.gate.playground.ITest;
import sim.gate.playground.TestRsLatchWithNand;
import sim.gate.playground.TestRsLatchWithNor;

public class Main {

    public static void main(String[] args) {
        // Emulator emulator = new EmulatorCCS2();

        ITest test = new TestRsLatchWithNand();//TestCell();//TestGateConnections();
        test.execute();
    }

}
