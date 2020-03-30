package ca.bcit.comp2522.labs.lab08;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

public class SelfPortrait extends Application {

    public void start(Stage primaryStage) {

        Color skin = Color.rgb(255,209,163);
        Color hair = Color.rgb(124, 82, 36);
        Color eye = Color.rgb(38, 127, 0);

        Ellipse head = new Ellipse(300, 255, 105, 130);
        head.setFill(skin);

        Ellipse leftSideBurn = new Ellipse(395, 215, 20, 55);
        leftSideBurn.setFill(hair);

        Ellipse rightSideBurn = new Ellipse(205, 215, 20, 55);
        rightSideBurn.setFill(hair);

        Ellipse topHair = new Ellipse(300, 160, 100, 55);
        topHair.setFill(hair);

        Group headGroup = new Group(head, leftSideBurn, rightSideBurn, topHair);

        Rectangle rightGlasses = new Rectangle(230, 235, 55, 35);
        rightGlasses.setStroke(Color.BLACK);
        rightGlasses.setArcWidth(10);
        rightGlasses.setArcHeight(10);
        rightGlasses.setStrokeWidth(2);
        rightGlasses.setFill(Color.WHITE);

        Rectangle leftGlasses = new Rectangle(315, 235, 55, 35);
        leftGlasses.setStroke(Color.BLACK);
        leftGlasses.setArcWidth(10);
        leftGlasses.setArcHeight(10);
        leftGlasses.setStrokeWidth(2);
        leftGlasses.setFill(Color.WHITE);

        Circle rightEye = new Circle(270, 252, 6);
        rightEye.setFill(eye);

        Circle leftEye = new Circle(330, 252, 6);
        leftEye.setFill(eye);

        Line glasses = new Line(285, 253, 315, 253);
        glasses.setStrokeWidth(2);

        Ellipse mouth = new Ellipse(300,320,50,30);

        Ellipse lip = new Ellipse(300,320,50,30);
        lip.setTranslateY(-8);
        lip.setScaleX(1.1);
        lip.setFill(skin);

        Group faceGroup = new Group(rightGlasses, leftGlasses,
                rightEye, leftEye, glasses, mouth, lip);

        Rectangle neck = new Rectangle(280, 360, 40, 75);
        neck.setFill(skin);

        Rectangle body = new Rectangle(175, 400, 250, 400);
        body.setFill(Color.GRAY);
        body.setArcHeight(50);
        body.setArcWidth(50);

        Line rightArm = new Line(225, 445, 225, 600);
        rightArm.setStrokeWidth(2);

        Line leftArm = new Line(370, 445, 370, 600);
        leftArm.setStrokeWidth(2);

        Image image = new Image("ca/bcit/comp2522/labs/lab08/banana.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setRotate(41);
        imageView.getTransforms().add(new Shear(0.9, -0.2));
        imageView.setScaleX(0.25);
        imageView.setScaleY(0.25);
        imageView.setTranslateY(250);

        Group bodyGroup = new Group(neck, body, rightArm, leftArm, imageView);

        Group root = new Group(headGroup, faceGroup, bodyGroup);

        final int appWidth = 600;
        final int appHeight = 600;
        Scene scene = new Scene(root, appWidth, appHeight, Color.rgb(142, 255, 172));

        primaryStage.setTitle("Keegan Maundrell");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
