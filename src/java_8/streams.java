package java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams
{
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");

        // automatically closed after 1 using
        // next time u need to create new stream
        Stream<String> stringStream = stringList.stream();
        stringStream.forEach( (x) -> System.out.println(x));

        System.out.println("--------------------");
        stringList.stream().forEach((x) -> System.out.println(x));
        System.out.println("--------------------");
        stringList.stream().filter( (x) -> {
            System.out.println("is first.equals(" + x + ") - " + x.equals("first"));
            return x.equals("first");
        }).count();      // filter - lazy    count - eager

        System.out.println("--------------------");
        Set<String> stringSet = stringList.stream().collect(Collectors.toSet());    // can perform stream to any collections
        System.out.println(stringSet);

        // method reference = 1-st class for what I want to call this method, 2-nd method
        System.out.println("--------------------");
        Stream.of("one","two").map(String::toUpperCase).forEach(System.out::println);

        System.out.println("--------------------");
        Stream<String> stream = Stream.of("hello 1","hello 2","hello 3");
        stream.map(x -> {
            System.out.println(x);
            return x;
        }).forEach(x -> System.out.println("This line in foreach : " + x));

        System.out.println("--------------------");
        // supplier helps to use your stream many times
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("hello 1","hello 2","hello 3");
        streamSupplier.get().forEach(x -> System.out.println("Using supplier 1-st time" + x));
        streamSupplier.get().forEach(x -> System.out.println("Using supplier 2-nd time" + x));
    }
}