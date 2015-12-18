package sim.gate.playground;

import sim.gate.emulator.EmulatorCCS2;

public class TestEmulator implements ITest {
    EmulatorCCS2 emulator;

    @Override
    public void execute() {
        scenario1();
    }

    private void scenario1() {
        int[] inputString = {1, 10, 71, 0, 10, 7, 0, 1};
        int inputs = 2;
        int outputs = 2;
        int rows = 2;
        int cols = 2;

        boolean[][] testInput = {
                //s     r
                {true, false},
                {true, true},
                {false, true},
                {true, true},
                {false, false}
        };

        boolean[][] expectedOutput = {
                {false, true},
                {false, true},
                {true, false},
                {true, false},
                {true, true}
        };

        emulator = new EmulatorCCS2();
        emulator.setCircuitParameters(inputs, outputs, rows, cols);
        emulator.setTestPattern(testInput);
        emulator.setExpectedOutput(expectedOutput);
        emulator.setIterationDepth(3);
        emulator.setIterationDepthEvaluation(2);

        int hammingDistance = emulator.evaluate(inputString);
        System.out.println("hammingDistance = " + hammingDistance);

    }
}
