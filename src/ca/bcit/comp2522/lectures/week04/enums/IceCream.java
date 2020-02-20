package ca.bcit.comp2522.lectures.week04.enums;

/**
 * Demonstrates the use of enumerated types.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class IceCream {

    /**
     * Creates and uses variables of the Flavour type.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Flavour cone1;
        Flavour cone2;
        Flavour cone3;

        cone1 = Flavour.rockyRoad;
        cone2 = Flavour.chocolate;

        System.out.println("cone1 value: " + cone1  );
        System.out.println("cone1 ordinal: " + cone1.ordinal());
        System.out.println("cone1 name: " + cone1.name());

        System.out.println();
        System.out.println("cone2 value: " + cone2);
        System.out.println("cone2 ordinal: " + cone2.ordinal());
        System.out.println("cone2 name: " + cone2.name());

        cone3 = cone1;

        System.out.println();
        System.out.println("cone3 value: " + cone3);
        System.out.println("cone3 ordinal: " + cone3.ordinal());
        System.out.println("cone3 name: " + cone3.name());
    }

    /**
     * Enumeration type representing some flavours of ice cream.
     */
    enum Flavour {
        /**
         * plain vanilla flavour.
         */
        vanilla,
        /**
         * smooth chocolate flavour.
         */
        chocolate,
        /**
         * smooth strawberry flavour.
         */
        strawberry,
        /**
         * fudge flavour with fudge pieces.
         */
        fudgeRipple,
        /**
         * light coffee flavour.
         */
        coffee,
        /**
         * chocolate, nuts, marshmallow flavour.
         */
        rockyRoad,
        /**
         * mint flavour with chocolate chip.
         */
        mintChocolateChip,
        /**
         * chocolate chip cookie dough in vanilla flavour.
         */
        cookieDough
    }
}

