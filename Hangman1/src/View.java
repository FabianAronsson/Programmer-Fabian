import java.util.ArrayList;
import java.util.Arrays;

public class View {

    public void printNotALetterInformation() {
        System.out.println("This is not a letter from the alphabet. Please try again.");
    }

    public void printIntroduction() {
        System.out.println("\nWelcome to hangman!\nThe game where you guess on a word.\n");
    }

    public void printMultiplayer() {
        System.out.println("Multiplayer selected!\nPlayer two, enter your word now.");
    }

    public void printRules() {
        System.out.print("You can play either multiplayer or singleplayer, where " +
                "multiplayer means that one person comes up with a word that the other player is supposed to guess.\n" +
                "In singleplayer the game picks a random word depending on what difficulty you choosed before. \n" +
                "For example: short words are words with the length of 3-5 letters and long words are words between 5-10 letters.\n" +
                "When you make a guess you can either type in one letter or the entire word. It is not possible to make a guess on 2 out of 3 letters. \n" +
                "If you reach the maximum amount of guesses - you lose. This is indicated by the Hangman that updates every time you make an incorrect guess.\n\n");
    }

    public void printGuessingPhase() {
        System.out.println("The word has been created. It is time to make your guess!");
    }

    public void printMultiplayerPrompt() {
        System.out.println("Do you want to play the multiplayer version?\n(1) Yes\n(2) No");
    }

    public void printDifficultyInformation() {
        System.out.println("Do you want to play with long or short words?\n(1) Long words\n(2) Short words");
    }

    public void printUsedCharacterInformation() {
        System.out.println("This letter or word has already been tried. Please input a different one.");
    }

    public void printUsedCharacters(String usedCharacters) {
        System.out.println(usedCharacters);
    }

    public void printHintBar(String hintBar) {
        System.out.println(hintBar);
    }

    public void printNotANumber() {
        System.out.println("That is not a number or it might not be an alternative. Try again.");
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printUnableToFindTextFile(){
        System.out.println("File not found.");
    }

    public void printSoundEffectError(){
        System.out.println("Either the sound file could not be found or an unsupported audio type was used.");
    }

    public void printWrongNumber() {
        System.out.println("Please enter either 0 or 1.");
    }

    public void printCongratulationMessage() {
        System.out.println("\nCongratulations you won!");
    }

    public void printLossMessage() {
        System.out.println("\nToo bad, you lost.");
    }


    public void printRestartInformation() {
        System.out.println("Do you want to play again?\n(1) Yes\n(2) No");
    }

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
