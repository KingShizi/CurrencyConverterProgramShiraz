public class USD extends Coin{

    static final double value = 3.52;

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public double calculate(double value) {

        return value * getValue();
    }
}
