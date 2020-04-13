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
            createCorrectAnswerFromPlayer();
            createHintBar();
        }
        else{ //if false then the game is set to singleplayer

        }
        guessPhase();
    }

    public void guessPhase() {
        //kalla på hangmanStage
        //kalla på hintBar
        //skapa ArrayList med understreck i sig
        if (doesUserInputMatchAnswer(isUserInputCorrect(getUserInput()))) {
            addUsedCharactersToArrayList();
            updateHintBar();
            //kalla på ny metod för check
        } else { //if the user did not guess correctly then the process repeats itself
            //uppdatera hangmanStage
            //kalla på counter
            addUsedCharactersToArrayList();
            guessPhase();
        }
    }

    public String getWordFromFile(boolean difficultyIsHard){
        try {
            Scanner longWords = new Scanner(new FileInputStream("longwords.txt"), StandardCharsets.UTF_8);
            Scanner shortWords = new Scanner(new FileInputStream("shortwords.txt"), StandardCharsets.UTF_8);
            String guessWords = "";
            if (difficultyIsHard){
                return guessWords += longWords.nextLine();
            }
            else{ //if difficulty is not hard then it has to be easy - which means short words
                return guessWords += shortWords.nextLine();
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
        if(userInput == 0){
            return true;
        }
        else if(userInput == 1)
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
        if (userInput == 0){
            return true;
        }
        else if (userInput == 1){
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
            input.close();
            return input.nextInt();
        }
        else{
            view.printNotANumber();
            input.close();
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
        model.setUsedCharacters(temp);
    }

    public void addUsedCharactersToArrayList(){
       if (model.getUserGuess().length() == 1){
          model.getUsedCharacters().add(model.getUserGuess());
       }
    }


    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        model.setUserGuess(input.nextLine());
        input.close();
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

    public boolean doesUserInputMatchAnswer(String userGuess) {

        if (userGuess.length() == model.getCorrectAnswer().length()) {
            if (userGuess.equals(model.getCorrectAnswer())) {
                //kalla på resultatmetoden

            }
        } else if (userGuess.length() == 1) {
            for (int i = 0; i < model.getCorrectAnswer().length(); i++) {
                if (userGuess.charAt(0) == model.getCorrectAnswer().charAt(i)) {
                    return true;
                }
            }
            return false; //this means that the user entered an incorrect answer.
        } else {       //returns false if the user entered a value that is either greater than or less than the correct answer, but not if the value is 1 in length
            return false;
        }
        return false;
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
