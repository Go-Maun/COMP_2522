package ca.bcit.comp2522.lectures.week08.interfaces;

import java.util.ArrayList;
import java.util.Iterator;

interface Student {
    void study();

    default void cry() {
        System.out.println("I'm so tired!");
    }
}

interface Chef {
    default void cry() {
        System.out.println("Onions make my eyes hurt");
    };

}

public class Amir implements Chef, Student, Iterable<Integer> {

    private class AmirIterator implements Iterator<Integer> {

        private int index = -1;

        @Override
        public boolean hasNext() {
            return index < grades.size();
        }

        @Override
        public Integer next() {
            return null;
        }
    }

    private ArrayList<Integer> grades =new ArrayList<>();

    @Override
    public void study() {

    }

    @Override
    public void cry() {

    }

    @Override
    public Iterator<Integer> iterator() {
        return new AmirIterator();
    }
}
