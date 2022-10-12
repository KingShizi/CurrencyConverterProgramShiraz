package coin_utils;

public class ILS extends Coin {

    static private final double value = 0.28;

    @Override
    protected Double getValue() {
        return value;
    }

    @Override
    public double calculate(double value) {

        return value * getValue();
    }
}
