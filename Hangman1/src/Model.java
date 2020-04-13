import java.io.File;
import java.util.ArrayList;

public class Model {

    private String correctAnswer = "";
    private ArrayList<String> hintBar = new ArrayList<>();
    private ArrayList<String> usedCharacters = new ArrayList<>();
    private String userGuess = "";
    public final File INCORRECTGUESSSOUND = new File("incorrectguess.WAV");
    public final File CORRECTGUESSSOUND = new File("correctguess.WAV");
    public final File CORRECTANSWERSOUND = new File("correctanswer.WAV");


    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getUserGuess() {
        return userGuess;
    }
    public void setUserGuess(String userGuess){
        this.userGuess = userGuess;
    }

    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getHintBar() {
        return hintBar;
    }

    public void setHintBar(ArrayList<String> hintBar){
        this.hintBar = hintBar;
    }

    public ArrayList<String> getUsedCharacters() {
        return usedCharacters;
    }

    public void setUsedCharacters(ArrayList<String> usedCharacters){
        this.usedCharacters = usedCharacters;
    }
}
