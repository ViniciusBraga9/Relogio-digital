import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.*;
import javafx.scene.*;

public class Main extends Application {

    final DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override   public void start(Stage palco){

        Label time = new Label();
        time.setStyle("-fx-font-size: 30pt; -fx-text-fill: black;");

        KeyFrame frame = new KeyFrame(Duration.ZERO, e -> {
            time.setText(LocalDateTime.now().format(fomatter));
        });

        KeyFrame frame2 = new KeyFrame(Duration.seconds(1), e -> {

        });

        Timeline line = new Timeline();
        line.getKeyFrames().addAll(frame,frame2);

        line.setCycleCount(Animation.INDEFINITE);
        line.play();

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: white;");
        vb.getChildren().add(time);

        Scene cena = new Scene(vb,210,100);
        palco.setTitle("Relogio digital");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[]args){
        launch(args);
    }
}

