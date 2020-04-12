package ca.bcit.comp2522.assignments.a5;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

/**
 * BouncingBalls, an introduction to threading and JavaFX.
 *
 * @author BCIT
 * @author Keegan Maundrell
 * @version 2020
 */
public class BouncingBalls extends Application {

    private Random random = new Random();

    public void populate(int numOfBalls, Pane canvas) {
        for (int i = 0; i < numOfBalls; i++) {
            Ball ball = new Ball(random.nextInt(460) + 20,
                    random.nextInt(460) + 20);
            canvas.getChildren().add(ball);
            Thread bouncer = new Thread(ball);
            bouncer.setDaemon(true);
            bouncer.start();
        }
    }

    /**
     * Demonstrates threading in JavaFX.
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 500, 500);


        primaryStage.setTitle("Threads and Balls");
        primaryStage.setScene(scene);
        primaryStage.show();

        TextField area = new TextField("10");
        canvas.getChildren().add(area);
        area.setOnAction(e -> {
            int numOfBalls = Integer.parseInt(area.getText());
            populate(numOfBalls, canvas);
            canvas.getChildren().remove(area);
        });

    }

    /**
     * Launches the JavaFX application.  We still need a main method in our
     * JavaFX applications.  The main method must do one thing.  Pass
     * the command line arguments (args) to the launch method inherited from
     * the Application class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
