package ca.bcit.comp2522.quizzes.quiz01.AlarmClock;
import java.util.HashMap;
//got as much of the quiz done as we could with using
// the internet to heavily guide the code we have written. we do not understand most of this code without the use of google.

public class main {
    public static void main(String[] args) {
        int times[] = {};
        int largestSegment = 0;
        HashMap <Integer, Integer> segments = new HashMap<Integer, Integer>();
                segments.put(0, 6);
                segments.put(1, 2);
                segments.put(2, 5);
                segments.put(3,5);
                segments.put(4, 4);
                segments.put(5, 5);
                segments.put(6, 6);
                segments.put(7, 3);
                segments.put(8,7);
                segments.put(9, 6);
        for (int hour = 0; hour < 24; hour++) {
            for (int min = 0; min < 60; min++) {
                int timeInt = (hour * 100) + min;
                String time = Integer.toString(timeInt);
                int segmentTotal = 0;
                for (int length = 0; length < time.length(); length++) {
                    char timePosition = time.charAt(length);
                    String timePositionString = Character.toString(timePosition);
                    segmentTotal += segments.get(Integer.parseInt(timePositionString));
                }
                if (segmentTotal >= largestSegment) {
                    largestSegment = segmentTotal;
                    //times += {timeInt};
                }
            }
        }
    }
}
