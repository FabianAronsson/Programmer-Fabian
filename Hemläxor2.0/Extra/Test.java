import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



import static javafx.application.Application.launch;

public class Test extends Application {
    private static final String IMAGEONE = "https://upload.wikimedia.org/wikipedia/commons/4/4c/Flag_of_Sweden.svg";
    private static final String IMAGETWO = "https://upload.wikimedia.org/wikipedia/commons/d/d9/Flag_of_Norway.svg";

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final ImageView graphicOne = new ImageView(new Image(IMAGEONE));
        final ImageView graphicTwo = new ImageView(new Image(IMAGETWO));

        Button knappEtt = new Button();
        knappEtt.setBackground(Color.WHITE);

        Button knappTva = new Button();
        knappTva.setBackground(Color.WHITE);
    }


}

