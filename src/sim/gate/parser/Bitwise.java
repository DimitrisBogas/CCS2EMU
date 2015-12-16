package sim.gate.parser;

public class Bitwise {
    private Bitwise() {
    }

    public static int inputMuxA4Bit(int var) {
        return var & 0b00001111;
    }

    public static int inputMuxB4Bit(int var) {
        return (var >> 4) & 0b00001111;
    }

    public static int cell4Bit(int var) {
        return var & 0b00001111;
    }

    public static int inputMuxA2Bit(int var) {
        return (var >> 4) & 0b00000011;
    }

    public static int inputMuxB2Bit(int var) {
        return (var >> 6) & 0b00000011;
    }
}