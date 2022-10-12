package coins_factory;

import coin_utils.Coin;
import coin_utils.ILS;
import coin_utils.USD;

public class CoinFactory {
    public static Coin getCoinInstance(Coins coin) {
        switch (coin){
            case ILS:
                return new ILS();
            case USD:
                return new USD();
        }

        return null;
    }
}
