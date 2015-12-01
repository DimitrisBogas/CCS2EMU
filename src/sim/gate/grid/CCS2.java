package sim.gate.grid;

import sim.gate.cell.CellWithInputMux;


public class CCS2 implements ISimGrid {
    private int rows;
    private int cols;
    private CellWithInputMux[][] cell;

    private CCS2() {

    }

    public CCS2(int rows, int cols) throws Exception {
        setupGridDimensions(rows, cols);
        initializeGrid();
    }

    @Override
    public void setupGridDimensions(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void initializeGrid() throws Exception {
        initializeArray();
        initializeFirstColumn();
        initializeMiddleColumns();
        initializeLastColumn();
    }

    private void initializeArray() throws Exception {
        if (!isDimensionSet()) {
            throw new Exception("cols and rows parameters is not set.");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cell[i][j] = new CellWithInputMux();
            }
        }
    }

    private boolean isDimensionSet() {
        return isRowsSet() && isColsSet();
    }

    private boolean isRowsSet() {
        return rows > 0;// ? true : false;
    }

    private boolean isColsSet() {
        return cols > 0;// ? true : false;
    }

    private void initializeFirstColumn() {

    }

    private void initializeMiddleColumns() {

    }

    private void initializeLastColumn() {

    }
}
