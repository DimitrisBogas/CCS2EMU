package sim.gate.grid;

import sim.gate.cell.CellWithInputMux;


public class GridCCS2 implements ISimGrid {
    private int rows;
    private int cols;
    private CellWithInputMux[][] cell;
    private CCS2Configuration inputCircuit;

    public GridCCS2() {
        rows = 0;
        cols = 0;
    }

    public GridCCS2(int rows, int cols) {
        setupGridDimensions(rows, cols);
        //initializeGrid();
    }

    public CCS2Configuration getInputCircuit() {
        return inputCircuit;
    }

    public void setInputCircuit(CCS2Configuration inputCircuit) {
        this.inputCircuit = inputCircuit;
    }

    @Override
    public void setupGridDimensions(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        //initializeGrid();
    }

    @Override
    public void initializeGrid() {
        initializeArray();
        configureGrid();
    }

    private void configureGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cell[i][j] = inputCircuit.cell.iterator().next();
            }
        }
    }

    private void initializeArray() {
        assert (isDimensionSet());

        cell = new CellWithInputMux[rows][cols];
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
        return rows > 0;
    }

    private boolean isColsSet() {
        return cols > 0;
    }

    public boolean[] emulate(boolean[] evaluationInput) {
        firstCol(evaluationInput);
        everyOtherColumn();
        return getResult();
    }

    private boolean[] getResult() {
        boolean[] results = new boolean[inputCircuit.outputs];
        int lastColumn = cols - 1;
        for (int i = 0; i < inputCircuit.outputs; i++) {
            results[i] = cell[i][lastColumn].getOutput();
        }
        return results;
    }

    private void everyOtherColumn() {
        int secondColumn = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = secondColumn; j < cols; j++) {
                cell[i][j].mux1SetInputs(new boolean[]{
                        cell[muxA1Row(i)][muxA1Col(j)].getOutput(),
                        cell[muxA2Row(i)][muxA2Col(j)].getOutput()
                });
                cell[i][j].mux2SetInputs(new boolean[]{
                        cell[muxB1Row(i)][muxB1Col(j)].getOutput(),
                        cell[muxB2Row(i)][muxB2Col(j)].getOutput()
                });
            }
        }
    }

    private void firstCol(boolean[] input) {
        int firstColumn = 0;
        for (int i = 0; i < rows; i++) {
            cell[i][firstColumn].mux1SetInputs(input);
            cell[i][firstColumn].mux2SetInputs(input);
        }
    }

    private int muxA1Row(int row) {
        int i;
        if (row - 1 < 0) {
            i = rows - 1; // cylindrical grid
        } else {         //if < 0 then go to the bottom line
            i = row - 1;
        }
        return i;
    }

    private int muxA1Col(int col) {
        return col;
    }

    private int muxA2Row(int row) {
        return row;
    }

    private int muxA2Col(int col) {
        return col - 1;
    }

    private int muxB1Row(int row) {
        return muxA1Row(row);
    }

    private int muxB1Col(int col) {
        return col - 1;
    }

    private int muxB2Row(int row) {
        int i;
        if (row + 1 >= rows) { // if there is not next line
            i = 0; // go to the first
        } else {
            i = row + 1;
        }
        return i;
    }

    private int muxB2Col(int col) {
        return col - 1;
    }



}
