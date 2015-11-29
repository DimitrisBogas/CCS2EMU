package sim.gate;

import sim.gate.playground.ITest;
import sim.gate.playground.TestRsLatch;

public class Main {

    public static void main(String[] args) {
        ITest test = new TestRsLatch();//TestCell();//TestGateConnections();
        test.execute();


    }

}
