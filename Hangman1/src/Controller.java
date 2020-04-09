import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Controller {
    static Model model = new Model();
    static View view = new View();

    public void startGame() {
        
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
