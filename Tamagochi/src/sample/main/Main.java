package sample.main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main_Menu play = new Main_Menu(stage);
        play.eventOnPlay();
        play.eventOnContinue();
        play.eventOnExit();

    }


    public String path = new File("").getAbsolutePath();

    public class Main_Menu {
        public void nw() {
        }

        Button button1 = new Button("Play");
        Button button2 = new Button("Replay");
        Button button3 = new Button("Exit");
        FlowPane root = new FlowPane(Orientation.VERTICAL, 0, 50, button1, button2, button3);
        Scene Tales = new Scene(root);
        Stage Cl_Stage;

        public Main_Menu(Stage Menu) {
            root.setAlignment(Pos.BOTTOM_CENTER);
            try {
                Image image = new Image(new FileInputStream(path + "/out/production/Tamagochi/sprites/MenuBG.jpg"));
                BackgroundImage backIm = new BackgroundImage(image,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT);
                Background back = new Background(backIm);
                root.setBackground(back);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Menu.setScene(Tales);
            Menu.setTitle("Tamagochi");
            Menu.setResizable(false);
            Menu.setFullScreenExitHint("");
            Menu.setMinWidth(1920);
            Menu.setMinHeight(1080);
            Menu.setFullScreen(true);
            Menu.show();
            button1.setPrefSize(300, 50);
            button2.setPrefSize(300, 50);
            button3.setPrefSize(300, 50);
            button1.setStyle("-fx-background-color: black; -fx-font: 24 arial");
            button1.setTextFill(Color.WHITE);
            ButtonEffects(button1);
            button2.setStyle("-fx-background-color: black; -fx-font: 24 arial");
            button2.setTextFill(Color.WHITE);
            ButtonEffects(button2);
            button3.setStyle("-fx-background-color: black; -fx-font: 24 arial");
            button3.setTextFill(Color.WHITE);
            ButtonEffects(button3);
            Cl_Stage = Menu;
        }

        Game NewGame;

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public void eventOnPlay() {
            button1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    NewGame = new Game(Cl_Stage);
                }
            });
        }

        Stage contWind = new Stage();

        public void eventOnContinue() {
            button2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    contWind.setTitle("Replay");
                    contWind.setFullScreen(true);
                    contWind.setResizable(false);
                    contWind.show();
                    Cl_Stage.close();
                }
            });
        }

        public void eventOnExit() {
            button3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Cl_Stage.close();
                }
            });
        }

        public void ButtonEffects(Button button) {
            button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    button.setStyle("-fx-background-color: gray; -fx-font: 24 arial");
                }
            });
            button.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    button.setStyle("-fx-background-color: black; -fx-font: 24 arial");
                }
            });
        }
    }
}