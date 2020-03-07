import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.Character;

public class talspelet {
    static Scanner input = new Scanner(System.in);
    static boolean isDifficultyEasy = false;
    static boolean isDifficultyNormal = false;
    static boolean isDifficultyHard = false;
    static boolean isMultiplayer = false;


    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Random rand = new Random();
        boolean isMultiplayer = false;
        System.out.println("Welcome... rules");
        System.out.println("How many players...");
        checkIfMultiplayer()
        System.out.println("Which diff?");
        pickDifficulty();


    }

    public static boolean checkIfMultiplayer() {
        boolean testAmountOfplayer = true;
        System.out.println("How many players? (1-2");
        while(testAmountOfplayer){
            int intToTest = checkIfStringIsInteger();
            if (intToTest == 1){
                isMultiplayer = false;
                return isMultiplayer; //returns false for multiplayer
            }
            else if (intToTest == 2){
                isMultiplayer = true;
                return isMultiplayer; //returns true for multiplayer
            }
            else{
                System.out.println("This is an invalid input. Please input either 1 or 2.");
            }
        }
        return false;
    }

    public static boolean pickDifficulty() {
        System.out.println("Type the number that corresponds to your desired diff...............");
        System.out.println("(1) Easy");
        System.out.println("(2) Normal");
        System.out.println("(3) Hard");

        switch (checkIfStringIsInteger()) {
            case 1: //Easy
                return isDifficultyEasy = true;
            case 2: //Normal
                return isDifficultyNormal = true;
            case 3: //Hard
                return isDifficultyHard = true;
            default: //Any input that is not 1, 2 or 3.
                System.out.println("The number you entered is invalid. Please enter a number between 1-3.");
        }
        return false;
    }

    public static int checkIfStringIsInteger() {
        int convertedToInteger = 0;
        String inputFromUser = "";
        boolean checkStringProcess = true;

        while (checkStringProcess) {
            try {
                inputFromUser = input.nextLine();
                checkStringProcess = false;
            }
            catch(InputMismatchException e){
                    System.out.println("Your input is too large!");
                    checkStringProcess = true;
            }
        }

        for (int i = 0; i < inputFromUser.length() - 1; i++) {
            if (!Character.isDigit(inputFromUser.charAt(i))) {
                System.out.println("Wrong input!");
                break;
            }

            else {
                convertedToInteger = Integer.parseInt(inputFromUser);
            }
        }
        return convertedToInteger;
    }
}




