package sim.gate.playground;

import sim.gate.cell.CellWithInputMux;

import java.lang.reflect.Method;

public class TestRsLatch implements ITest {
    private int rows;
    private int cols;
    CellWithInputMux[][] cell;

    @Override
    public void execute() {
        scenario1();
    }

    private void scenario1() {
        connectGates();

        boolean[][] testInput = {
                //r     s
                {false, false},
                {false, true},
                {true, false},
                {false, false},
                {false, true},
                {true, true}
        };
        boolean[] result;
        for(int i = 0; i < testInput.length; i++) {
            boolean r = testInput[i][0];
            boolean s = testInput[i][1];
            for(int j = 0; j < 4; j++) {
                System.out.println(i + ") S:" + s + "  " + "R:" + r);
                result = testCircuit(r, s);
                System.out.println("   Q:" + result[0] + "   Q':" + result[1] + "\n");
            }
            System.out.println("\n");
        }


    }

    private boolean[] testCircuit(boolean r, boolean s) {
        cell[0][0].mux1SetInputs(new boolean[]{r, s});
        cell[0][0].mux2SetInputs(new boolean[]{r, s});

        cell[1][0].mux1SetInputs(new boolean[]{r, s});
        cell[1][0].mux2SetInputs(new boolean[]{r, s});

        cell[0][1].mux1SetInputs(new boolean[]{cell[1][1].getOutput(), cell[0][0].getOutput()});
        cell[0][1].mux2SetInputs(new boolean[]{cell[1][0].getOutput(), cell[1][0].getOutput()});

        cell[1][1].mux1SetInputs(new boolean[]{cell[0][1].getOutput(), cell[1][0].getOutput()});
        cell[1][1].mux2SetInputs(new boolean[]{cell[0][0].getOutput(), cell[0][0].getOutput()});

        boolean result[] = new boolean[2];
        result[0] = cell[0][1].getOutput();
        result[1] = cell[1][1].getOutput();
        return result;
    }

    private void connectGates() {
        int rows = 2;
        int cols = 2;
        cell = new CellWithInputMux[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cell[i][j] = new CellWithInputMux();
            }
        }

        cell[0][0].selectGate(10);
        cell[0][0].mux1SetSelectLinesNumber(1);
        cell[0][0].mux2SetSelectLinesNumber(1);
        cell[0][0].mux1SetSelectedInput(1);
        cell[0][0].mux2SetSelectedInput(0);

        cell[1][0].selectGate(10);
        cell[1][0].mux1SetSelectLinesNumber(1);
        cell[1][0].mux2SetSelectLinesNumber(1);
        cell[1][0].mux1SetSelectedInput(0);
        cell[1][0].mux2SetSelectedInput(0);

        cell[0][1].selectGate(1);
        cell[0][1].mux1SetSelectLinesNumber(1);
        cell[0][1].mux2SetSelectLinesNumber(1);
        cell[0][1].mux1SetSelectedInput(0);
        cell[0][1].mux2SetSelectedInput(0);

        cell[1][1].selectGate(1);
        cell[1][1].mux1SetSelectLinesNumber(1);
        cell[1][1].mux2SetSelectLinesNumber(1);
        cell[1][1].mux1SetSelectedInput(0);
        cell[1][1].mux2SetSelectedInput(0);
    }
}
