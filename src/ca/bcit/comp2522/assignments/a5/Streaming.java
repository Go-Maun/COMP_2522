package ca.bcit.comp2522.assignments.a5;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streaming {

    /**
     * QUESTION 1: The stream will filter out each integer in list that
     * is divisible by 2 (all odd numbers). The stream then sums up all odd integers
     * that pass through the filter.
     *
     * QUESTION 2: random.ints(1000000,1,3) creates an IntStream of 1000000 numbers ranging
     * from 1 to 3 not upper bound inclusive. Then .boxed() returns a Stream
     * consisting of elements from the IntStream, each boxed to an Integer. Then .collect() is
     * called to perform the Collectors.groupingBy() mutable fold operation. Collectors.groupingBy()
     * groups the Integers objects by the Function.identity() and Collectors.counting()
     * and stores the results in a Map instance. Function.identity() returns the Integer instance
     * and Collectors.counting() counts each element that passes through it. Then .forEach() gets
     * called which goes through each instance of the created map, taking the key and value as
     * Side and Frequency, and prints out each key : value in the map.
     *
     * QUESTION 2 tldr; in essence, it generates one million numbers that are either 1 or 2
     * and counts how many times each number occurs.
     *
     * QUESTION 9: Stream.of(values) will return a Stream<int[]> object. If you wanted a stream
     * of Stream<Integer> then you will have to call Arrays.Stream(values) and take the IntStream
     * that Arrays.Stream() returns and use .boxed() to create a Stream<Integer> object.
     */

    /* generates a List<Character> filled with random letters */
    private static List<Character> words() {
        final int alphabetLetterCount = 26;
        final int loopBound = 30;
        Random random = new Random();
        List<Character> randomCharacters = new ArrayList<>();
        random.ints(loopBound, 'a', 'a' + alphabetLetterCount)
                .forEach(integer -> randomCharacters.add((char) integer));
        return randomCharacters;
    }

    /* sorts a List<Character> in ascending order */
    private static List<Character> ascendingSort(List<Character> list) {
        return list.stream().sorted()
                .collect(Collectors.toList());
    }

    /* sorts a List<Character> in descending order */
    private static List<Character> descendingSort(List<Character> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /* sorts a List<Character> in descending order with no duplicates */
    private static List<Character> descendingSortNoDuplicates(List<Character> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /* Demonstrates how intermediate operations in streams are
    *  lazy by creating a Stream<String> object and calling only
    *  intermediate operations on it, then creating a print statement
    *  and then calling the terminal operation, which runs the
    *  streams created by the intermediate operations. */
    private static void lazyStream(List<String> strings) {
        final int moreThan = 10;
        Stream<String> newStrings = strings.stream()
                .peek(e -> System.out.println("an element passed the peek"))
                .filter(string -> string.length() > moreThan)
                .peek(e -> System.out.println("an element passed the peek after filter"));
        System.out.println("Calling terminal operation on list of strings");
        newStrings.forEach(System.out::println);
    }

    /* The initial characterStream given in the lab document */
    private static Stream<Character> characterStream(String input) {
        List<Character> result = new ArrayList<>();
        for (char c : input.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }

    /* a more optimized version of characterStream */
    private static Stream<Character> characterStreamOptimized(String input) {
        return input.chars().mapToObj(c -> (char) c);
    }

    private static void printList(List<?> list) {
        list.forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    public static void main(String[] args) {
        List<Character> list1 = words();
        List<Character> list2 = words();
        List<Character> list3 = words();

        List<String> stringsList = Arrays.asList("Hello World!", "hello",
                "java is fun", "java", "is", "fun", "streams are cool",
                "filter", "is", "lazy and this shows it");

        System.out.println("Lists before sorting:");
        System.out.print("list1: ");
        printList(list1);
        System.out.print("list2: ");
        printList(list2);
        System.out.print("list3: ");
        printList(list3);

        list1 = ascendingSort(list1);
        list2 = descendingSort(list2);
        list3 = descendingSortNoDuplicates(list3);

        System.out.println("Lists after sorting:");
        System.out.print("list1: ");
        printList(list1);
        System.out.print("list2: ");
        printList(list2);
        System.out.print("list3: ");
        printList(list3);

        lazyStream(stringsList);

        Stream<Character> streamOfChar = characterStreamOptimized("Hello World!");
        streamOfChar.forEach(System.out::println);
    }
}
