package sample.main;

import javafx.animation.AnimationTimer;
import sample.model.Player;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Game {
    String path = new File("").getAbsolutePath();
    Player pl = new Player("/out/production/SnakeAreYouOK/sprites/player.png", 25, 25);
    Text scoreSpace = new Text("SCORE: " + String.valueOf(pl.score));
    FlowPane back = new FlowPane();

    Game(Stage Play) {
       // Play.setScene(pixelart1Town);
        Play.setTitle("The Game");
        Play.setMaximized(true);
        Play.setFullScreen(true);
        Play.show();
        scoreSpace.setX(10);
        scoreSpace.setY(40);
        scoreSpace.setFont(Font.font("Verdana", 35));
        /*pixelart1Town.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
            }
        });*/

        try {
            Image image = new Image(new FileInputStream(path + "/out/production/SnakeAreYouOK/sprites/GameBack.jpg"));
            ImageView backGround = new ImageView(image);
            back.getChildren().addAll(backGround);

        } catch (IOException e) {
            e.printStackTrace();

    }
}
}

