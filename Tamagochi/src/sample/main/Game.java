package sample.main;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
import java.lang.Thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Game {
    private long start = System.currentTimeMillis();
    private long runningTime = start;
    String path = new File("").getAbsolutePath();
    Player pl = new Player("/out/sprites/player.png", 800, 500);
    Text hpSpace = new Text("HP: " + String.valueOf(this.pl.hp));
    Text moneySpace = new Text("Money: " + String.valueOf(this.pl.money));
    Button buttonMine = new Button("Mining");
    Button buttonFood = new Button("Food(+10 HP)");
    FlowPane back = new FlowPane(Orientation.VERTICAL, 0, 50, buttonMine, buttonFood); ////////////////////
    Group rootNode = new Group(back, pl.playerSub, hpSpace, moneySpace, buttonMine, buttonFood);
    Scene pixelart1Town = new Scene(rootNode);

    public void moneyBar(){
            buttonMine.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int click = 1;
                    pl.money += click;
                }
            });
            moneySpace.setText("Money: " + String.valueOf(pl.money));
    }

    public void foodBar(){
        buttonFood.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(pl.money >= 10) {
                    if(100 - pl.hp < 15){
                        pl.money -= 10;
                        pl.hp = 100;
                    }else{
                        pl.money -= 10;
                        pl.hp += 15;
                    }
                }
            }
        });
        hpSpace.setText("HP: " + String.valueOf(pl.hp));
        moneySpace.setText("Money: " + String.valueOf(pl.money));
    }

    public void hpLose(){
            int hpL = 5;
            if(runningTime - start > 1000){
                pl.hp -= hpL;
                start = runningTime;
            }else runningTime = System.currentTimeMillis();
            hpSpace.setText("HP: " + String.valueOf(pl.hp));
    }

   /* public void GameOver(){
        if(pl.hp == 0){
            try {
                Image image = new Image(new FileInputStream(path + "/out/sprites/GameOver.jpg"));
                ImageView backGround = new ImageView(image);
                back.getChildren().addAll(backGround);

            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }*/

    public void mineEffect(Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setStyle("-fx-background-color: #5b56de; -fx-font: 16 arial");
            }
        });
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setStyle("-fx-background-color: #7f93ee; -fx-font: 16 arial");
            }
        });
    }


    Game(Stage Play) {
        pl.hp = 100;
        buttonMine.setLayoutX(1650);
        buttonMine.setLayoutY(125);
        buttonFood.setLayoutX(1650);
        buttonFood.setLayoutY(180);
        Play.setScene(pixelart1Town);
        Play.setTitle("Game");
        Play.setMaximized(true);
        Play.setFullScreen(true);
        Play.show();
        buttonMine.setPrefSize(150, 50);
        buttonMine.setStyle("-fx-background-color: #7f93ee; -fx-font: 16 arial");
        buttonMine.setTextFill(Color.BLACK);
        mineEffect(buttonMine);
        buttonFood.setPrefSize(150, 50);
        buttonFood.setStyle("-fx-background-color: #7f93ee; -fx-font: 16 arial");
        buttonFood.setTextFill(Color.BLACK);
        mineEffect(buttonFood);
        hpSpace.setX(1640);
        hpSpace.setY(40);
        hpSpace.setFont(Font.font("Verdana", 35));
        moneySpace.setX(1640);
        moneySpace.setY(90);
        moneySpace.setFont(Font.font("Verdana", 35));
       /* pixelart1Town.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Game.this.moneyBar();
            }
        });*/

        try {
            Image image = new Image(new FileInputStream(path + "/out/sprites/GameBack1.jpg"));
            ImageView backGround = new ImageView(image);
            back.getChildren().addAll(backGround);

        } catch (IOException e) {
            e.printStackTrace();

    }

        (new AnimationTimer() {
            public void handle(long l) {
                hpLose();
                moneyBar();
                foodBar();
                //GameOver();
            }

        }).start();
}
}

