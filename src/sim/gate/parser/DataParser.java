package sim.gate.parser;

import sim.gate.parser.function.IParseFunction;

public class DataParser {
    IParseFunction parseFunction;
    private byte dataSet[];

    public DataParser() {
        parseFunction = null;
    }

    public IParseFunction getParseFunction() {
        return parseFunction;
    }

    public void setParseFunction(IParseFunction parseFunction) {
        this.parseFunction = parseFunction;
    }

    public void parseData() {
        parseFunction.parseData(this);
    }

    public byte[] getDataSet() {
        return dataSet;
    }

    public void setDataSet(byte[] dataSet) {
        this.dataSet = dataSet;
    }


}
