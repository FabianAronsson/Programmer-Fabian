import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    static Model model = new Model();
    static View view = new View();

    /**
     * This method is the general starting method. It prints all of the necessary information to the user.
     * This include introduction message, rules and more. It calls on a method called isMultiplayer, and if that method
     * returns true - the game gets set to multiplayer mode. This means that the two player are allowed. One of the players
     * enters a word and the other is guessing on that word. In singleplayer the game picks a random word based on what
     * difficulty the user choosed previously. A hintbar is created so the user can get hints during gameplay. Afterwards
     * the game progresses into guessPhase where the guessing takes part.
     */
    public void startGame() {
        view.printIntroduction();
        view.printRules();
        view.printMultiplayerPrompt();
        if (isMultiplayer()) {
            view.printMultiplayer();
            createCorrectAnswerFromPlayer();
        } else { //if false then the game is set to singleplayer
            view.printDifficultyInformation();
            getRandomWordFromArray(splitStringsToArrayList(getWordFromFile(pickDifficulty())));
        }
        view.printGuessingPhase();
        createHintBar();
        view.printHintBar(convertHintBarToString(model.getHintBar()));
        guessPhase();
    }

    /**
     * The guessPhase method is the method where the user makes guesses on a specific word. The method starts with getting
     * user input - which is validated - and checks if that guess is equal to the answer. If the letter which the user
     * guessed on occurs in the correct answer then it returns true and the if-statement continues. Inside the if-statement
     * we find methods that adds the letter to an ArrayList, updates the hintbar so that the player can get hints, prints
     * both of the previous methods corresponding values from the model, checks if the user correctly guessed on the whole
     * word using ONLY letters and finally a sound is played if the player guessed correctly.
     *
     * As for the else statement it is used when the user made an incorrect guess. First it clears the console in order
     * to provide better visibility to the player. Then the actual stage is presented and a counter is increased. The
     * counter acts as the amount of lifes the user has while playing. A method checks if the player has lost and adds
     * the letter to usedLetters. The used letters and the hintbar is printed and an incorrect sound effect is played.
     * The game goes to resultPhase and checks if the player has won, if it have not, then the game continues by calling
     * guessPhase again.
     */
    public void guessPhase() {
        if (doesUserInputMatchAnswer(isUserInputCorrect(getUserInput()))) {
            addUsedLettersToArrayList();
            updateHintBar();
            view.printUsedLetters(convertUsedLettersToString(model.getUsedLetters()));
            view.printHintBar(convertHintBarToString(model.getHintBar()));
            testIfFullAnswerIsCorrect();
            playSound(model.CORRECTGUESSSOUND);
        } else { //if the user did not make a correct guess then the process repeats itself
            clearConsole();
            displayHangmanStage();
            increaseGuessCounter();
            hasPlayerLost();
            addUsedLettersToArrayList();
            view.printUsedLetters(convertUsedLettersToString(model.getUsedLetters()));
            view.printHintBar(convertHintBarToString(model.getHintBar()));
            playSound(model.INCORRECTGUESSSOUND);
        }
        resultPhase();
        guessPhase();
    }

    /**
     * The resultPhase method is a farily simple method which checks whether the player has won or not. It does this by
     * accessing two variables in the model, to be more specific - it accesses two booleans which is updated in hasPlayerWon
     * and hasPlayerLost. If the player have won then the game congratulates the player and calls on the restartGame method.
     * If the player loses however, the game prints a message losing message and calls on the restartGame method. However,
     * if none of the conditions are met - the game simply continues by calling the guessPhase method.
     */
    public void resultPhase() {
        if (model.getHasPlayerWon()) {
            view.printCorrectAnswer(model.getCorrectAnswer());
            view.printCongratulationMessage();
            restartGame();
        } else if (model.getHasPlayerLost()) {
            view.printLossMessage();
            restartGame();
        } else {
            guessPhase();
        }
    }

    /**
     * The restartGame method prints information on how the user restarts the game and how the user exists the game.
     * Afterwards it listens to input that is either 1 or 2. 1 resets all variables that need to be reset and 2 exists
     * the game. If some other number is entered, the game informs the user that the number he/she entered is not an
     * alternative. Afterwards the method restarts itself.
     */
    public void restartGame() {
        view.printRestartInformation();
        Integer userInput = isUserInputANumber();
        if (userInput == 1) {
            resetVariables();
            startGame();
        } else if (userInput == 2) {
            System.exit(0);
        }
        else{
            view.printNotANumber();
            restartGame();
        }
    }

    /**
     * This method resets all variables to its default state. This is done in order to avoid errors such as the correct
     * answer being the same next game. It should not be a problem since you choose a new one when you restart, but just
     * IN CASE something goes wrong. The counter however, has to be reset to zero as otherwise the game might think you
     * lost before you even had a chance to play.
     */
    public void resetVariables() {
        ArrayList<String> temp = new ArrayList<>();
        model.setGuesscounter(0);
        model.setCorrectAnswer("");
        model.setHintBar(temp);
        model.setUsedLetters(temp);
        model.setHasPlayerLost(false);
        model.setHasPlayerWon(false);
    }

    /**
     * This method checks if the user reached the maximum amount of guesses. If it has then a boolean is updated to true,
     * a losing sound is played and the correct answer is printed. The game afterwards calls on resultPhase to finalize
     * the loss.
     */
    public void hasPlayerLost() {
        if (model.getGuessCounter() == 7) {
            model.setHasPlayerLost(true);
            playSound(model.LOSESOUND);
            view.printCorrectAnswer(model.getCorrectAnswer());
            resultPhase();
        }
    }

    /**
     * This method contains a for loop and a view.printNewLine call. It clears the console by printing 50 new lines.
     */
    public void clearConsole() {
        for (int i = 0; i < 50; i++) {
            view.printNewLine();
        }
    }

    /**
     * This is the graphics selector. Based on what the guessCounter currently is on the game prints a specific stage in
     * the view class.
     */
    public void displayHangmanStage() {
        Integer amountOfGuesses = model.getGuessCounter();
        if (amountOfGuesses == 0) {
            view.printHangmanStage1();

        } else if (amountOfGuesses == 1) {
            view.printHangmanStage2();

        } else if (amountOfGuesses == 2) {
            view.printHangmanStage3();

        } else if (amountOfGuesses == 3) {
            view.printHangmanStage4();

        } else if (amountOfGuesses == 4) {
            view.printHangmanStage5();

        } else if (amountOfGuesses == 5) {
            view.printHangmanStage6();

        } else if (amountOfGuesses == 6) {
            view.printHangmanStage7();
        }
    }

    /**
     * This method reads from a text file. It takes in a boolean that later decides whether or not to read hard words or
     * easy from text files. Two scanners are used. One for each text file. These are used to read from the text file where
     * words are separated by commas. Since this method is returning a String - the same String that has ALL of the words
     * in it - it has to be splitted somehow. This is done in the next method. A try catch is needed here since there is
     * nothing the game can do to prevent errors such as if a file were to be missing. If a text file is missing the game
     * restarts as the multiplayer version is still working.
     *
     * @param difficultyIsHard   Takes in a difficulty that decides what kind of words to use in the game.
     * @return                   Returns the words from the text file.
     */
    public String getWordFromFile(boolean difficultyIsHard) {
        try {
            Scanner longWords = new Scanner(new FileInputStream("longwords.txt"), StandardCharsets.UTF_8);
            Scanner shortWords = new Scanner(new FileInputStream("shortwords.txt"), StandardCharsets.UTF_8);
            String guessWords = "";
            if (difficultyIsHard) {
                return guessWords = longWords.nextLine();
            } else { //if difficulty is not hard then it has to be easy - which means short words
                return guessWords = shortWords.nextLine();
            }
        } catch (FileNotFoundException E) {
            view.printUnableToFindTextFile();
            startGame();
        }
        return "";  //This code block will never be reached, but is necessary
    }

    /**
     * This is the method which is used together with getWordFromFile to split the words where every comma is. Afterwards
     * these words are inserted into a new ArrayList which then is returned. The splitting part works by using regex.
     *
     * @param wordsToBeSplitted     This is the String which contain the words.
     * @return                      Returns the splitted words as an ArrayList.
     */
    public ArrayList<String> splitStringsToArrayList(String wordsToBeSplitted) {
        return new ArrayList<>(Arrays.asList(wordsToBeSplitted.split(",")));
    }

    /**
     * This method takes in the splitted words and randomly (using Random), selects a word inside the Arraylist.
     * Afterwards the correct answer is updated with a word from the ArrayList.
     *
     * @param splittedWords     Takes in the splitted words where one word is supposed to be the correct answer.
     */
    public void getRandomWordFromArray(ArrayList<String> splittedWords) {
        Random randomNumber = new Random();
        int index = randomNumber.nextInt(splittedWords.size());
        model.setCorrectAnswer(splittedWords.get(index));
    }

    /**
     * This method pick a difficulty depending on what the user entered. If it is 1 then hard difficulty is picked, if it
     * is 2 then easy is picked. Hard means long words and easy mean short words. That is not to say that short mean easy
     * words ;). If no condition is met then the process continues. The method returns a boolean which is hard if true
     * and easy if false.
     *
     * @return      Returns a boolean that decides the difficulty based on user input.
     */
    public boolean pickDifficulty() {
        Integer userInput = isUserInputANumber();
        if (userInput == 1) {
            return true;  //hard
        } else if (userInput == 2)
            return false;  //"easy"
        else { //if the number is not within the range - the process repeats itself
            view.printWrongNumber();
            return pickDifficulty();
        }
    }

    /**
     * This method takes in user input  and then sets the correct answer to what the player entered.
     * The console is afterwards cleared to make sure that the player cannot cheat.
     * Of course the other player can simply scroll up, but without clearConsole, the other player would immediately
     * see what the correct answer was.
     *
     * Originally regex was included, but since this is multiplayer I wanted to spice things up, because you cannot enter
     * numbers nor special characters when you are actually guessing. This might be fun for those who want to joke with
     * the other player. This makes it so if you want to guess seriously you would actually enter a real word and not a
     * number or some other non working characters, but at the same time preserving the fun part in joking with your friend.
     * It is (and was) by no means hard to implement regex to limit what kind of characters that could be entered, but
     * what is the fun in limiting players?
     */
    public void createCorrectAnswerFromPlayer() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine().toLowerCase();
        model.setCorrectAnswer(userInput);
        clearConsole();
    }

    /**
     * This method returns a boolean based on user input. It is a method which checks if the user want to play the
     * multiplayer version or not. This is done by checking what input was entered. If no condition was met the process
     * repeats itself.
     *
     * @return      Returns a boolean
     */
    public boolean isMultiplayer() {
        Integer userInput = isUserInputANumber();
        if (userInput == 1) {
            return true; //multiplayer
        } else if (userInput == 2) {
            return false; //singleplayer
        } else {
            view.printWrongNumber();
            return isMultiplayer();
        }
    }

    /**
     * This method check if the user input is a number. If it is not then the process repeats itself.
     *
     * @return          Returns the number that was entered.
     */
    public Integer isUserInputANumber() {
        Scanner input = new Scanner(System.in);

        if (input.hasNextInt()) {
            return input.nextInt();
        } else {
            view.printNotANumber();
            return isUserInputANumber();
        }
    }

    /**
     * This method creates the hintbar to give the player hints to what word he/she is guessing on. It works bt inserting
     * so many underscores as the length of the correct answer into an ArrayList using a for-loop.
     */
    public void createHintBar() {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < model.getCorrectAnswer().length(); i++) {
            temp.add("_");
        }
        model.setHintBar(temp);
    }

    /**
     * This method loops through the hintbar to check if the users guess can be found inside the correct answer. If it can,
     * then that underscore inside hintbar would get replaced with the user's guess.
     */
    public void updateHintBar() {
        ArrayList<String> temp = model.getHintBar();
        for (int i = 0; i < model.getCorrectAnswer().length(); i++) {
            if (model.getUserGuess().charAt(0) == model.getCorrectAnswer().charAt(i)) {
                temp.set(i, model.getUserGuess());
            }
        }
        model.setHintBar(temp);
    }

    /**
     * This method adds the letters which the user uses during the guessing. It works by creating a temporary ArrayList
     * and a temporary String variable that later gets inserted into the temporary ArrayList. The usedLetters is updated
     * with the temporary ArrayList.
     */
    public void addUsedLettersToArrayList() {
        if (model.getUserGuess().length() == 1) {
            ArrayList<String> temp = model.getUsedLetters();
            String tempArray = model.getUserGuess();
            temp.add(tempArray);
            model.setUsedLetters(temp);
        }
    }

    /**
     * This method is specifically used to get userInput, but more importantly user guesses. It is used together with
     * other methods that make use of the user guess, such as, if the guess matches any letter in the correct answer.
     * This method updates the userGuess in model and afterwards returns the guess so it can be used in the next method.
     *
     * @return          Returns the user guess that is going to be validated.
     */
    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        model.setUserGuess(input.nextLine());
        return model.getUserGuess();
    }

    /**
     * This method loops through the userInput (which is the guess), and checks if the String does not contain anything
     * that is not from the alphabet. It does this by using regex and a for-loop. If a number was fun the user is told
     * and the process repeats itself. If only letters were entered, the method returns the letter(s).
     *
     * @param userInput     Takes in the user input that is going to be validated.
     * @return              Returns the validated user input.
     */
    public String isUserInputCorrect(String userInput) {

        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.toString(userInput.charAt(i)).matches("^[A-Za-z]")) {
                view.printNotALetterInformation();
                guessPhase();
            }
        }
        return userInput.toLowerCase();
    }

    /**
     * This method increases the guess counter every time the user makes an incorrect guess. The counter is used for
     * displaying the correct stage and checking if the player has lost.
     */
    public void increaseGuessCounter() {
        model.setGuesscounter(model.getGuessCounter() + 1);
    }

    /**
     * This method checks if the hintbar is equal to the correct answer. Why would the game need this? Well, without it
     * you cannot win the game if you only enter letters. This method checks every time the user entered a letter if the
     * hintbar is equal to the correct answer. Because if it is, it means that the user has guessed correctly on all of
     * the letters. If the user guesses correctly, a sound is played and hasPlayerWon is set to true. Afterwards the
     * resultPhase is called upon and the player wins.
     */
    public void testIfFullAnswerIsCorrect() {
        if (convertHintBarToString(model.getHintBar()).equals(model.getCorrectAnswer())) { //if the user guessed correctly on all letters then the user wins
            playSound(model.CORRECTANSWERSOUND);
            model.setHasPlayerWon(true);
            resultPhase();
        }
    }

    /**
     * This is the method that has the responsibility to check if the user input match the correct answer. This could be
     * either the full word or a letter of the word. It also checks if the player has already made a guess on that letter.
     * The first if-statement checks if the user guess has already been guessed on. Though it only checks letters, not words.
     * The second if-statement checks if the user entered a word that has equal length as the correct answer. If it does
     * then it checks if those two are equal. If they are - the player win. The third if-statement loops through the
     * correct answer and checks if the user guess is anywhere in the correct answer. If it is, another if-statement checks
     * if the hintbar is equal to the correct answer. If it is - the player win. If it is not then the game returns true to
     * indicate that the letter does in fact exist inside the correct answer. If however it does not - the game returns false
     * as the guess does not exist inside the correct answer. The last else statement returns false as it is used if the
     * player enters words equal to the length of 2 but > correctAnswer > which nets the player an incorrect guess. Since
     * you cannot guess on words that is greater nor less than the correct answer.
     *
     * @param userGuess     This is the user guess that is used.
     * @return              Returns a boolean that is used to determine whether or not the user did a correct guess or not.
     */
    public boolean doesUserInputMatchAnswer(String userGuess) {
        if (userGuess.length() == 1) {
            if (hasUserGuessedOnThisLetter(userGuess)) {
                view.printUsedCharacterInformation();
                guessPhase();
            }
        }
        if (userGuess.length() == model.getCorrectAnswer().length()) {
            if (userGuess.equals(model.getCorrectAnswer())) {
                playSound(model.CORRECTANSWERSOUND);
                model.setHasPlayerWon(true);
                resultPhase();
            }
        } else if (userGuess.length() == 1) {
            for (int i = 0; i < model.getCorrectAnswer().length(); i++) {
                if (userGuess.charAt(0) == model.getCorrectAnswer().charAt(i)) {
                    if (convertHintBarToString(model.getHintBar()).equals(model.getCorrectAnswer())) { //if the user guessed correctly on all letters then the user wins
                        playSound(model.CORRECTANSWERSOUND);
                        model.setHasPlayerWon(true);
                        resultPhase();
                    }
                    return true;
                }
            }

            return false; //this means that the user entered an incorrect answer
        } else {       //returns false if the user entered a value that is either greater than or less than the correct answer, but not if the value is 1 in length
            return false;
        }
        return false;
    }

    /**
     *  This method checks if the user has already guessed on previous characters. It works by looping through a String
     *  and checks each position of the usedLetters String to see if the userGuess exists inside. If it does - the game
     *  returns true. If it does not - the game returns false.
     *
     * @param userGuess     This is the user input which is used in the method.
     * @return              Returns a boolean depending on if the letter does exist inside usedLetters.
     */
    public boolean hasUserGuessedOnThisLetter(String userGuess) {
        String usedLetters = convertUsedLettersToString(model.getUsedLetters());
        for (int i = 0; i < usedLetters.length(); i++) {
            if (userGuess.charAt(0) == usedLetters.charAt(i)) {
                return true; //The word has been used
            }
        }
        return false; //The word has not been used
    }

    /**
     * Converts the used letter ArrayList to a String. This was necessary in order to better utilize certain functions
     * that Strings have, but not ArrayLists and vice versa. For example: printing an ArrayList is harder than a String
     * in this project, but I use both in this project. Just to different things. It works by adding every letter inside
     * usedLetter to an empty String using a for-loop. It later returns the finished String.
     *
     * @param letters       The ArrayList that is going to be converted.
     * @return              Returns the ArrayList as a String.
     */
    public String convertUsedLettersToString(ArrayList<String> letters) {
        String usedLetters = "";
        for (int i = 0; i < model.getUsedLetters().size(); i++) {
            usedLetters += letters.get(i);
        }
        return usedLetters;
    }

    /**
     * This method works in the same fashion as the above one, but with a few changes. For example, it loops differently
     * than the previous one. If it did not, I would have been able to use the previous one again, but that is not
     * possible.
     *
     * @param letters       The ArrayList that is going to be converted to a String.
     * @return              Returns the converted ArrayList as a String.
     */
    public String convertHintBarToString(ArrayList<String> letters) {
        String hintbar = "";
        for (int i = 0; i < model.getCorrectAnswer().length(); i++) {
            hintbar += letters.get(i);
        }
        return hintbar;
    }

    /**
     * This method plays all the sound files in my game. It work by using Clip and Audiosystem, but mainly clip. It
     * begins with creating clip and the opening the actual clip so that a sound file can be played. This is necessary as
     * otherwise would clip not know where to play the sound file from, and without AudioInputStream there would be no way
     * to locate the file and provide it to clip. Clip.start plays the actual sound file. Thread.sleep is also included to
     * make sure that the sound file gets fully played so that the game does not progress before the sound file was fully
     * played. There is also a try catch here to make sure that the game does not crash when a sound file could not be found.
     *
     * @param soundFile         This is the sound effect that is going to be played.
     */
    public void playSound(File soundFile) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException | InterruptedException E) {
            view.printSoundEffectError();
        }
    }
}
