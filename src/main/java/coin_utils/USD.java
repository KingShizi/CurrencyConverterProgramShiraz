package coin_utils;

public class USD extends Coin {

    static private final double value = 3.52;

    @Override
    protected Double getValue() {
        return value;
    }

    @Override
    public double calculate(double value) {

        return value * getValue();
    }
}
