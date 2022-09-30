package coinsFactory;

import calculate.Coin;

public class ILS extends Coin {

    static final double value = 0.28;

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public double calculate(double value) {

        return value * getValue();
    }
}
