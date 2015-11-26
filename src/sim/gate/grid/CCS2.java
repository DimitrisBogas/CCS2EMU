package sim.gate.grid;

import sim.gate.cell.CellWithInputMux;

public class CCS2 implements ISimGrid {
    private int rows;
    private int cols;
    private CellWithInputMux cell;

    @Override
    public void setupGridDimensions(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void initializeGrid() {
        initializeFirstColumn();
        initializeMiddleColumns();
        initializeLastColumn();
    }

    private void initializeFirstColumn () {

    }
    private void initializeMiddleColumns () {

    }

    private void initializeLastColumn () {

    }
}
