package ca.bcit.comp2522.lectures.innerClasses;

public class Parcel6 {
    public Wrapping wrapping(int x) {
        // Base constructor call:
        return new Wrapping(x) { // Pass constructor argument.
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        Wrapping w = p.wrapping(10);
    }
} /// :~
