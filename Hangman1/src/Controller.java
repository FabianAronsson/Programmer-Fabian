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

    public void startGame() {
        view.printIntroduction();
        view.printRules();
        view.printMultiplayerPrompt();
        if (isMultiplayer()){
            view.printMultiplayer();
            createCorrectAnswerFromPlayer();

        }
        else{ //if false then the game is set to singleplayer
            view.printDifficultyInformation();
            getRandomWordFromArray(splitStringsToArrayList(getWordFromFile(pickDifficulty())));
        }
        view.printGuessingPhase();
        createHintBar();
        view.printHintBar(convertHintBarToString(model.getHintBar()));
        guessPhase();
    }

    public void guessPhase() {
        //kalla på hangmanStage
        if (doesUserInputMatchAnswer(isUserInputCorrect(getUserInput()))) {
            addUsedCharactersToArrayList();
            updateHintBar();
            view.printUsedCharacters(convertUsedCharactersToString(model.getUsedCharacters()));
            view.printHintBar(convertHintBarToString(model.getHintBar()));
            testIfFullAnswerIsCorrect();
            playSound(model.CORRECTGUESSSOUND);
        } else { //if the user did not guess correctly then the process repeats itself
            displayHangmanStage();
            increaseGuessCounter();
            addUsedCharactersToArrayList();
            view.printUsedCharacters(convertUsedCharactersToString(model.getUsedCharacters()));
            view.printHintBar(convertHintBarToString(model.getHintBar()));
            playSound(model.INCORRECTGUESSSOUND);
        }
        guessPhase();
    }

    public void resultPhase(){

    }

    public void displayHangmanStage(){
        Integer amountOfGuesses = model.getGuessCounter();
        if (amountOfGuesses == 0){
            view.printHangmanStage1();
        }
        else if (amountOfGuesses == 1){
            view.printHangmanStage2();
        }
        else if (amountOfGuesses == 2){
            view.printHangmanStage3();

        }
        else if (amountOfGuesses == 3){
            view.printHangmanStage4();

        }
        else if (amountOfGuesses == 4){
            view.printHangmanStage5();

        }
        else if (amountOfGuesses == 5){
            view.printHangmanStage6();

        }
        else if (amountOfGuesses == 6){
            view.printHangmanStage7();

        }

    }

    public String getWordFromFile(boolean difficultyIsHard){
        try {
            Scanner longWords = new Scanner(new FileInputStream("longwords.txt"), StandardCharsets.UTF_8);
            Scanner shortWords = new Scanner(new FileInputStream("shortwords.txt"), StandardCharsets.UTF_8);
            String guessWords = "";
            if (difficultyIsHard){
                return guessWords = longWords.nextLine();
            }
            else{ //if difficulty is not hard then it has to be easy - which means short words
                return guessWords = shortWords.nextLine();
            }
        }
        catch (FileNotFoundException E){
            System.out.println("File not found.");
            return getWordFromFile(false);
        }
    }

    public ArrayList<String> splitStringsToArrayList(String wordsToBeSplitted){
        ArrayList<String> splittedStrings = new ArrayList<>(Arrays.asList(wordsToBeSplitted.split(",")));
        return splittedStrings;
    }

    public void getRandomWordFromArray(ArrayList<String> splittedWords){
        Random randomNumber = new Random();
        int index = randomNumber.nextInt(splittedWords.size());
        model.setCorrectAnswer(splittedWords.get(index));
    }

    public boolean pickDifficulty(){
        Integer userInput = isUserInputANumber();
        if(userInput == 1){
            return true;
        }
        else if(userInput == 2)
            return false;
        else{ //if the number is not within the range - the process repeats itself
            view.printWrongNumber();
            return pickDifficulty();
        }
    }

    public void createCorrectAnswerFromPlayer(){
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine().toLowerCase();
        for (int i = 0; i < userInput.length(); i++){
            if (!Character.toString(userInput.charAt(i)).matches("^[A-Za-z]")){
                view.printNotALetterInformation();
                createCorrectAnswerFromPlayer();
            }
        }
        model.setCorrectAnswer(userInput);
    }

    public boolean isMultiplayer(){
        Integer userInput = isUserInputANumber();
        if (userInput == 1){
            return true;
        }
        else if (userInput == 2){
            return false;
        }
        else{
            isMultiplayer();
            view.printWrongNumber();
        }
        return false;
    }

    public Integer isUserInputANumber(){
        Scanner input = new Scanner(System.in);

        if (input.hasNextInt()){
            return input.nextInt();
        }
        else{
            view.printNotANumber();
            return isUserInputANumber();
        }
    }


    public void createHintBar(){
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < model.getCorrectAnswer().length(); i++){
            temp.add("_");
        }
        model.setHintBar(temp);
    }

    public void updateHintBar(){
        ArrayList<String> temp = model.getHintBar();
        for (int i = 0; i < model.getCorrectAnswer().length(); i++){
            if (model.getUserGuess().charAt(0) == model.getCorrectAnswer().charAt(i)){
                temp.set(i, model.getUserGuess());
            }
        }
        model.setHintBar(temp);
    }

    public void addUsedCharactersToArrayList(){
       if (model.getUserGuess().length() == 1){
           ArrayList<String> temp = model.getUsedCharacters();
           String tempArray = model.getUserGuess();
           temp.add(tempArray);
           model.setUsedCharacters(temp);
       }
    }


    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        model.setUserGuess(input.nextLine());
        return model.getUserGuess();
    }

    public String isUserInputCorrect(String userInput) {

        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.toString(userInput.charAt(i)).matches("^[A-Za-z]")) {
                view.printNotALetterInformation();
                guessPhase();
            }
        }
        return userInput.toLowerCase();
    }

    public void increaseGuessCounter(){
        model.setGuesscounter(model.getGuessCounter() + 1);
    }

    public void testIfFullAnswerIsCorrect(){
        if (convertHintBarToString(model.getHintBar()).equals(model.getCorrectAnswer())){ //if the user guessed correctly on all letters then the user wins
            playSound(model.CORRECTANSWERSOUND);
            //kalla på resultat
        }
    }

    public boolean doesUserInputMatchAnswer(String userGuess) {
        if (userGuess.length() == 1){
            if (hasUserGuessedOnThisLetter(userGuess)){
                view.printUsedCharacterInformation();
                guessPhase();
            }

        }
        if (userGuess.length() == model.getCorrectAnswer().length()) {
            if (userGuess.equals(model.getCorrectAnswer())) {
                playSound(model.CORRECTANSWERSOUND);
                //kalla på resultatmetoden

            }
        }
        else if (userGuess.length() == 1) {
            for (int i = 0; i < model.getCorrectAnswer().length(); i++) {
                if (userGuess.charAt(0) == model.getCorrectAnswer().charAt(i)) {
                    if (convertHintBarToString(model.getHintBar()).equals(model.getCorrectAnswer())){ //if the user guessed correctly on all letters then the user wins
                    playSound(model.CORRECTANSWERSOUND);
                    //kalla på resultat
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

    public boolean hasUserGuessedOnThisLetter(String userGuess){
        String usedCharacters = convertUsedCharactersToString(model.getUsedCharacters());
        for (int i = 0; i < usedCharacters.length(); i++){
            if (userGuess.charAt(0) == usedCharacters.charAt(i)){
                return true;
            }
        }
        return false;
    }

    public String convertUsedCharactersToString(ArrayList<String> letters){
        String usedCharacters = "";
        for (int i = 0; i < model.getUsedCharacters().size(); i++){
            usedCharacters += letters.get(i);
        }
        return usedCharacters;
    }
    public String convertHintBarToString(ArrayList<String> letters){
        String hintbar = "";
        for (int i = 0; i < model.getCorrectAnswer().length(); i++){
            hintbar += letters.get(i);
        }
        return hintbar;
    }

    public void playSound(File soundFile) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException | InterruptedException E) {
            System.out.println("Either the sound file could not be found or an unsupported audio type was used.");
        }
    }

}
