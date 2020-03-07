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
    static int correctAnswer = 0;
    static boolean gameIsStarted = true;
    static int playerGuessCounter = 0;
    static int playerTurnIndicator = 1;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome... rules");

        System.out.println("How many players...");
        checkIfMultiplayer();

        System.out.println("Which diff?");
        pickDifficulty();
        randomNumberGenerator();
        if (isMultiplayer){
            multiplayerGame();
        }
        else{
            singleplayerGame();
        }

    }

    public static void multiplayerGame() {
        if (isDifficultyEasy){
            while(gameIsStarted){
                playerTurnIndicator = 1;
                System.out.println("Player One, make your guess!");
                difficultyEasy(checkIfStringIsInteger());
                playerTurnIndicator = 2;
                System.out.println("Player Two, make your guess");
                difficultyEasy(checkIfStringIsInteger());
                playerGuessCounter++;
            }

        }
        else if (isDifficultyNormal){

        }
        else{
            diffhard
        }
    }

    public static void singleplayerGame() {
        if (isDifficultyEasy){

        }
        else if (isDifficultyNormal){

        }
        else{
            diffhard
        }
    }

    public static void difficultyEasy(int playerGuess) {
        if(playerGuess == correctAnswer){
            printResult();
        }
        else if(playerGuess < correctAnswer){
            System.out.println("Your answer is a bit too low.");
        }
        else {
            System.out.println("Your answer is a bit too high.");
        }
    }

    public static void printResult() {
        if (isMultiplayer){
            if (playerTurnIndicator == 1){
                System.out.printf("Congratulations Player One! You won! \nAmount of guesses:\nPlayer One: " + playerGuessCounter, "\nPlayer Two: " + (playerGuessCounter - 1));
            }
            else{
                System.out.printf("Congratulations Player Two! You won! \nAmount of guesses:\nPlayer One: " + playerGuessCounter, "\nPlayer Two: " + playerGuessCounter);
            }
        }
        else{
            System.out.printf("Congratulations Player Two! You won! %nAmount of guesses:%nPlayer One: " + playerGuessCounter);
        }
        System.out.println("Do you want to play again? Type 1 for YES and 2 for NO.");
        if(checkIfStringIsInteger() == 1){
            setAllSettingsToDefault();
        }
        else{
            System.out.println("Thanks For Playing!");
            System.exit(0);
        }

    }

    public static void setAllSettingsToDefault() {
        boolean isDifficultyEasy = false;
        boolean isDifficultyNormal = false;
        boolean isDifficultyHard = false;
        boolean isMultiplayer = false;
        int correctAnswer = 0;
        boolean gameIsStarted = true;
        int playerGuessCounter = 0;
        int playerTurnIndicator = 1;

        startGame();
    }


    public static int randomNumberGenerator() {
        Random randomizedInteger = new Random();
        if(isDifficultyEasy){
            correctAnswer = randomizedInteger.nextInt(10);
        }
        else if(isDifficultyNormal){
            correctAnswer = randomizedInteger.nextInt(50);
        }
        else{ //Hard
            correctAnswer = randomizedInteger.nextInt(100);
        }
        return correctAnswer;
    }



    public static boolean checkIfMultiplayer() {
        boolean testAmountOfPlayer = true;
        System.out.println("How many players? (1-2");
        while(testAmountOfPlayer){
            int intToTest = checkIfStringIsInteger();
            if (intToTest == 1){
                isMultiplayer = false;
                System.out.println("Game set to singleplayer mode!");
                return isMultiplayer; //returns false for multiplayer
            }
            else if (intToTest == 2){
                isMultiplayer = true;
                System.out.println("Game set to multiplayer mode!");
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




