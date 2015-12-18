package sim.gate.emulator;

import sim.gate.grid.CCS2Configuration;
import sim.gate.grid.GridCCS2;
import sim.gate.parser.DataParserCCS2;

public class EmulatorCCS2 {
    private GridCCS2 simGrid;
    private DataParserCCS2 parser;
    private CCS2Configuration config;
    private boolean[][] testPattern;
    private boolean[][] expectedOutput;
    private boolean[][][] results;
    private int iterationDepth;
    private int iterationDepthEvaluation;

    public EmulatorCCS2() {
        simGrid = new GridCCS2();
        config = new CCS2Configuration();
        iterationDepth = 1;
    }

    public int getIterationDepthEvaluation() {
        return iterationDepthEvaluation;
    }

    public void setIterationDepthEvaluation(int iterationDepthEvaluation) {
        this.iterationDepthEvaluation = iterationDepthEvaluation;
    }

    public int getIterationDepth() {
        return iterationDepth;
    }

    public void setIterationDepth(int iterationDepth) {
        this.iterationDepth = iterationDepth;
    }

    public boolean[][][] getResults() {
        return results;
    }

    public boolean[][] getTestPattern() {
        return testPattern;
    }

    public void setTestPattern(boolean[][] testPattern) {
        this.testPattern = testPattern;
    }

    public boolean[][] getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(boolean[][] expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public void setCircuitParameters(int inputs, int outputs, int rows, int cols) {
        config.inputs = inputs;
        config.outputs = outputs;
        config.rows = rows;
        config.cols = cols;
        parser = new DataParserCCS2(config);
    }

    public int evaluate(int[] inputString) {
        config = parser.parse(inputString);
        simGrid.setConfig(config);

        emulate();

        return hammingDistance();
    }

    private void emulate() {
        results = new boolean[testPattern.length][iterationDepth][config.outputs];

        for (int i = 0; i < testPattern.length; i++) {
            for (int j = 0; j < iterationDepth; j++) {
                boolean[] temp;
                temp = simGrid.emulate(testPattern[i]);
                results[i][j] = temp;
            }
        }
    }

    private int hammingDistance() {
        int hammingDistance = 0;

        for (int i = 0; i < testPattern.length; i++) {
            for (int j = 0; j < config.outputs; j++) {
                if (results[i][iterationDepthEvaluation][j] != expectedOutput[i][j]) {
                    hammingDistance++;
                }
            }
        }

        return hammingDistance;
    }


}
