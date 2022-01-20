package classLoader;

import hashCode_equals.Car;

public class cl
{
    public static void main(String[] args) {

        // class loader - Any class used in the environment was executed in one way
        //      or another by a bootloader in Java.
        // there are examples of classes and their class loaders

        System.out.println(Car.class.getClassLoader());
        System.out.println(collections.collections.class.getClassLoader());

        String text = "text";
        Class<String> stringClass = null;
        System.out.println(text.getClass().getClassLoader());
        try {
            System.out.println(stringClass.getClass().getClassLoader());
        } catch (NullPointerException e) {
            System.out.println("It was an exception");
        }

    }
}
