import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.Character;

public class talspelet {
    static Scanner input = new Scanner(System.in);
    static boolean isDifficultyEasy = false;
    static boolean isDifficultyNormal = false;
    static boolean isDifficultyHard = false;


    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Random rand = new Random();
        boolean isMultiplayer = false;
        System.out.println("Welcome... rules");
        System.out.println("How many players...");

        System.out.println("Which diff?");
        pickDifficulty();


    }

    public static int pickDifficulty() {
        int difficultyChoice = checkIfStringIsInteger(input.nextLine());
        switch (checkIfStringIsInteger(input.nextLine())) {
            case 1:
        }


    }

    public static int checkIfStringIsInteger(String inputFromUser) {
        int convertedToString = 0;
        boolean checkStringProcess = true;
        while (checkStringProcess) {
            try {
                for (int i = 0; i < inputFromUser.length() - 1; i++) {
                    if (!Character.isDigit(inputFromUser.charAt(i))) {
                        System.out.println("Wrong input!");
                        break;
                    } else {
                        checkStringProcess = false;
                        convertedToString = Integer.parseInt(inputFromUser);

                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Number is too big!");
            }

        }
        return convertedToString;

    }


}

