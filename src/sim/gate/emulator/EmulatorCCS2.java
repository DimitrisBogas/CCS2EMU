package sim.gate.emulator;

import sim.gate.grid.GridCCS2;

public class EmulatorCCS2 extends Emulator {
    public EmulatorCCS2() {
        simGrid = new GridCCS2();
        //parser = new DataParserCCS2();
    }

}
