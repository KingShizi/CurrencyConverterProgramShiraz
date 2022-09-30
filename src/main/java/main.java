
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        //setting the arrayList of the values.
        ArrayList<Double> results = new ArrayList<Double>();

        //Welcome screen
        System.out.println("Welcome to currency converter");

        while (true) {

        //try-catch to catch exeptions from user input on welcome screen
        try {
            //setting the users input types into variables.
            int option = 1;
            double value = 0;
            String startOverAnswer = null;

            //Choice Screen
            System.out.println("Please choose an option 1/2 :");
            System.out.println("1. Dollars to Shekels");
            System.out.println("2. Shekels to Dollars");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            while (isOptionValid(option)) {

                //try-catch to catch exceptions from user input for converter.
                try {
                    System.out.println("Please enter an amount to convert");
                    Scanner scanner2 = new Scanner(System.in);
                    double amount = scanner2.nextDouble();

                    //Calling the calculate function for the chosen coin.
                    if (option == 1) {
                        Coin ilsValue = CoinFactory.getCoinInstance(Coins.USD);
                        value = ilsValue.calculate(amount);
                    } else if (option == 2) {
                        Coin usdValue = CoinFactory.getCoinInstance(Coins.ILS);
                        value = usdValue.calculate(amount);
                    }

                    //Result Screen.
                    System.out.println("the result is: " + value);
                    results.add(value);

                    //Asking if the user want to start over.
                        System.out.println("Would you like to start over? [y / n]" );
                        Scanner scanner3 = new Scanner(System.in);
                        startOverAnswer = scanner3.next();
                        if (startOverAnswer.equalsIgnoreCase("y")) {
                            option = 0;
                        } else {
                            //End screen
                            System.out.println("Thank you for using our currency converter");
                            printResults(results);
                            writeResultsToFile(results);
                            return;
                        }

                } catch (InputMismatchException | IOException e) {
                    System.out.println("amount should be only in numbers (double)");
                    System.out.println("try again pls..");
                }
            }

        }catch(InputMismatchException e){
            System.out.println("pls enter 1 / 2 only");
        }

        }
    }

    //A method to use in case the users input isn't 1/2
    public static boolean isOptionValid(int option){
        if (option == 1 || option == 2){
            return true;
        }else {
            return false;
        }
    }

    //A method that prints all results.
    public static void printResults(ArrayList results){
        System.out.println("Thanks for using our currency converter");
        System.out.println("The previous results are:");

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    //A method that writes all the results the user got to a txt file.
    public static void writeResultsToFile(ArrayList results) throws IOException {

        String filePath = "/Users/shirazelbaz/Desktop/1.txt";
        for (int i = 0; i < results.size(); i++) {
            Files.writeString(Paths.get(filePath), results.get(i).toString()+"\n", StandardOpenOption.APPEND);
        }
    }


}


