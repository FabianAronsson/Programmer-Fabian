import java.util.ArrayList;
import java.util.Arrays;

public class View {

    public void printNotALetterInformation(){
        System.out.println("This is not a letter from the alphabet. Please try again.");
    }

    public void printIntroduction(){
        System.out.println("Welcome to hangman!\nThe game where you guess on a word.");
    }

    public void printRules(){
        System.out.print("You can play either multiplayer or singleplayer, where " +
                "multiplayer means that one person comes up with a word that the other player is supposed to guess.\n" +
                "In singleplayer the game picks a random word depending on what difficulty you choose before. \n" +
                "For example: short words are words with the length of 3-5 letters and long words are words between 5-10 letters.\n" +
                "When you make a guess you can either type in one letter or the entire word. It is not possible to make a guess on 2 out of 3 letters. \n" +
                "If you reach the maximum amount of guesses - you lose. This is indicated by the Hangman that updates every time you make an incorrect guess.");
    }

    public void printMultiplayerPrompt(){
        System.out.println("Do you want to play the multiplayer version?\n (0) Yes\n(1) No");
    }

    public void printDifficultyInformation(){
        System.out.println("Do you want to play with long or short words?\n(0) Long words\n(1) Short words");
    }

    public void printUsedCharacters(ArrayList<String> usedCharacters){
        System.out.println(Arrays.toString(usedCharacters.toArray()));
    }
    public void printNotANumber(){
        System.out.println("This is not a number. Try again.");
    }

    public void printWrongNumber(){
        System.out.println("Please enter either 0 or 1.");
    }
}
