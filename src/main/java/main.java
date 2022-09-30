import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        try {
            //setting the arrayList of the values
            
            System.out.println("Welcome to currency converter");
            System.out.println("Please choose an option 1/2 :");
            System.out.println("1. Dollars to Shekels");
            System.out.println("2. Shekels to Dollars");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            System.out.println("Please enter an amount to convert");
            double amount = scanner.nextDouble();
            double value = 0;
            if (option == 1) {
                Coin ilsValue = CoinFactory.getCoinInstance(Coins.USD);
                value = ilsValue.calculate(amount);
            } else if (option == 2) {
                Coin usdValue = CoinFactory.getCoinInstance(Coins.ILS);
                value = usdValue.calculate(amount);
            } else {
                System.out.println("you have entered a wrong input pls try again..");
                return;
            }
            System.out.println("the result is: " + value);
        }catch (InputMismatchException e){
            System.out.println("pls enter 1 / 2 only");
        }




    }
}
