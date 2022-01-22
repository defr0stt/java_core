package iterator_;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Please note that initially, any iterator reference will point to the index
 * just before the index of the first element in a collection.
 * We don’t create objects of Enumeration, Iterator, ListIterator because they are interfaces.
 * We use methods like elements(), iterator(), listIterator() to create objects. These methods have
 * an anonymous Inner Class that extends respective interfaces and return this class object.
 */

public class iterator_
{
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (int i = 0; i < 20; i++){
            linkedList1.add((int) (Math.random() * 21));
        }

        // ----------
        for (Integer integer : linkedList1){
            System.out.println(integer);
        }
        // == the same
        Iterator<Integer> iterator1 = linkedList1.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        // ----------
        // Iterator - class what helps to get elements
        // Iterable - interface what helps to get elements
        //      needed to override iterator() what returns Iterator<>

        System.out.println("----------------------");
        for(int i : Range.startFinish(0,10)){
            System.out.println(i);
        }
    }

    private static class Range implements Iterable<Integer>
    {
        int start;
        int end;

        Range(int start, int end){
            this.start = start;
            this.end = end;
        }

        public static Range startFinish(int start, int finish){
            return new Range(start, finish);
        }

        @Override
        public Iterator iterator() {                        // return own created iterator like default
            return new OwnIterator(start);
        }

        class OwnIterator implements Iterator<Integer>      // describes own iterator
        {
            private int current;

            public OwnIterator(int current) {
                this.current = current;
            }

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                return current++;
            }
        }
    }
}