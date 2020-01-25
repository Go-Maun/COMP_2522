package ca.bcit.comp2522.labs.lab01;

public class Driver {

    private static String simulateRaces (int numberOfRaces, int raceLength) {
        int hareWins = 0, tortoiseWins = 0;
        for (int raceNumber = 1; raceNumber <= numberOfRaces; raceNumber++) {
            Race currentRace = new Race(raceLength);
            currentRace.simulateRace();
            if (currentRace.getRaceWinner() == 0) {
                hareWins++;
            } else {
                tortoiseWins++;
            }
        }
        return String.format("With a race of %d length, the Hare won %d races, and the Tortoise won %d races."
                , raceLength, hareWins, tortoiseWins);
    }

    public static void main(String[] args) {
        System.out.println(simulateRaces(100, 100));
    }
}
