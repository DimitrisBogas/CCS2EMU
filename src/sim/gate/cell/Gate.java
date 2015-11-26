package sim.gate.cell;

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
    }

    public final boolean getInputB() {
        return inputB;
    }

    public final void setInputB(boolean inputB) {
        this.inputB = inputB;
    }

    public final boolean getOutput() {
        output = internalFunction();
        return output;
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String inpA = "A:" + (inputA?"1":"0");
        String inpB = "B:" + (inputB?"1":"0");
        String out = "O:" + (getOutput()?"1":"0");
        String n = "\n";
        String s = "  ";

        return className + n + inpA + s + inpB + s + out + n;
    }

}
