package sim.gate.cell.gate;

public abstract class Gate {
    protected boolean inputA;
    protected boolean inputB;
    protected boolean output;

    public Gate() {
        inputA = false;
        inputB = false;
        output = false;
    }

    protected abstract boolean internalFunction();

    public final boolean getInputA() {
        return inputA;
    }

    public final void setInputA(boolean inputA) {
        this.inputA = inputA;
        getOutput();
    }

    public final boolean getInputB() {
        return inputB;
    }

    public final void setInputB(boolean inputB) {
        this.inputB = inputB;
        getOutput();
    }

    public final boolean getOutput() {
        final boolean activateDelay = true;

        boolean previousOutput = output;
        output = internalFunction();

        return activateDelay ? previousOutput : output;
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String inpA = "A:" + (inputA ? "1" : "0");
        String inpB = "B:" + (inputB ? "1" : "0");
        String out = "O:" + (output ? "1" : "0");
        String n = "\n";
        String s = "  ";

        return className + n + inpA + s + inpB + s + out;// + n;
    }

}
