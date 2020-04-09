import java.io.File;
import java.util.ArrayList;

public class Model {

    private String correctAnswer;
    private String hintBar;
    private ArrayList<String> usedCharacters;
    public final File INCORRECTGUESSSOUND = new File("incorrectguess.WAV");
    public final File CORRECTGUESSSOUND = new File("correctguess.WAV");
    public final File CORRECTANSWERSOUND = new File("correctanswer.WAV");


    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    public String getHintBar() {
        return hintBar;
    }

    public void setHintBar(String hintBar){
        this.hintBar = hintBar;
    }

    public ArrayList<String> getUsedCharacters() {
        return usedCharacters;
    }

    public void setUsedCharacters(ArrayList<String> usedCharacters){
        this.usedCharacters = usedCharacters;
    }
}
