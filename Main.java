import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

//
class Main {

    private static void KeepCountingGame() {


       System.out.println("Keep Counting");
       System.out.println("-------------");
        System.out.println("""
                You will be presented with 10 addition questions.
                After the first question, the left-hand operand\s
                is the result of the previous addition.\s
                """);

        Scanner scanChoice = new Scanner(System.in);
        int tally = 0;
        out.println("Press enter to start..");
        scanChoice.nextLine();

        Random random = new Random();
        int number1 = random.nextInt(10);
        // The for loop generates the 10 random number
        for (int i = 0; i <= 10; i++) {

            int number2 = random.nextInt(10);

            int Calculate = random.nextInt(2);
            // This if statement says that if the number is a positive number than it will continue the game
            if (Calculate == 1) {
                System.out.println("The sum: " + number1 + " - " + number2 + " = ");
                int Userguess = scanChoice.nextInt();
                int sum = number1 - number2;
                number1 = sum;
                if (Userguess == sum) {
                    tally += 1; // this is adding 1 to the tally
                } else { // if the user has input an incorrect number then this message will print out below
                    out.println("Your answer was incorrect, the answer was " + sum);
                    out.println("you managed to get " + tally + " questions correct");
                    break;
                }

                // The code below is telling the user what they answer should have been.
            } else {
                out.println("The sum " + number1 + " + " + number2 + " = ");
                int Userguess = scanChoice.nextInt();
                int sum = number1 + number2;
                number1 = sum;
                if (Userguess == sum) {
                    tally += 1;
                } else {
                    out.println("Your answer was incorrect, the answer was " + sum);
                    out.println("you managed to get " + tally + " questions correct");
                    break;
                }
            }
        }
        out.println("you have completed the game");
    }



    private static void CheckDigitGenerator() {
        out.println("Check-Digit Calculator");
        out.println("--------------------------");

        out.println("""
                This calculator will take a 5-digit number
                and generate a trailing 6th check digit
                Please enter 5-digit number to generate final code:\s
                """);

        // This allows the user to input 5 digit number
        Scanner scanChoice = new Scanner(System.in);
        int number = scanChoice.nextInt();
        int whole_number1 = number / 10000;
        int whole_number2 = number / 1000;
        int whole_number3 = number / 100;
        int whole_number4 = number / 10;
        int whole_number5 = number % 10;

        // This calculation allows the user to format output of the 6th digit by using calculation below.
        int sum = (7 * (whole_number1 + whole_number3 + whole_number5) + (3 * (whole_number2 + whole_number4)));


        //  Once the calculation  finds the remainder from the calculation from above and divide it by 10 as seen below
        int remainder = sum % 10;

        // Once you get the remainder using the method above.
        //take the remainder from 10 to allow the user to get the 6 digit.
        int output6 = 10 - remainder;


        // Once you have calculated the 6th digit
        out.println(" The number is:" + number + output6);
    }



    private static void CheckDigitChecker(){


        out.println("Check-Digit Checker");
        out.println("------------------------------------");
        out.println(" Please enter 6-digit number to check: ");

        // This allows the user to input 6 digit number
        // Instead of having 5 digit number from Check digit generator we know have 6th digit
        Scanner scanChoice = new Scanner(System.in);
        int number = scanChoice.nextInt();
        int whole_number1 = number / 100000;
        int whole_number2 = number / 10000;
        int whole_number3 = number / 1000;
        int whole_number4 = number / 100;
        int whole_number5 = number %100;
        int whole_number7 = number %10;

        // Using the formula from the Check digit generator above this code below is valid or invalid.
        // The formula was used from the Assignment brief Mini Java apps
        int sum = 7 * (whole_number1 + whole_number3 + whole_number5) + (3 * (whole_number2 + whole_number4));
        int remainder = sum % 10;
        int whole_number6 = 10 - remainder;

        // if the whole number 7 is equal to whole number 6 then its valid else its invalid.
        if (whole_number7 == whole_number6){
            out.println("The number is valid");
        }
        else {
            out.println("invalid number");
        }

    }

    public static void main(String[] args) {

        Scanner scanChoice = new Scanner(in);

        // This will display the menu system.
        out.println("P4CS Mini Applications");
        out.println("----------------------");
        out.println("1. Keep Counting Game");
        out.println("2. Check-Digit Generator");
        out.println("3. Check-Digit Checker");
        out.println("4. exit");
        out.println("Please enter option:");

        int option = scanChoice.nextInt();


        // This switch statement directs the user to appropriate apps.
        boolean Menu = true;
        while (Menu) switch (option) {
            case 1:
                KeepCountingGame();
            case 2:
                CheckDigitGenerator();
            case 3:
                CheckDigitChecker();
            case 9:
                Menu = false;
        }
    }
}
