package java_8;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    // functional interfaces have only 1 method
    // it usually uses in lambda expressions

    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x >= 0;
        Consumer<Integer> consumer = x -> System.out.println("consumer -> value = " + x);
        Function<Integer,String> function = x -> String.valueOf(x);
        Supplier<Integer> supplier = () -> Integer.parseInt("123");
        UnaryOperator<Integer> unaryOperator = (x) -> x * x;
        BinaryOperator<Integer> binaryOperator = (x,y) -> Integer.parseInt(String.valueOf(Math.pow(x,y)));

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        // lambda expressions can be used in parameters
        // where functional interface is defined
        salaries.replaceAll((name, oldValue) ->
                name.equals("Freddy") ? oldValue : oldValue + 10000);

        // own interface
        OwnFunctionalInterface<Integer> ownFunctionalInterface = (x,y) -> x.hashCode() + y.hashCode();
        System.out.println(ownFunctionalInterface.action(1,2));
    }

    // Predicate<n1>; .test(n1) -> true/false
    // Consumer<n1>; .accept(n1) -> (void)
    // Function<n1, n2>; .accept(n1) -> n2
    // Supplier<n1>; .get() -> n1
    // UnaryOperator<n1>; .identity() -> n1
    // BinaryOperator<n1>; .apply(n1,n1) -> n1
}

@FunctionalInterface
interface OwnFunctionalInterface<T> {
    T action(T a, T b);
}