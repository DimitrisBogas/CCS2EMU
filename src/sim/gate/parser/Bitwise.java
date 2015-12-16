package sim.gate.parser;

public class Bitwise {
    private Bitwise() {
    }

    public static int returnThe4LowBits(int var) {
        return var & 0b00001111;
    }

    public static int shift4AndReturnThe4LowBits(int var) {
        return (var >> 4) & 0b00001111;
    }

    public static int shift4AndReturnThe2LowBits(int var) {
        return (var >> 4) & 0b00000011;
    }

    public static int shift6AndReturnThe2LowBits(int var) {
        return (var >> 6) & 0b00000011;
    }
}