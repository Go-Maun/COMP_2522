package ca.bcit.comp2522.lectures.innerClasses;

public class Parcel3 {
    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        // Must use instance of outer class
        // to create an instance of the inner class:
        Contents c = p.new Contents();
        Destination d = p.new Destination("Tasmania");
    }

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }
}
