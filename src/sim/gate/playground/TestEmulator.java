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
        int iterationDepth = 3;
        int iterationDepthEvaluation = 1;


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
        emulator.setIterationDepth(iterationDepth);
        emulator.setIterationDepthEvaluation(iterationDepthEvaluation);


        int hammingDistance = emulator.evaluate(inputString);
        print3DArray(emulator.getResults(), testInput.length, iterationDepth, outputs);
        System.out.println("hammingDistance = " + hammingDistance);

    }

    private void print3DArray(boolean[][][] array, int x, int y, int z) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    System.out.printf("[%d][%d][%d] = %b \t", i, j, k, array[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
