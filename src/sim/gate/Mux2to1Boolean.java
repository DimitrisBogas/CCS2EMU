package sim.gate;

public class Mux2to1Boolean {
    private boolean selectPin;

    public Mux2to1Boolean() {
        selectPin = false;
    }

    public Mux2to1Boolean(boolean selectPin) {
        this.selectPin = selectPin;
    }

    public boolean getSelectPin() {
        return selectPin;
    }

    public void setSelectPin(boolean selectPin) {
        this.selectPin = selectPin;
    }

    public boolean getOutput(boolean inputA, boolean inputB) {
        return selectPin ? inputB : inputA;
    }

}
