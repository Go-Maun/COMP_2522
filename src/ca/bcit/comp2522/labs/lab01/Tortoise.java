package ca.bcit.comp2522.labs.lab01;
import java.util.Objects;
import java.util.Random;

public class Tortoise {
    private final int RANDOM_NUMBER_UPPER_BOUND = 100;
    private final int TORTOISE_FAST_MOVE_CHANCE = 50;
    private final int TORTOISE_FAST_MOVE_UNITS = 3;
    private final int TORTOISE_BIG_SLIP_CHANCE = 70;
    private final int TORTOISE_BIG_SLIP_UNITS = 6;
    private final int TORTOISE_SLOW_MOVE_UNITS = 1;
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

    public int move(){
        int moveDecision = generateRandom(RANDOM_NUMBER_UPPER_BOUND);
        if (moveDecision <= TORTOISE_FAST_MOVE_CHANCE) {
            return position += TORTOISE_FAST_MOVE_UNITS;
        }
        else if (moveDecision <= TORTOISE_BIG_SLIP_CHANCE) {
            return position -= TORTOISE_BIG_SLIP_UNITS;
        }
        else {
            return position += TORTOISE_SLOW_MOVE_UNITS;
        }
    }

    @Override
    public String toString() {
        return "Tortoise{" +
                "RANDOM_NUMBER_UPPER_BOUND=" + RANDOM_NUMBER_UPPER_BOUND +
                ", TORTOISE_FAST_MOVE_CHANCE=" + TORTOISE_FAST_MOVE_CHANCE +
                ", TORTOISE_FAST_MOVE_UNITS=" + TORTOISE_FAST_MOVE_UNITS +
                ", TORTOISE_BIG_SLIP_CHANCE=" + TORTOISE_BIG_SLIP_CHANCE +
                ", TORTOISE_BIG_SLIP_UNITS=" + TORTOISE_BIG_SLIP_UNITS +
                ", TORTOISE_SLOW_MOVE_UNITS=" + TORTOISE_SLOW_MOVE_UNITS +
                ", position=" + position +
                ", randomNumber=" + randomNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tortoise)) return false;
        Tortoise tortoise = (Tortoise) o;
        return RANDOM_NUMBER_UPPER_BOUND == tortoise.RANDOM_NUMBER_UPPER_BOUND &&
                TORTOISE_FAST_MOVE_CHANCE == tortoise.TORTOISE_FAST_MOVE_CHANCE &&
                TORTOISE_FAST_MOVE_UNITS == tortoise.TORTOISE_FAST_MOVE_UNITS &&
                TORTOISE_BIG_SLIP_CHANCE == tortoise.TORTOISE_BIG_SLIP_CHANCE &&
                TORTOISE_BIG_SLIP_UNITS == tortoise.TORTOISE_BIG_SLIP_UNITS &&
                TORTOISE_SLOW_MOVE_UNITS == tortoise.TORTOISE_SLOW_MOVE_UNITS &&
                getPosition() == tortoise.getPosition() &&
                Objects.equals(randomNumber, tortoise.randomNumber);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
