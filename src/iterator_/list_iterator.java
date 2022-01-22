package iterator_;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * An Iterator is an interface in Java and we can traverse the elements of a list
 * in a forward direction whereas a ListIterator is an interface that extends the Iterator
 * interface and we can traverse the elements in both forward and backward directions.
 * An Iterator can be used in these collection types like List, Set, and Queue whereas
 * ListIterator can be used in List collection only. The important methods of Iterator interface are
 * hasNext(), next() and remove() whereas important methods of ListIterator interface are
 * add(), hasNext(), hasPrevious() and remove().
 */

// It is only applicable for List collection implemented classes like ArrayList, LinkedList, etc.
// It provides bi-directional iteration. ListIterator must be used when we want to enumerate elements of List.
// This cursor has more functionality(methods) than iterator.

public class list_iterator
{
    public static void main(String[] args) {
        ArrayList al = new ArrayList();

        for (int i = 0; i < 10; i++)
            al.add(i);

        System.out.println(al);

        ListIterator ltr = al.listIterator();

        while (ltr.hasNext()) {
            int i = (Integer)ltr.next();

            System.out.print(i + " ");

            // Changing even numbers to odd and
            // adding modified number again in
            // iterator
            if (i % 2 == 0) {
                // Change to odd
                i++;
                // Set method to change value
                ltr.set(i);
                // To add
                ltr.add(i);
            }
        }

        // Print and display statements
        System.out.println();
        System.out.println(al);
    }
}