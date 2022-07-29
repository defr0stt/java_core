package java_8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// The Stream API is a new way to work with data structures in a functional way.
// Stream API (a description of the ways in which one computer program can interact
// with another program) is, at its core, a stream of data. The term "thread"
// itself is rather vague in programming in general and in Java in particular.

public class StreamNewReview {
    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>(Arrays.asList("Tom","Jerry","Zack"));
        // perform list in stream of values
        listOne.stream();

        Stream.of(Arrays.asList("two","one"),Arrays.asList("three","four")).flatMap(x -> x.stream()).sorted().forEach(System.out::println);
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(10,20,5,45,10,25,10));
        System.out.println(
                "min = " + Stream.of(10,20,5,45,10,25,10).min(Comparator.comparing(x -> x)).get() + "\n" +
                "max = " + listTwo.stream().max(Comparator.comparing(x -> x)).get()
        );

        System.out.println(
                "sum all : " + listTwo.stream().reduce(0,(acc,elem) -> acc + elem) + "\n"  +
                "sum skipped 3 elems : " +listTwo.stream().skip(3).reduce(0,(acc,elem) -> acc + elem)
        );

        System.out.println(listTwo.stream().filter(x -> x>=20).findAny().get());
        System.out.println(listTwo.stream().filter(x -> x>=200).findAny().orElse(null));
        System.out.println(listTwo.stream().count());

        listTwo.stream().toArray();

        System.out.println(listTwo.stream().anyMatch(x -> x>5));

        // Collectors.joining() can be used only with String
        // that's why map(String::valueOf) is needed
        System.out.println(listTwo.stream().map(String::valueOf).collect(Collectors.joining(";","{","}")));

        // count duplicates of values
        Map<Integer,Long> integerLongMap = listTwo.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(integerLongMap);
    }

    //          -- lambda exp as arguments because of --
    //      -- functional interfaces in method description --
    //
    //  -> eager methods unlike to lazy methods always work
    //
    // .forEach(Consumer) -> void; eager
    // .filter(Predicate) -> boolean; lazy
    // .collect(Collectors.(toSet/toArrayList/toMap)) -> Collection;
    // .map(Function) -> R;    (x -> any type)
    // .flatMap(Function) -> stream;    (x like a one stream of data)
    // .sorted(Comparator) -> R;
    // .min/max(Comparator) -> Optional;
    // .reduce(startValue,...) -> startValue type;  (like adding all elem in list)
    // .sorted/limit/distinct = the same as operators in SQL
    // .skip(n) -> skip n values
    // .findFirst/findAny() -> Optional; return value from selected list
    // .count() -> long; count of elements
    // .anyMatch/noneMatch(Predicate) -> boolean;   check by condition if elem is in list
    // .mapToInt - int statistic
    // .orElse -> If a value is present, returns the value, otherwise returns other.
    //
    // Common :  filter + map,  filter + forEach,  min/max + get,
    //           sorted + forEach, filter + findAny + get
}
