package sim.gate.grid;

import sim.gate.cell.CellWithInputMux;

import java.util.ArrayList;
import java.util.List;

public class CCS2CircuitConfiguration {
    public List<CellWithInputMux> cell;
    public int[] outMux;
    public int rows;
    public int cols;
    public int inputs;
    public int outputs;

    public CCS2CircuitConfiguration() {
        cell = new ArrayList<>();
    }

    @Override
    public String toString() {
        String out = "";
        for (CellWithInputMux temp : cell) {
            out += temp.toString() + "\n";
        }
        return out;
    }
}
