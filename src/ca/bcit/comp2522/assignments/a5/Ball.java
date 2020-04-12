package ca.bcit.comp2522.assignments.a5;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Random;

/**
 *  Ball is a Runnable.  A Ball bounces.
 *
 * @author BCIT
 * @version 2020
 */
public class Ball extends Circle implements Runnable {

    private static ArrayList<Ball> ballStorage = new ArrayList<>();
    private static final Random generator = new Random();

    private final int MAX_X = 500; // horizontal edge of enclosing Panel
    private final int MAX_Y = 500; // vertical edge of enclosing Panel

    private int dx; // change in horizontal position of ball
    private int dy; // change in vertical position of ball


    /**
     * Constructs an object of type Ball.
     * @param xPosition an int
     * @param yPosition an int
     */
    public Ball(int xPosition, int yPosition) {
        super(10, Color.RED);
        this.setCenterX(xPosition);
        this.setCenterY(yPosition);
        dx = generator.nextInt(5) + 1; // change in x (1 - 5 pixels)
        dy = generator.nextInt(5) + 1; // change in y (1 - 5 pixels)
        ballStorage.add(this);
    }

    /**
     * Bounces the Ball perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(20); // sleep for 20 milliseconds
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            /* Long-running operations must not be run on the JavaFX application
               thread, since this prevents JavaFX from updating the UI, resulting
               in a frozen UI.

               Furthermore any change to a Node that is part of a "live" scene
               graph must happen on the JavaFX application thread.

               Platform.runLater can be used to execute those updates on the
               JavaFX application thread.
             */
            Platform.runLater(() -> {
                // if bounce off top or bottom of Panel
                if (this.getCenterY() <= 0 || this.getCenterY() >= MAX_Y) {
                    dy *= -1; // reverses velocity in y direction
                }

                // if bounce off left or right of Panel
                if (this.getCenterX() <= 0 || this.getCenterX() >= MAX_X) {
                    dx *= -1; // reverses velocity in x direction
                }

                for (Ball ball : ballStorage) {
                    if (this.intersects(ball.getBoundsInLocal()) && this != ball) {
                        int tempX = ball.dx;
                        int tempY = ball.dy;
                        ball.dx = this.dx;
                        ball.dy = this.dy;
                        this.dx = tempX;
                        this.dy = tempY;
                    }
                }

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position
            });
        }
    }
}
