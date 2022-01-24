package java_8;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class lmb
{
    public static void main(String[] args) {

        Operations sum = new Operations() {                   // it's called anonymous class
            @Override                                         // because it has an object what
            public int operations(int a, int b) {             // was created by the interface
                return a + b;
            }
        };

        Operations multiplication = (a,b) -> a * b;
        // 1. Creates an anonymous class
        // 2. Operations.operations(int a, int b) -> a, b
        // 3. return int -> return (int)(a * b)

        System.out.println("addition = " + sum.operations(3,4));
        System.out.println("multiplication = " + multiplication.operations(3,4));

        Predicate<Integer> predicate = (x) -> x > 5;
        System.out.println("Predicate check if x = 3 : " + predicate.test(3));
        Consumer<Integer> consumer = (x) -> System.out.println("Called consumer.accept() "+
                "where parameter x is every number");
        consumer.accept(0);
    }

    @FunctionalInterface
    interface Operations{                      // it's functional interface because of it has
        public int operations(int a, int b);   // only 1 method
    }
}