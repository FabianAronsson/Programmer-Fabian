import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    static Model model = new Model();
    static View view = new View();

    public void startGame() {
        getUserInput();
    }

    public void guessPhase(){
        if (doesUserInputMatchAnswer(isUserInputCorrect(getUserInput()))){
            //kalla på ny metod för check
        }
        else{ //if the user did not guess correctly then the process repeats itself
            guessPhase();
        }
    }

    public String getUserInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String isUserInputCorrect(String userInput){

        for (int i = 0; i < userInput.length(); i++){
            if (!Character.toString(userInput.charAt(i)).matches("^[A-Za-z]")){
                view.printNotALetterInformation();
                getUserInput();
            }
        }
        return userInput.toLowerCase();
    }

    public boolean doesUserInputMatchAnswer(String userGuess){
        return userGuess.equals(model.getCorrectAnswer());

    }

    public void playSound(File soundFile) {
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException | InterruptedException E) {
            System.out.println("Either the sound file could not be found or an unsupported audio type was used.");
        }
    }

}
