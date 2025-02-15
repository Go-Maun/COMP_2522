package ca.bcit.comp2522.lectures.innerClasses;

public class Parcel8 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Over budget!");
            }
            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}
