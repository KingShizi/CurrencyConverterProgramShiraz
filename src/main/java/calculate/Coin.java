package calculate;

public abstract class Coin implements ICalculate {


    //An abstract method that will return the target.ILS and target.USD value when implemented.
    public abstract Double getValue();

    @Override
    public double calculate(double input) {

        return input;
    }
}

