package iterator_;

import java.util.*;

public class enumrations
{
    public static void main(String[] args) {

        Vector<Integer> vector1 = new Vector<>();
        for (int i = 0; i < 20; i++){
            vector1.add((int) (Math.random() * 21));
        }

        // Enumeration is for legacy classes(Vector, Hashtable - thread-safe) only.
        // It is not a universal iterator.
        Enumeration enumeration = vector1.elements();
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }
}