package garbage_collector;

import hashCode_equals.Car;

import java.util.Date;

public class gc
{
    public static void main(String[] args) {

        example();
//        System.gc();    // suggest Java to clear the memory
    }

    public static void example() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory before: " + runtime.totalMemory());
        System.out.println("Free memory before : " + runtime.freeMemory());
        for (int i=0; i< 1_000_000; i++){
            Date date = new Date();
            date = null;
        }
        System.out.println("--------------------");
        System.out.println("Total memory after : " + runtime.totalMemory());
        System.out.println("Free memory after : " + runtime.freeMemory());
        System.out.println("--------------------");
        System.gc();
        System.out.println("Total memory gc : " + runtime.totalMemory());
        System.out.println("Free memory gc : " + runtime.freeMemory());

        Car a = new Car(2,"lol");
        Car b = new Car(2,"lol");
        Car c = a;
        System.out.println(a.equals(b));
    }

    @Override
    protected void finalize() {                             // This method is intended to automatically release system
        System.out.println("-- Memory cleared --");         // resources occupied by the object on which this method
    }                                                       // will be called.

    // 1. finalize () can be used only in two cases:
    // 1.1. Checking / cleaning resources with logging
    // 1.2. When working with native code that is not critical to resource leakage
    // 2. finalize () slows down the GC object cleanup 430 times
    // 3. finalize () may not be called
}