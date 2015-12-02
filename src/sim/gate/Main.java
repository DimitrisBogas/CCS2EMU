package sim.gate;

import sim.gate.emulator.Emulator;
import sim.gate.emulator.EmulatorCCS2;
import sim.gate.playground.ITest;
import sim.gate.playground.TestCCS2;

public class Main {

    public static void main(String[] args) {
        Emulator emulator = new EmulatorCCS2();

        ITest test = new TestCCS2();//TestRsLatch();//TestCell();//TestGateConnections();
        test.execute();
    }

}
