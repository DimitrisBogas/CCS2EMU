package sim.gate.playground;

import sim.gate.cell.CellWithInputMux;
import sim.gate.cell.gate.EGate;
import sim.gate.grid.CCS2CircuitConfiguration;
import sim.gate.grid.GridCCS2;

public class TestCCS2 implements ITest {
    GridCCS2 grid;
    @Override
    public void execute() {
        scenario1();
    }

    private void scenario1() {
        boolean[][] testInput = {
                //s     r
                {true, false},
                {true, true},
                {false, true},
                {true, true},
                {false, false}
        };

        grid = new GridCCS2(rsLatch());

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
        return grid.emulate(new boolean[]{r, s});
    }

    private CCS2CircuitConfiguration rsLatch() {
        CCS2CircuitConfiguration inputCircuit = new CCS2CircuitConfiguration();

        inputCircuit.inputs = 2;
        inputCircuit.outputs = 2;
        inputCircuit.cols = 2;
        inputCircuit.rows = 2;
        inputCircuit.outMux = new int[]{1, 0};

        CellWithInputMux tempCell1 = new CellWithInputMux();
        tempCell1.selectGate(EGate.TransferA.getGate());
        tempCell1.mux1SetSelectLinesNumber(1);
        tempCell1.mux2SetSelectLinesNumber(1);
        tempCell1.mux1SetSelectedInput(1);
        tempCell1.mux2SetSelectedInput(0);

        CellWithInputMux tempCell2 = new CellWithInputMux();
        tempCell2.selectGate(EGate.Nand.getGate());
        tempCell2.mux1SetSelectLinesNumber(1);
        tempCell2.mux2SetSelectLinesNumber(1);
        tempCell2.mux1SetSelectedInput(0);
        tempCell2.mux2SetSelectedInput(0);

        CellWithInputMux tempCell3 = new CellWithInputMux();
        tempCell3.selectGate(EGate.TransferA.getGate());
        tempCell3.mux1SetSelectLinesNumber(1);
        tempCell3.mux2SetSelectLinesNumber(1);
        tempCell3.mux1SetSelectedInput(0);
        tempCell3.mux2SetSelectedInput(0);

        CellWithInputMux tempCell4 = new CellWithInputMux();
        tempCell4.selectGate(EGate.Nand.getGate());
        tempCell4.mux1SetSelectLinesNumber(1);
        tempCell4.mux2SetSelectLinesNumber(1);
        tempCell4.mux1SetSelectedInput(0);
        tempCell4.mux2SetSelectedInput(0);


        inputCircuit.cell.add(tempCell1);
        inputCircuit.cell.add(tempCell2);
        inputCircuit.cell.add(tempCell3);
        inputCircuit.cell.add(tempCell4);
        return inputCircuit;
    }
}
