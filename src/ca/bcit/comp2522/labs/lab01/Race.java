package ca.bcit.comp2522.labs.lab01;
import java.util.Random;

public class Race {
    private int raceLength, raceWinner;
    private Hare hareRacer;
    private Tortoise tortoiseRacer;
    private Random randomNumber = new Random();


    public Race(int raceLength) {
        this.raceLength = raceLength;
        this.hareRacer = new Hare();
        this.tortoiseRacer = new Tortoise();
    }

    public int getRaceWinner() {
        return raceWinner;
    }

    private int generateRandom(int upperBound) {
        return randomNumber.nextInt(upperBound) + 1;
    }

    public void reset() {
        tortoiseRacer.setPosition(0);
        hareRacer.setPosition(0);
    }

    public String simulateRace() {
        reset();
        return race();
    }

    private String race() {
        int clockTicks = 0;
        do {
            int goesFirst = this.generateRandom(2);
            if (goesFirst == 1) { //tortoise goes first
                tortoiseRacer.move();
                hareRacer.move();
            } else { // hare goes first
                hareRacer.move();
                tortoiseRacer.move();
            }
            clockTicks++;
        } while (hareRacer.getPosition() < raceLength && tortoiseRacer.getPosition() < raceLength);
        if (hareRacer.getPosition() >= raceLength && tortoiseRacer.getPosition() < raceLength) {
            raceWinner = 0; //hare wins the race
            return String.format("The Hare has won the race in %d clock ticks with a distance of %d past" +
                    " the finish line.", clockTicks, hareRacer.getPosition() - raceLength);
        } else {
            raceWinner = 1; //tortoise wins the race
            return String.format("The Tortoise has won the race in %d clock ticks with a distance of %d past" +
                    " the finish line.", clockTicks, tortoiseRacer.getPosition() - raceLength);
        }
    }
}
