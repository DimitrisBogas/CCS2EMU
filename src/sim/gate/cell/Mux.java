package sim.gate.cell;

public class Mux {
    private int selectedInput;
    private int selectLinesNumber;
    private int maxInputs;
    private boolean[] inputs;

    public Mux() {
        setSelectLinesNumber(1); // 1 line = 2 inputs
        setSelectedInput(0); // select first input
    }

    public Mux(int selectLinesNumber) {
        setSelectLinesNumber(selectLinesNumber);
    }

    public void setSelectLinesNumber(int selectLinesNumber) {
        this.selectLinesNumber = selectLinesNumber;
        setupMaxInputs();
    }

    public boolean getOutput() {
        return inputs[this.selectedInput];
    }

    public boolean[] getInputs() {
        return inputs;
    }

    public void setInputs(boolean[] inputs) {
        this.inputs = inputs;
    }

    public int getMaxInputs() {
        return maxInputs;
    }

    public void setMaxInputs(int maxInputs) {
        this.maxInputs = maxInputs;
    }

    public int getSelectedInput() {
        return selectedInput;
    }

    public void setSelectedInput(int selectedInput) {
        if (selectedInput > this.maxInputs - 1 || selectedInput < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.selectedInput = selectedInput;
    }

    private void setupMaxInputs() {
        if (this.selectLinesNumber <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int base2 = 2;
        this.maxInputs = (int) Math.pow(base2, this.selectLinesNumber);
        initializeInputs();
    }

    private void initializeInputs() { // check if in reinitialization the lost of state of inputs create any trouble
        inputs = new boolean[maxInputs];
        for (int i = 0; i < maxInputs; i++) {
            inputs[i] = false;
        }
    }

    @Override
    public String toString() {
        String str = new String();
        for (int i = 0; i < inputs.length; i++) {
            str += "inp[" + i + "]:" + inputs[i] + ",  ";
        }
        str += "sel:" + selectedInput + ",  out:" + getOutput();

        return str;
    }


}
