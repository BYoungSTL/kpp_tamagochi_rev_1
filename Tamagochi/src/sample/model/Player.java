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
    public double[] posMem = {0, 0};
    public double[] tale = new double[256];
    public double score;

    public void newImage(String pathName) {
        try {
            pathModel = pathName;
            Image imagePlayer = new Image(new FileInputStream(path + pathName));
            playerModel.setWidth(50);
            playerModel.setHeight(50);
            playerModel.setFill(new ImagePattern(imagePlayer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player(String PathName, double x, double y) {
        try {
            score = 0;
            pathModel = PathName;
            Image imagePlayer = new Image(new FileInputStream(path + PathName));
            playerModel.setX(x);
            playerModel.setY(y);
            playerModel.setWidth(50);
            playerModel.setHeight(50);
            playerModel.setFill(new ImagePattern(imagePlayer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

