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
    static int playerGuessCounter = 0;
    static int playerTurnIndicator = 1;

    public static void main(String[] args) {
        //startGame();
    }

    public static void startGame() {
        System.out.println("Welcome... rules");
        checkIfMultiplayer();

        System.out.println("Which diff?");
        pickDifficulty();
        randomNumberGenerator();
        if (isMultiplayer) {
            multiplayerGame();
        } else {
            singleplayerGame();
        }

    }

    public static void multiplayerGame() {
        while (isDifficultyEasy) {
            playerTurnIndicator = 1;
            System.out.println("Player One, make your guess!");
            difficultyEasy(checkIfStringIsInteger());
            playerTurnIndicator = 2;
            System.out.println("Player Two, make your guess");
            playerGuessCounter++;
            difficultyEasy(checkIfStringIsInteger());
        }

        while (isDifficultyNormal) {
            playerTurnIndicator = 1;
            System.out.println("Player One, make your guess!");
            difficultyNormal(checkIfStringIsInteger());
            playerTurnIndicator = 2;
            System.out.println("Player Two, make your guess");
            playerGuessCounter++;
            difficultyNormal(checkIfStringIsInteger());
        }

        while (isDifficultyHard) {
            playerTurnIndicator = 1;
            System.out.println("Player One, make your guess!");
            playerGuessCounter++;
            difficultyHard(checkIfStringIsInteger());
            playerTurnIndicator = 2;
            System.out.println("Player Two, make your guess");
            difficultyHard(checkIfStringIsInteger());
            checkAmountOfGuessesDone(playerGuessCounter);
        }
    }

    public static void singleplayerGame() {
        while (isDifficultyEasy) {
            System.out.println("Player One, make your guess!");
            playerGuessCounter++;
            difficultyEasy(checkIfStringIsInteger());

        }

        while (isDifficultyNormal) {
            System.out.println("Player One, make your guess!");
            playerGuessCounter++;
            difficultyNormal(checkIfStringIsInteger());
        }

        while (isDifficultyHard) {
            System.out.println("Player One, make your guess!");
            playerGuessCounter++;
            difficultyHard(checkIfStringIsInteger());
            checkAmountOfGuessesDone(playerGuessCounter);
        }
    }

    public static void checkAmountOfGuessesDone(int amountOfGuesses) {
        if (amountOfGuesses == 8) {
            printResult();
        }
    }

    public static void difficultyEasy(int playerGuess) {
        if (playerGuess == correctAnswer) {
            printResult();
        } else if (playerGuess < correctAnswer) {
            System.out.println("Your answer is a tad bit too low.");
        } else {
            System.out.println("Your answer is a tad bit too high.");
        }
    }

    public static void difficultyNormal(int playerGuess) {
        if (playerGuess == correctAnswer) {
            printResult();
        } else if (playerGuess < correctAnswer) {
            System.out.println("Your answer is too low.");
        } else {
            System.out.println("Your answer is too high.");
        }
    }

    public static void difficultyHard(int playerGuess) {
        if (playerGuess == correctAnswer) {
            printResult();
        } else if (playerGuess < correctAnswer) {
            System.out.println("Your answer is too low.");
        } else {
            System.out.println("Your answer is too high.");
        }
    }

    public static void printResult() {
        if (isMultiplayer) {
            if (playerGuessCounter == 8 && isDifficultyHard) {
                System.out.println("   _____          __  __ ______    ______      ________ _____  \n" +
                        "  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \n" +
                        " | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\n" +
                        " | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \n" +
                        " | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \n" +
                        "  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\\n" +
                        "                                                               \n");
                System.out.println("You reached the guessing limit for Hard difficulty.");
            } else if (playerTurnIndicator == 1) {
                System.out.printf("Congratulations Player One! You won! \nAmount of guesses:\nPlayer One: " + playerGuessCounter, "\nPlayer Two: " + (playerGuessCounter - 1));
            } else {
                System.out.printf("Congratulations Player Two! You won! \nAmount of guesses:\nPlayer One: " + playerGuessCounter, "\nPlayer Two: " + playerGuessCounter);
            }
        } else {
            System.out.printf("Congratulations Player Two! You won! %nAmount of guesses:%nPlayer One: " + playerGuessCounter);
        }
        System.out.println("Do you want to play again? Type 1 for YES and 2 for NO.");
        if (checkIfStringIsInteger() == 1) {
            setAllSettingsToDefault();
        } else {
            System.out.flush();
            System.out.println("Thanks For Playing!");
            System.exit(0);
        }

    }

    public static void setAllSettingsToDefault() {
        isDifficultyEasy = false;
        isDifficultyNormal = false;
        isDifficultyHard = false;
        isMultiplayer = false;
        correctAnswer = 0;
        playerGuessCounter = 0;
        playerTurnIndicator = 1;

        startGame();
    }

    public static int randomNumberGenerator() {
        Random randomizedInteger = new Random();
        if (isDifficultyEasy) {
            correctAnswer = randomizedInteger.nextInt(10);
        } else if (isDifficultyNormal) {
            correctAnswer = randomizedInteger.nextInt(50);
        } else { //Hard
            correctAnswer = randomizedInteger.nextInt(100);
        }
        return correctAnswer;
    }

    public static boolean checkIfMultiplayer() {
        boolean testAmountOfPlayer = true;
        System.out.println("How many players? (1-2)");
        while (testAmountOfPlayer) {
            int intToTest = checkIfStringIsInteger();
            if (intToTest == 1) {
                isMultiplayer = false;
                System.out.println("Game set to singleplayer mode!");
                return isMultiplayer; //returns false for multiplayer
            } else if (intToTest == 2) {
                isMultiplayer = true;
                System.out.println("Game set to multiplayer mode!");
                return isMultiplayer; //returns true for multiplayer
            } else {
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
                while(checkStringProcess){
                    checkStringProcess = false;
                    inputFromUser = input.nextLine();
                    for (int i = 0; i < inputFromUser.length(); i++) {
                        if (!(Character.isDigit(inputFromUser.charAt(i)))) {
                            System.out.println("Wrong input!");
                            checkStringProcess = true;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Your input is too large or invalid!");
                checkStringProcess = true;
            }
        }
        convertedToInteger = Integer.parseInt(inputFromUser);
        return convertedToInteger;
    }
}