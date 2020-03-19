package ca.bcit.comp2522.lectures.innerClasses;

public class Parcel7 {
    // Argument must be final to use inside
    // anonymous inner class:
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Destination d = p.destination("Tasmania");
    }
} /// :~
