package sim.gate.playground;

import sim.gate.grid.CCS2Configuration;
import sim.gate.grid.GridCCS2;
import sim.gate.parser.DataParserCCS2;

public class TestParser implements ITest {
    GridCCS2 grid;

    @Override
    public void execute() {
        scenario1();

    }

    private void scenario1() {
        byte[] inputString = {1, 10, 71, 0, 10, 7, 0, 1};

        CCS2Configuration conf = new CCS2Configuration();
        conf.inputs = 2;
        conf.outputs = 2;
        conf.rows = 2;
        conf.cols = 2;

        DataParserCCS2 parser = new DataParserCCS2(conf);
        parser.setDataInput(inputString);
        conf = parser.parse();

        boolean[][] testInput = {
                //s     r
                {true, false},
                {true, true},
                {false, true},
                {true, true},
                {false, false}
        };

        grid = new GridCCS2(conf);

        boolean[] result;
        for (int i = 0; i < testInput.length; i++) {
            boolean s = testInput[i][0];
            boolean r = testInput[i][1];

            for (int j = 0; j < 3; j++) {
                System.out.print(i + ") S:" + s + "  " + "R:" + r);
                result = testCircuit(r, s);
                System.out.println("\t  Q:" + result[0] + "   Q':" + result[1]);
            }
            System.out.println();
        }

    }

    private boolean[] testCircuit(boolean r, boolean s) {
        return grid.emulate(new boolean[]{r, s});
    }
}
