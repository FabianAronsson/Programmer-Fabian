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

    /**
     * This method is the starting method. It acts as a main menu as it is here where you make your settings as such. The method welcomes the user(s), explains the rules
     * and calls methods necessary to start the game.
     */
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
        System.out.printf("%nTalspelet is a game about guessing a random number!%nYou can play as either 1 or 2 players and there is a range of difficulties available!%n" +
                "Everything you enter is based off numbers only, so have no fear of entering the wrong number. The game will inform you about what you entered, that it does not like ;)%n");
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

    /**
     * If the user chooses multiplayer mode, then this method will be called upon. Inside this method you can find three different difficulties,
     * one of them is choosen depending of what the user picked before when deciding difficulty. This is where the game actually start. A while loop
     * runs the entire game and it is here where everything comes back to once the users made their guess. Each of the users guess once and a player turn indicator
     * is there in order to keep track of whos turn it is. This is useful for "printResult();", since otherwise the game will not exactly know who won.
     * There is also a counter that keeps track of the guesses each user makes. This is used for the results and also to check if a user has exceeded the limit
     * put on some of the difficulties.
     */
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

    /**
     * Just like in the multplayerGame() method, this method contains three difficulties that the user choose before and makes a guess until the condition is satisfied,
     * that is if the user enters the correct guess or if the user runs out of guesses. SingleplayerGame() and multplayerGame() is very similar. The reason to keep
     * them separate is to achieve better readability. What differentiate the methods is that one is singplayer and the other is multiplayer.
     */
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
            checkAmountOfGuessesDone(playerGuessCounter);
        }

        while (isDifficultyHard) {
            System.out.println(playerOneName + ", make your guess!");
            playerGuessCounter++;
            difficultyHard(checkIfStringIsInteger());
            checkAmountOfGuessesDone(playerGuessCounter);
        }
    }

    /**
     * A simple method that checks if the user has made too many guesses for difficulties "Hard" and "Normal". If that is the case, then the game calls printResult();
     * which means "Game Over".
     *
     * @param amountOfGuesses This is an int which get its value from playerGuessCounter
     */
    public static void checkAmountOfGuessesDone(int amountOfGuesses) {
        if (isDifficultyHard) {
            if (amountOfGuesses == 5) {
                printResult();
            }
        } else { //Normal
            if (amountOfGuesses == 8) {
                printResult();
            }
        }
    }

    /**
     * This method checks whether the user is correct, close or outside of the guessing range. If the user is one away from the correct answer, then the game
     * will inform the user about that.
     *
     * @param playerGuess The guess from the user to be tested. This is an int.
     */
    public static void difficultyEasy(int playerGuess) {
        if (playerGuess == correctAnswer) {
            printResult();
        } else if (playerGuess > 11) {
            System.out.println("This number is not part of the guessing. For Easy, you are guessing a number between 0 and 10.");
        } else if (playerGuess - correctAnswer == 1 || playerGuess - correctAnswer == -1) {
            System.out.println("You are very close.");
        } else if (playerGuess < correctAnswer) {
            System.out.printf("%nYour answer is a tad bit too low.%n");
        } else {
            System.out.printf("%nYour answer is a tad bit too high.%n");
        }
    }

    /**
     * Just like the previous method, difficultyEasy();, this method almost does the same thing except it is a bit harder. On Normal the user gets a clue if
     * their guess is one or two away. This is to compensate for the guessing limit that Normal has.
     *
     * @param playerGuess The guess from the user to be tested. This is an int.
     */
    public static void difficultyNormal(int playerGuess) {
        if (playerGuess == correctAnswer) {
            printResult();
        } else if (playerGuess > 51) {
            System.out.println("This number is not part of the guessing. For Normal, you are guessing a number between 0 and 50.");
        } else if (playerGuess - correctAnswer == 1 || playerGuess - correctAnswer == -1) {
            System.out.println("You are very close.");
        } else if (playerGuess - correctAnswer == 2 || playerGuess - correctAnswer == -2) {
            System.out.println("Close, but not quite.");
        } else if (playerGuess < correctAnswer) {
            System.out.printf("%nYour answer is too low.%n");
        } else {
            System.out.printf("%nYour answer is too high.%n");
        }
    }

    /**
     * @param playerGuess
     */
    public static void difficultyHard(int playerGuess) {
        if (playerGuess == correctAnswer) {
            printResult();
        } else if (playerGuess > 101) {
            System.out.println("This number is not part of the guessing. For Hard, you are guessing a number between 0 and 100.");
        } else if (playerGuess < correctAnswer) {
            System.out.printf("%nYour answer is too low.%n");
        } else {
            System.out.printf("%nYour answer is too high.%n");
        }
    }

    public static void printResult() {
        clearConsole();
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
        System.out.println("Do you want to play again? Enter 1 for YES and 2 for NO (Or any other number for NO).");
        if (checkIfStringIsInteger() == 1) {
            setAllSettingsToDefault();
        } else {
            clearConsole();
            System.out.println("Thanks For Playing!");
            System.exit(0);
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void setAllSettingsToDefault() {
        clearConsole();
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

    public static void randomNumberGenerator() {
        Random randomizedInteger = new Random();

        if (isDifficultyEasy) {
            correctAnswer = randomizedInteger.nextInt(11);
        } else if (isDifficultyNormal) {
            correctAnswer = randomizedInteger.nextInt(51);
        } else { //Hard
            correctAnswer = randomizedInteger.nextInt(101);
        }
    }

    public static void checkIfMultiplayer() {
        boolean testAmountOfPlayer = true;

        System.out.println("How many players? (1-2)");
        while (testAmountOfPlayer) {
            int intToTest = checkIfStringIsInteger();
            if (intToTest == 1) {
                System.out.println("Game is set to singleplayer mode.");
                isMultiplayer = false;
                System.out.println("Enter your name below:");
                playerOneName = input.nextLine();
                testAmountOfPlayer = false;
            } else if (intToTest == 2) {
                System.out.println("Game is set to multiplayer mode.");
                isMultiplayer = true;
                System.out.println("Player One, enter you name below:");
                playerOneName = input.nextLine();
                System.out.println("Player Two, enter you name below:");
                playerTwoName = input.nextLine();
                testAmountOfPlayer = false;
            } else { //if any other value than 1 or 2 is entered, then the game will throw it as an invalid input.
                System.out.println("Please enter either 1 or 2.");
            }
        }
    }

    public static void pickDifficulty() {
        System.out.printf("%nEnter the number that corresponds to your desired difficulty:%n");
        System.out.println("(1) Easy");
        System.out.println("(2) Normal");
        System.out.println("(3) Hard");
        boolean checkDifficulty = true;

        while (checkDifficulty) {
            switch (checkIfStringIsInteger()) {
                case 1: //Easy
                    isDifficultyEasy = true;
                    System.out.println("Game is set to Easy.");
                    checkDifficulty = false;
                    break;
                case 2: //Normal
                    isDifficultyNormal = true;
                    System.out.println("Game is set to Normal.");
                    checkDifficulty = false;
                    break;
                case 3: //Hard
                    isDifficultyHard = true;
                    System.out.println("Game is set to Hard.");
                    checkDifficulty = false;
                    break;
                default: //Any input that is not 1, 2 or 3.
                    System.out.println("Please enter a number between 1-3.");
            }
        }
    }

    public static int checkIfStringIsInteger() {
        int convertedToInteger = 0;
        String inputFromUser = "";
        boolean checkStringProcess = true;

        while (true) {
            while(checkStringProcess){
                checkStringProcess = false;
                inputFromUser = input.nextLine();
                for (int i = 0; i < inputFromUser.length(); i++) {
                    if (!(Character.isDigit(inputFromUser.charAt(i)))) {
                        System.out.println("Please enter a number! You might have entered negative number or, you did not enter a valid number (aka you entered text).");
                        checkStringProcess = true;
                        break;
                    }
                }
            }
            checkStringProcess = true;
            try {
                return Integer.parseInt(inputFromUser);
            } catch (Exception e) {
                System.out.println("Your input is either too large or not a number.");
            }
        }
    }
}