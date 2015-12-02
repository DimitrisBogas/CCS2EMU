package sim.gate.parser;

import sim.gate.parser.function.ParseCCS2Function;

public class DataParserCCS2 extends DataParser {
    //private DataStructureCCS2

    public DataParserCCS2() {
        parseFunction = new ParseCCS2Function();
    }

    @Override
    public void setData() {

    }
}
