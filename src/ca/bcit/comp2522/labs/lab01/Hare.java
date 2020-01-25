package ca.bcit.comp2522.labs.lab01;
import java.util.Objects;
import java.util.Random;

public class Hare {
    private final int RANDOM_NUMBER_UPPER_BOUND = 100;
    private final int HARE_SLEEP_CHANCE = 20;
    private final int HARE_BIG_HOP_CHANCE = 30;
    private final int HARE_BIG_HOP_UNITS = 9;
    private final int HARE_BIG_SLIP_CHANCE = 40;
    private final int HARE_BIG_SLIP_UNITS = 12;
    private final int HARE_SMALL_MOVE_CHANCE = 70;
    private final int HARE_SMALL_MOVE_UNITS = 1;
    private final int HARE_SMALL_SLIP_UNITS = 2;
    private int position;
    private Random randomNumber = new Random();

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    private int generateRandom(int upperBound) {
        return randomNumber.nextInt(upperBound) + 1;
    }

    public int move() {
        int moveDecision = generateRandom(RANDOM_NUMBER_UPPER_BOUND);
        if (moveDecision <= HARE_SLEEP_CHANCE) {
            return position; //hare sleeps
        }
        else if (moveDecision <= HARE_BIG_HOP_CHANCE) {
            return position += HARE_BIG_HOP_UNITS;
        }
        else if (moveDecision <= HARE_BIG_SLIP_CHANCE) {
            return position -= HARE_BIG_SLIP_UNITS;
        }
        else if (moveDecision <= HARE_SMALL_MOVE_CHANCE) {
            return position += HARE_SMALL_MOVE_UNITS;
        }
        else {
            return position -= HARE_SMALL_SLIP_UNITS;
        }
    }

    @Override
    public String toString() {
        return "Hare{" +
                "RANDOM_NUMBER_UPPER_BOUND=" + RANDOM_NUMBER_UPPER_BOUND +
                ", HARE_SLEEP_CHANCE=" + HARE_SLEEP_CHANCE +
                ", HARE_BIG_HOP_CHANCE=" + HARE_BIG_HOP_CHANCE +
                ", HARE_BIG_HOP_UNITS=" + HARE_BIG_HOP_UNITS +
                ", HARE_BIG_SLIP_CHANCE=" + HARE_BIG_SLIP_CHANCE +
                ", HARE_BIG_SLIP_UNITS=" + HARE_BIG_SLIP_UNITS +
                ", HARE_SMALL_MOVE_CHANCE=" + HARE_SMALL_MOVE_CHANCE +
                ", HARE_SMALL_MOVE_UNITS=" + HARE_SMALL_MOVE_UNITS +
                ", HARE_SMALL_SLIP_UNITS=" + HARE_SMALL_SLIP_UNITS +
                ", position=" + position +
                ", randomNumber=" + randomNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hare)) return false;
        Hare hare = (Hare) o;
        return RANDOM_NUMBER_UPPER_BOUND == hare.RANDOM_NUMBER_UPPER_BOUND &&
                HARE_SLEEP_CHANCE == hare.HARE_SLEEP_CHANCE &&
                HARE_BIG_HOP_CHANCE == hare.HARE_BIG_HOP_CHANCE &&
                HARE_BIG_HOP_UNITS == hare.HARE_BIG_HOP_UNITS &&
                HARE_BIG_SLIP_CHANCE == hare.HARE_BIG_SLIP_CHANCE &&
                HARE_BIG_SLIP_UNITS == hare.HARE_BIG_SLIP_UNITS &&
                HARE_SMALL_MOVE_CHANCE == hare.HARE_SMALL_MOVE_CHANCE &&
                HARE_SMALL_MOVE_UNITS == hare.HARE_SMALL_MOVE_UNITS &&
                HARE_SMALL_SLIP_UNITS == hare.HARE_SMALL_SLIP_UNITS &&
                getPosition() == hare.getPosition() &&
                Objects.equals(randomNumber, hare.randomNumber);
    }
}
