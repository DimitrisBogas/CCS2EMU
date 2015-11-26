package sim.gate.playground;

import sim.gate.cell.Cell;
import sim.gate.cell.CellWithInputMux;
import sim.gate.cell.Mux;

public class TestCell implements ITest {

    @Override
    public void execute() {
        //scenario1();
        scenario2();
        //scenario3();
    }

    private void scenario1() {
        Cell cell = new Cell();

        //cell.inputA("false")
    }

    private void scenario2() {
        int rows = 3;
        int cols = 3;
        CellWithInputMux[][] cell = new CellWithInputMux[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cell[i][j] = new CellWithInputMux();
            }
        }

        cell[1][1].mux1SetInputs(new boolean[]{cell[2][0].getOutput(), cell[0][1].getOutput()});
        cell[1][1].mux2SetInputs(new boolean[]{cell[0][0].getOutput(), cell[0][2].getOutput()});
        boolean result = cell[1][1].getOutput();
        System.out.println(result);
//        Mux mux = new Mux();
//        printBooleanArray(mux.getInputs());
//        boolean[] a = null;
//        printBooleanArray(a);
    }

    private void scenario3() {
        CellWithInputMux cell = new CellWithInputMux();
        cell.mux1SetInputs(new boolean[]{true, false});
        cell.mux2SetInputs(new boolean[]{false, true});
        cell.getOutput();

    }

    private void printBooleanArray(boolean[] array) {
        for (boolean element : array) {
            System.out.println(element);
        }
    }

}
