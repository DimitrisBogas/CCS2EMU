package sim.gate.parser;

public class Bitwise {
    private Bitwise() {
    }

    public static int lowNibble(int var) {
        return var & 0b00001111;
    }

    public static int highNibble(int var) {
        return (var >> 4) & 0b00001111;
    }

    public static int highNibbleLowSemiNibble(int var) {
        return highNibble(var) & 0b00000011;
    }

    public static int highNibbleHighSemiNibble(int var) {
        return (highNibble(var) >> 2) & 0b00000011;
    }
}