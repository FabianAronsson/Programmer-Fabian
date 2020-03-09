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
    static String playerOneName = "";
    static String playerTwoName = "";

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println(" __      __       .__                                  __           \n" +
                "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   _/  |_  ____   \n" +
                "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\  \\   __\\/  _ \\  \n" +
                " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |  | (  <_> ) \n" +
                "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |__|  \\____/  \n" +
                "       \\/       \\/          \\/            \\/     \\/                 \n" +
                "___________      .__                        .__          __  ._.    \n" +
                "\\__    ___/____  |  |   ____________   ____ |  |   _____/  |_| |    \n" +
                "  |    |  \\__  \\ |  |  /  ___/\\____ \\_/ __ \\|  | _/ __ \\   __\\ |    \n" +
                "  |    |   / __ \\|  |__\\___ \\ |  |_> >  ___/|  |_\\  ___/|  |  \\|    \n" +
                "  |____|  (____  /____/____  >|   __/ \\___  >____/\\___  >__|  __    \n" +
                "               \\/          \\/ |__|        \\/          \\/      \\/    ");
        System.out.printf("%nTalspelet is a game about guessing a randomized number!%nYou can play as either 1 or 2 players and there is a range of difficulties available!%n" +
                "Every input is based off numbers only, so have no fear of entering the wrong number. The game will inform you about that.%n");
        checkIfMultiplayer();

        System.out.printf("%nWhich difficulty?%nEach of the difficulties are a bit different from each other.%nEasy: in this difficulty you guess a number between 0-10 and you have an unlimited amount of guesses." +
                "%nNormal: in this difficulty you guess a number between 0-50 and you have a limited amount of guesses. The limit is 8 guesses.%nHard: in this difficulty you guess a number between 0-100 and you have a limited amount of guesses. The limit is 5 guesses.%n");
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
            System.out.println(playerOneName + ", make your guess!");
            playerGuessCounter++;
            difficultyEasy(checkIfStringIsInteger());
            playerTurnIndicator = 2;
            System.out.println(playerTwoName + ", make your guess");
            difficultyEasy(checkIfStringIsInteger());
        }

        while (isDifficultyNormal) {
            playerTurnIndicator = 1;
            System.out.println(playerOneName + ", make your guess!");
            playerGuessCounter++;
            difficultyNormal(checkIfStringIsInteger());
            playerTurnIndicator = 2;
            System.out.println(playerTwoName + ", make your guess");
            difficultyNormal(checkIfStringIsInteger());
        }

        while (isDifficultyHard) {
            playerTurnIndicator = 1;
            System.out.println(playerOneName + ", make your guess!");
            playerGuessCounter++;
            difficultyHard(checkIfStringIsInteger());
            playerTurnIndicator = 2;
            System.out.println(playerTwoName + ", make your guess");
            difficultyHard(checkIfStringIsInteger());
            checkAmountOfGuessesDone(playerGuessCounter);
        }
    }

    public static void singleplayerGame() {
        while (isDifficultyEasy) {
            System.out.println(playerOneName + ", make your guess!");
            playerGuessCounter++;
            difficultyEasy(checkIfStringIsInteger());

        }

        while (isDifficultyNormal) {
            System.out.println(playerOneName + ", make your guess!");
            playerGuessCounter++;
            difficultyNormal(checkIfStringIsInteger());
        }

        while (isDifficultyHard) {
            System.out.println(playerOneName + ", make your guess!");
            playerGuessCounter++;
            difficultyHard(checkIfStringIsInteger());
            checkAmountOfGuessesDone(playerGuessCounter);
        }
    }

    public static void checkAmountOfGuessesDone(int amountOfGuesses) {
        if (isDifficultyHard){
            if (amountOfGuesses == 5) {
                printResult();
            }
        }
        else{ //Normal
            if (amountOfGuesses == 8) {
                printResult();
            }
        }

    }

    public static void difficultyEasy(int playerGuess) {
        if (playerGuess == correctAnswer) {
            printResult();
        }
        else if (playerGuess - correctAnswer == 1 || playerGuess - correctAnswer == -1){
            System.out.println("Close, but not quite.");
        }
        else if (playerGuess < correctAnswer) {
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
            if (playerGuessCounter == 5 && isDifficultyHard || playerGuessCounter == 8 && isDifficultyNormal) {
                System.out.println("   _____          __  __ ______    ______      ________ _____  \n" +
                        "  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \n" +
                        " | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\n" +
                        " | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \n" +
                        " | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \n" +
                        "  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\\n" +
                        "                                                               \n");
                System.out.println("You reached the guessing limit difficulty.");
            } else if (playerTurnIndicator == 1) {
                System.out.println("Congratulations " + playerOneName + "! You won! \nAmount of guesses:\n" + playerOneName + ": " + playerGuessCounter + "\n" + playerTwoName + ": " + (playerGuessCounter - 1));
            } else { //player two wins if playerTurnIndicator is two
                System.out.println("Congratulations " + playerTwoName + "! You won! \nAmount of guesses:\n" + playerOneName + ": " + playerGuessCounter + "\n" + playerTwoName + ": " + playerGuessCounter);
            }
        } else if (playerGuessCounter == 5 && isDifficultyHard || playerGuessCounter == 8 && isDifficultyNormal) {
            System.out.println("   _____          __  __ ______    ______      ________ _____  \n" +
                    "  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \n" +
                    " | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\n" +
                    " | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \n" +
                    " | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \n" +
                    "  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\\n" +
                    "                                                               \n");
            System.out.println("You reached the guessing limit for Hard difficulty.");
        } else {
            System.out.printf("Congratulations " + playerOneName + "! You won! %nAmount of guesses:%n" + playerOneName + ": " + playerGuessCounter + "%n");
        }
        System.out.println("Do you want to play again? Type 1 for YES and 2 for NO (Or any other number for NO).");
        if (checkIfStringIsInteger() == 1) {
            setAllSettingsToDefault();
        } else {
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
        playerOneName = "";
        playerTwoName = "";

        startGame();
    }

    public static int randomNumberGenerator() {
        Random randomizedInteger = new Random();
        if (isDifficultyEasy) {
            correctAnswer = randomizedInteger.nextInt(11);
        } else if (isDifficultyNormal) {
            correctAnswer = randomizedInteger.nextInt(51);
        } else { //Hard
            correctAnswer = randomizedInteger.nextInt(101);
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
                System.out.println("Game is set to singleplayer mode.");
                return isMultiplayer; //returns false for multiplayer
            } else if (intToTest == 2) {
                isMultiplayer = true;
                System.out.println("Game is set to multiplayer mode.");
                return isMultiplayer; //returns true for multiplayer
            } else { //if any other value than 1 or 2 is entered, then the game will throw it as an invalid input.
                System.out.println("This is an invalid input. Please input either 1 or 2.");
            }
        }
        return false;
    }

    public static boolean pickDifficulty() {
        System.out.printf("%nType the number that corresponds to your desired difficulty:%n");
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
                while (checkStringProcess) {
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