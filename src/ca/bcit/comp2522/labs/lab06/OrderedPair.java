package ca.bcit.comp2522.labs.lab06;

import ca.bcit.comp2522.lectures.generics.Box;

import java.util.ArrayList;

public class OrderedPair<K, V> {
    private K first;
    private V second;

    public OrderedPair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static <K, V> boolean same(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.getFirst().equals(p2.getFirst()) && p1.getSecond().equals(p2.getSecond());
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        Box<Double> one = new Box<>();
        Box<Double> two = new Box<>();
        OrderedPair<String, String> strings = new OrderedPair<>("Hello", "World");
        OrderedPair<Integer, ArrayList<Integer>> integerWithArrayList = new OrderedPair<>(1, ints);
        OrderedPair<Box<Double>, Box<Double>> boxes = new OrderedPair<>(one, two);
        OrderedPair<Integer, Integer> int1 = new OrderedPair<>(5, 6);
        OrderedPair<Integer, Integer> int2 = new OrderedPair<>(5, 6);
        OrderedPair<Integer, Integer> int3 = new OrderedPair<>(6, 6);
        System.out.println(OrderedPair.same(int1, int2));
        System.out.println(OrderedPair.same(int1, int3));
    }

}
