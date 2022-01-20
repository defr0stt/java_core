package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The process of researching data during the execution of the program
 * allows you to explore information about the methods and constructors of the class.
 * The dark side of java reflection is called for a reason. It completely breaks the PLO paradigm.
 * In java, encapsulation is used to hide and restrict access from one program component to another.
 * Using the private modifier, we mean that access to this field will be only within the class where
 * this field exists, based on this we build a further program architecture. We saw how reflection can get you anywhere.
*/

public class Reflection
{
    private int value;
    private String line;

    public Reflection(){}
    public Reflection(int value, String line){
        this.value = value;
        this.line = line;
    }

    private void print(String lol){
        System.out.println("-- private method - print\n-- private line - " + lol);
    }
}

class Main
{
    public static void main(String[] args) {

        Reflection reflection = new Reflection();
        Class clazz = null;

        String name = null;
        try {
            Field field = reflection.getClass().getDeclaredField("line");
            field.setAccessible(true);
            name = (String) field.get(reflection);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("private field - line(String) = " + name);

        // it helps to find private variables
        // getDeclaredField("line") - finding the field with name line
        // setAccessible(true) - makes access possible to fields

        try {
            Method method = reflection.getClass().getDeclaredMethod("print", new Class[]{String.class});
            method.setAccessible(true);
            method.invoke(reflection, "lol");
//            method.invoke(reflection);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // it helps to find private methods
        // getDeclaredMethod("print", new Class[]{String.class}) - finding the field with name find
        //      and with parameter types in Class[]
        // method.invoke(reflection, "lol") - execution of method in class reflection with parameter "lol"

        reflection = null;

        try {
            clazz = Class.forName(Reflection.class.getName());
            reflection = (Reflection) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // it was a process of creating Reflection objects knows his name
        // with help of Reflection.class.getName()
        // it can be helpful in cases when constructor has no parameters

        reflection = null;

        try {
            clazz = Class.forName(Reflection.class.getName());
            Class[] params = {int.class, String.class};
            reflection = (Reflection) clazz.getConstructor(params).newInstance(1, "default2");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Constructor[] constructors = clazz.getConstructors();
        int count = 1;
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            System.out.print("Constructor " + count + " - ");
            count++;
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + ", ");
            }
            System.out.println();
        }

        // it was a process of creating Reflection objects knows his name
        // with help of Reflection.class.getName()
        // it can be helpful in cases when constructor has some parameters
        // pattern of parameters if Class[] params = ... where I write it

        Method[] method = clazz.getDeclaredMethods();
        // show all methods what were written by developer during class developing
    }
}