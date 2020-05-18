package sample.model;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Player {
    final int UP = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    final int LEFT = 4;
    String path = new File("").getAbsolutePath();
    Rectangle playerModel = new Rectangle();
    public Group playerSub = new Group(playerModel);
    String pathModel;
    public int hp;
    public int money;


    public Player(String PathName, double x, double y) {
        try {
            money = 0;
            hp = 100;
            pathModel = PathName;
            Image imagePlayer = new Image(new FileInputStream(path + PathName));
            playerModel.setX(x);
            playerModel.setY(y);
            playerModel.setWidth(0);
            playerModel.setHeight(0);
            playerModel.setFill(new ImagePattern(imagePlayer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

