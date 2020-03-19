package ca.bcit.comp2522.lectures.innerClasses;

public class BadEgg {
    private int i;
    private Yolk y;

    /**
     * Yolk.
     */
    class Yolk {
        /**
         * @param value
         */
        public void setI(int value) {
            i = value;
        }
    }

    /**
     * Drives the program.
     * @param args
     */
    public static void main(String[] args) {
        BadEgg e = new BadEgg();
        e.y.setI(5);
        System.out.println("i=" + e.i);
    }
}
