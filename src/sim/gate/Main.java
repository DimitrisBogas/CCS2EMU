package sim.gate;

import sim.gate.playground.ITest;
import sim.gate.playground.TestCCS2;

public class Main {

    public static void main(String[] args) {
        ITest test = new TestCCS2();//TestRsLatch();//TestCell();//TestGateConnections();
        test.execute();
    }

}
