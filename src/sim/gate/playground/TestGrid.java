package sim.gate.playground;

import sim.gate.cell.Mux;

public class TestGrid implements ITest {

    @Override
    public void execute() {
        int rows = 3;
        int cols = 3;

        long startTime = System.nanoTime();

        Mux[][] mux = new Mux[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) {
                    mux[i][j] = new Mux(i);
                } else {
                    mux[i][j] = new Mux(1);
                }
                int val = mux[i][j].getMaxInputs();
                System.out.println(val);
            }
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime / 1000 + " us");
    }
}
