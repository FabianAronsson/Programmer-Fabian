import java.io.File;
import java.util.ArrayList;

public class Model {

    private String correctAnswer = "";
    private ArrayList<String> hintBar = new ArrayList<>();
    private ArrayList<String> usedLetters = new ArrayList<>();
    private String userGuess = "";
    private Integer guesscounter = 0;
    private boolean hasPlayerWon = false;
    private boolean hasPlayerLost = false;
    private boolean isMultiplayer = false;
    public final File INCORRECTGUESSSOUND = new File("incorrectguess.WAV");
    public final File CORRECTGUESSSOUND = new File("correctguess.WAV");
    public final File CORRECTANSWERSOUND = new File("correctanswer.WAV");
    public final File LOSESOUND = new File("losesound.WAV");


    /**
     * A getter for correctAnswer.
     *
     * @return Returns the value correctAnswer from the model.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * A setter for correctAnswer.
     *
     * @param correctAnswer Takes in the correct answer from the controller.
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * A getter for isMultiplayer.
     *
     * @return  Returns the value isMultiplayer has.
     */
    public boolean getIsMultiplayer(){
        return isMultiplayer;
    }

    /**
     * A setter for isMultiplayer.
     *
     * @param isMultiplayer     Takes in a boolean and sets the variable isMultiplayer to that value.
     */
    public void setIsMultiplayer(boolean isMultiplayer){
        this.isMultiplayer = isMultiplayer;
    }

    /**
     * A getter for userGuess.
     *
     * @return Returns the value userGuess from the model.
     */
    public String getUserGuess() {
        return userGuess;
    }

    /**
     * A setter for userGuess.
     *
     * @param userGuess Takes in a String from the controller.
     */
    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    /**
     * A getter for guessCounter.
     *
     * @return Returns the value guessCounter from the model.
     */
    public Integer getGuessCounter() {
        return guesscounter;
    }

    /**
     * A setter for guessCounter.
     *
     * @param guesscounter Takes in an Integer from the controller.
     */
    public void setGuesscounter(Integer guesscounter) {
        this.guesscounter = guesscounter;
    }

    /**
     * A getter for hintBar.
     *
     * @return Returns the value hintBar from the model.
     */
    public ArrayList<String> getHintBar() {
        return hintBar;
    }

    /**
     * A setter for hintBar.
     *
     * @param hintBar Takes in an ArrayList<String> from the controller.
     */
    public void setHintBar(ArrayList<String> hintBar) {
        this.hintBar = hintBar;
    }

    /**
     * A getter for usedLetters.
     *
     * @return Returns the value usedLetters from the model.
     */
    public ArrayList<String> getUsedLetters() {
        return usedLetters;
    }

    /**
     * A setter for usedLetters.
     *
     * @param usedLetters Takes in an ArrayList<String> from the controller.
     */
    public void setUsedLetters(ArrayList<String> usedLetters) {
        this.usedLetters = usedLetters;
    }

    /**
     * A getter for hasPlayerWon.
     *
     * @return Returns the value hasPlayerWon from the model.
     */
    public boolean getHasPlayerWon() {
        return hasPlayerWon;
    }

    /**
     * A setter for hasPlayerWon.
     *
     * @param hasPlayerWon Takes in a boolean from controller.
     */
    public void setHasPlayerWon(boolean hasPlayerWon) {
        this.hasPlayerWon = hasPlayerWon;
    }

    /**
     * A getter for hasPlayerLost.
     *
     * @return Returns the value hasPlayerLost from the model.
     */
    public boolean getHasPlayerLost() {
        return hasPlayerLost;
    }

    /**
     * A setter for hasPlayerLost.
     *
     * @param hasPlayerLost Takes in a boolean from controller.
     */
    public void setHasPlayerLost(boolean hasPlayerLost) {
        this.hasPlayerLost = hasPlayerLost;
    }
}
