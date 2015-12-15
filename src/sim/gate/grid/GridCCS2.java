package sim.gate.grid;

import sim.gate.cell.CellWithInputMux;


public class GridCCS2 implements ISimGrid {
    private CellWithInputMux[][] cell;
    private CCS2Configuration config;

    public GridCCS2() {

    }

    public GridCCS2(CCS2Configuration config) {
        setConfig(config);
    }

    private void initializeGrid() {
        initializeArray();
        configureGrid();
    }

    public CCS2Configuration getConfig() {
        return config;
    }

    public void setConfig(CCS2Configuration config) {
        this.config = config;
        initializeGrid();
    }

    private void configureGrid() {
        int x = 0;
        for (int row = 0; row < config.rows; row++) {
            for (int col = 0; col < config.cols; col++) {
                cell[row][col] = config.cell.get(x++);
            }
        }
    }

    private void initializeArray() {
        assert (isDimensionSet());

        cell = new CellWithInputMux[config.rows][config.cols];
        for (int i = 0; i < config.rows; i++) {
            for (int j = 0; j < config.cols; j++) {
                cell[i][j] = new CellWithInputMux();
            }
        }
    }

    private boolean isDimensionSet() {
        return isRowsSet() && isColsSet();
    }

    private boolean isRowsSet() {
        return config.rows > 0;
    }

    private boolean isColsSet() {
        return config.cols > 0;
    }

    public boolean[] emulate(boolean[] evaluationInput) {
        firstCol(evaluationInput);
        everyOtherColumn();
        return getResult();
    }

    private boolean[] getResult() {
        boolean[] results = new boolean[config.outputs];
        int lastColumn = config.cols - 1;
        for (int i = 0; i < config.outputs; i++) {
            results[i] = cell[i][lastColumn].getOutput();
        }
        return results;
    }

    private void everyOtherColumn() {
        int secondColumn = 1;

        for (int row = 0; row < config.rows; row++) {
            for (int col = secondColumn; col < config.cols; col++) {
                cell[row][col].mux1SetInputs(new boolean[]{
                        cell[muxA1Row(row)][muxA1Col(col)].getOutput(),
                        cell[muxA2Row(row)][muxA2Col(col)].getOutput()
                });
                cell[row][col].mux2SetInputs(new boolean[]{
                        cell[muxB1Row(row)][muxB1Col(col)].getOutput(),
                        cell[muxB2Row(row)][muxB2Col(col)].getOutput()
                });
            }
        }
    }

    private void firstCol(boolean[] input) {
        int firstColumn = 0;
        for (int i = 0; i < config.rows; i++) {
            cell[i][firstColumn].mux1SetInputs(input);
            cell[i][firstColumn].mux2SetInputs(input);
        }
    }

    private int muxA1Row(int row) {
        int i;
        if (row - 1 < 0) {
            i = config.rows - 1; // cylindrical grid
        } else { // if < 0 then go to the bottom line
            i = row - 1; // else return the upper row
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
        if (row + 1 >= config.rows) { // if there is not next line
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
