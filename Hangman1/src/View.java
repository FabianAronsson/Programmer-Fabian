
public class View {
    /**
     * This method prints error information for incorrect input.
     * In this case it is if the user entered a character that is not from the alphabet.
     */
    public void printNotALetterInformation() {
        System.out.println("This is not a letter from the alphabet. Please try again.");
    }

    /**
     * This method prints a welcome message to the user.
     */
    public void printIntroduction() {
        System.out.println("\nWelcome to hangman!\nThe game where you guess on a word.\n");
    }

    /**
     * This method prompts the user to enter his or hers word in multiplayer mode.
     */
    public void printMultiplayer() {
        System.out.println("Multiplayer selected!\nPlayer two, enter your word now.");
    }

    /**
     * This method explains the rules to the user.
     */
    public void printRules() {
        System.out.print("You can play either multiplayer or singleplayer, where " +
                "multiplayer means that one person comes up with a word that the other player is supposed to guess.\n" +
                "In singleplayer the game picks a random word depending on what difficulty you choosed before. \n" +
                "For example: short words are words with the length of 3-5 letters and long words are words between 5-10 letters.\n" +
                "When you make a guess you can either type in one letter or the entire word. It is not possible to make a guess on 2 out of 3 letters. \n" +
                "If you reach the maximum amount of guesses - you lose. This is indicated by the Hangman that updates every time you make an incorrect guess.\n\n");
    }

    /**
     * Another method that prints information to the user. This time it is about the word that was created.
     * Either from the user or the computer.
     */
    public void printGuessingPhase() {
        System.out.println("The word has been created. It is time to make your guess!");
    }

    /**
     * This method prints a multiplayer prompt where the game ask the user to enter a number from 1 to 0.
     */
    public void printMultiplayerPrompt() {
        System.out.println("Do you want to play the multiplayer version?\n(1) Yes\n(2) No");
    }

    /**
     * Like the previous method, this method promts you something, and this time it is whether or not you want long or short words to make a guess on.
     */
    public void printDifficultyInformation() {
        System.out.println("Do you want to play with long or short words?\n(1) Long words\n(2) Short words");
    }

    /**
     * A method that tells the user that the letter he/she made a guess on has already been used.
     */
    public void printUsedCharacterInformation() {
        System.out.println("This letter or word has already been tried. Please input a different one.");
    }

    /**
     * This method prints the letters that the user have tried.
     *
     * @param usedLetters    Takes in a String which contains all of the used letters.
     */
    public void printUsedLetters(String usedLetters) {
        System.out.println(usedLetters);
    }

    /**
     * This method prints the hintbar so that the player can get hints.
     *
     * @param hintBar           Takes in a String which contains the actual hintbar.
     */
    public void printHintBar(String hintBar) {
        System.out.println(hintBar);
    }

    /**
     * A method that prints error information when the user enters something that is not a number.
     */
    public void printNotANumber() {
        System.out.println("\nThat is not a number or it might not be an alternative. Try again.\n");
    }

    /**
     * This method prints a new line. As simple as that ;). Used in tandem with a for loop to clear the console.
     */
    public void printNewLine() {
        System.out.println();
    }

    /**
     * This method prints the correct answer. It is used when you lose, so that you know what word just guessed on.
     *
     * @param correctAnswer     Takes in the correct answer to display.
     */
    public void printCorrectAnswer(String correctAnswer){
        System.out.println("\nThe correct answer was: " + correctAnswer);
    }

    /**
     * The method prints an error message telling the user that the text file containing the words was unable to be found.
     */
    public void printUnableToFindTextFile(){
        System.out.println("File not found.");
    }

    /**
     * This method prints a message to the user telling he/she that the sound file could not be played.
     */
    public void printSoundEffectError(){
        System.out.println("Either the sound file could not be found or an unsupported audio type was used.");
    }

    /**
     * Prints an error message that tells the user to either input either 1 or 2.
     */
    public void printWrongNumber() {
        System.out.println("Please enter either 1 or 2.");
    }

    /**
     * Prints a congratulation message.
     */
    public void printCongratulationMessage() {
        System.out.println("\nCongratulations, you won!");
    }

    /**
     * Prints a message telling the user he/she has lost.
     */
    public void printLossMessage() {
        System.out.println("\nToo bad, you lost.");
    }

    /**
     * Prints a restart prompt, asking whether the user want to play again or not.
     */
    public void printRestartInformation() {
        System.out.println("Do you want to play again?\n(1) Yes\n(2) No");
    }

    /**
     * This javadoc will apply and cover all of the hangmanStage methods as they are practically identical.
     * Each method prints part of the graphics. The controller calls on the correct method based on where
     * the user is in-game.
     */
    public void printHangmanStage1() {
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
    }

    public void printHangmanStage2() {
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
    }

    public void printHangmanStage3() {
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
    }

    public void printHangmanStage4() {
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
    }

    public void printHangmanStage5() {
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                "      |\n" +
                "      |\n" +
                "=========");
    }

    public void printHangmanStage6() {
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " /    |\n" +
                "      |\n" +
                "=========");
    }

    public void printHangmanStage7() {
        System.out.println("  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "      |\n" +
                "=========");
    }
}
