package sim.gate.playground;

import sim.gate.cell.CellWithInputMux;
import sim.gate.cell.gate.EGate;

public class TestRsLatchWithNand implements ITest {
    CellWithInputMux[][] cell;
    private int rows;
    private int cols;

    @Override
    public void execute() {
        scenario1();
    }

    private void scenario1() {
        configureCircuit();

        boolean[][] testInput = {
                //s     r
                {true, false},
                {true, true},
                {false, true},
                {true, true},
                {false, false}
        };
        boolean[] result;
        for (int i = 0; i < testInput.length; i++) {
            boolean s = testInput[i][0];
            boolean r = testInput[i][1];

            for (int j = 0; j < 3; j++) {
                System.out.print(i + ") \tS:" + (s ? 1 : 0) + "  R:" + (r ? 1 : 0));
                result = testCircuit(r, s);
                System.out.println("\t Q:" + (result[0] ? 1 : 0) + "  Q':" + (result[1] ? 1 : 0));
            }
            System.out.println();
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
        result[1] = cell[0][1].getOutput(); // q
        result[0] = cell[1][1].getOutput(); // q'
        return result;
    }

    private void configureCircuit() {
        int rows = 2;
        int cols = 2;
        cell = new CellWithInputMux[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cell[i][j] = new CellWithInputMux();
            }
        }

        cell[0][0].selectGate(EGate.TransferA.getGate());
        cell[0][0].mux1SetSelectLinesNumber(1);
        cell[0][0].mux2SetSelectLinesNumber(1);
        cell[0][0].mux1SetSelectedInput(1);
        cell[0][0].mux2SetSelectedInput(0);

        cell[1][0].selectGate(EGate.TransferA.getGate());
        cell[1][0].mux1SetSelectLinesNumber(1);
        cell[1][0].mux2SetSelectLinesNumber(1);
        cell[1][0].mux1SetSelectedInput(0);
        cell[1][0].mux2SetSelectedInput(0);

        cell[0][1].selectGate(EGate.Nand.getGate());
        cell[0][1].mux1SetSelectLinesNumber(1);
        cell[0][1].mux2SetSelectLinesNumber(1);
        cell[0][1].mux1SetSelectedInput(0);
        cell[0][1].mux2SetSelectedInput(0);

        cell[1][1].selectGate(EGate.Nand.getGate());
        cell[1][1].mux1SetSelectLinesNumber(1);
        cell[1][1].mux2SetSelectLinesNumber(1);
        cell[1][1].mux1SetSelectedInput(0);
        cell[1][1].mux2SetSelectedInput(0);
    }
}
