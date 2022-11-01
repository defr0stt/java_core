package collections;

import java.util.*;

public class collections
{
    public static void main(String[] args) {

//        arrayList();
//        linkedList();
//        setCollection();
//        mapCollection();
//        queue();
        stack();
    }

    public static void arrayList()  // vector is the same but thread-safe
    {

        // ==============================================================================================
        //                                      ArrayList
        // ==============================================================================================

        ArrayList<String> arrayList1 = new ArrayList<>();    // by default capacity = 10 elements; in (...) u can change capacity
        ArrayList<String> arrayList2 = new ArrayList<>();    //

        arrayList1.add("first");                        // 1-st : checking : is available place to add element? - ensureCapacity(size+1)
        arrayList1.add("third");                        // 2-nd : add element in the end
                                                        // if the is no place to add element (capacity is achieved) so
                                                        //      newCapacity = (oldCapacity * 3) / 2 + 1
                                                        //      and mechanism of copying : System.arraycopy()


        arrayList1.add(1,"second");        // adding in the middle of array
                                                        // 1-st : checking : is available place to add element? - ensureCapacity(size+1)
                                                        // 2-nd : mechanism of copying : System.arraycopy()
                                                        // 3-rd : rewriting of element with the specified index
                                                        //      in case when process of inserting is going and there is
                                                        //      no place to insert that's why System.arraycopy() performed twice

        arrayList1.set(2,"zero");                       // change element on separate position

        arrayList2.addAll(arrayList1);                  // adding elements from arrayList1 to arrayList2
        arrayList2.addAll(1,arrayList1);           // adding elements from arrayList1 in specified index to arrayList2
                                                        // this method can call System.arraycopy() 3 times, but it's faster than
                                                        // element-by-element adding

        arrayList2.remove(4);                     // deleting by index
                                                        // 1-st : count element that needed to be copied : size - index - 1
                                                        // 2-nd : using System.arraycopy() copy size - index - 1 count
                                                        //        of elements from this index to end
                                                        // 3-rd : reduce array size and last element = null

        arrayList2.remove("first");                  // deleting by object
                                                        // chek all elements while element what we need haven't check for
                                                        // the first time

        arrayList1.contains("fifth");                   // returns true/false but not the exact amount of elements

        arrayList1.trimToSize();                        // capacity = size

        arrayList1.subList(0,2);                        // returns a list with index of elements 0 and 1

        arrayList1.clone();                             // creates a clone of current list

        arrayList1.removeAll(arrayList2);               // remove all equal elements from arrayList1

        arrayList1.removeIf(a -> (a.equals("fourth"))); // remove if element on array .equals("fourth")

        arrayList2.retainAll(arrayList1);               // delete all elements from arrayList2 what not contained in arrayList1

        arrayList2.ensureCapacity(100);       // choose your capacity

        // - Fast access to elements by index in O(1) time;
        // - Access to elements by value in linear time O(n);
        // - Slow when elements are inserted and removed from the "middle" of the list;
        // - Allows you to store any values including null;
        // - Not synchronized.
    }

    public static void linkedList()                                 // All work with LinkedList comes down to changing links.
    {

        // ==============================================================================================
        //                                      LinkedList
        // ==============================================================================================

        LinkedList<String> linkedList1 = new LinkedList<>();        // creating linked list - created header and
                                                                    // size = 0
                                                                    // header.next = header.prev = header;
                                                                    // element = null;

        linkedList1.add("last1");                                   // adding in the end of the list
        linkedList1.addLast("last2");                            // 1-st : crating copy of class object Entry
                                                                    //      private static class Entry<E> {
                                                                    //        E element; Entry<E> next; Entry<E> prev;
                                                                    //      ... (constructor)  }
                                                                    //              ...
                                                                    //      Entry newEntry = new Entry("0", header, header.prev);
                                                                    // 2-nd : pointers to the previous and next items are overridden
                                                                    //        newEntry.prev.next = newEntry;
                                                                    //        newEntry.next.prev = newEntry;
                                                                    //        size++;

        linkedList1.addFirst("first");                           // adding in the start of the list

        linkedList1.add(1,"middle");                   // adding in the index place of the list
                                                                    // 1-st : find needful element with specified index
                                                                    //        (index == size ? header : entry(index))
                                                                    //        entry(index) - runs through the list in search
                                                                    //        of the item with the specified index.

        linkedList1.remove(3);                                // deletes by index
                                                                    // 1-st : finding separate element ( O(n) )
                                                                    // 2-nd : pointers to the previous and next items are overridden
                                                                    //          E result = e.element;
                                                                    //          e.prev.next = e.next;
                                                                    //          e.next.prev = e.prev;
                                                                    // 3-rd : removing pointers to other elements and
                                                                    //        forgetting the element itself
                                                                    //          e.next = e.prev = null;
                                                                    //          e.element = null;
                                                                    //          size--;

        linkedList1.removeFirst();                                  // deletes first element (constant time) = remove()
        linkedList1.removeLast();                                   // deletes last element (constant time)

        linkedList1.remove("lol");                               // process of checking the whole list while needful
                                                                    // value haven't met (deletes first founded element)

        linkedList1.element();                                      // returns first element of list = getFirst()

        ListIterator<String> listIterator = linkedList1.listIterator();  // iterator from the start
                                                                         //        while (listIterator.hasNext())
                                                                         //            System.out.println(listIterator.next());
        linkedList1.descendingIterator();                                // iterator from the end

        linkedList1.offer("lol");                                // the same as add() but throw boolean, not exception

        linkedList1.peek();                                         // returns first element of list = getFirst()

        linkedList1.poll();                                         // returns first element of list = getFirst() and deletes it

        linkedList1.pop();                                          // deletes first element of list = removeFirst()

        linkedList1.push("KA-BOOM");                             // = addFirst();

        // - From LinkedList you can organize a stack, queue, or double queue, with access time O(1);
        //  - It will take linear time O(n) to insert and remove from the middle of the list, retrieve an item by index or value.
        //    However, adding and removing from the middle of the list using ListIterator.add() and ListIterator.remove() will require O(1);
        //  - Allows you to add any values, including null. For storage of primitive types uses corresponding classes-wrappers;
        //  - Not synchronized.
    }

    public static void setCollection()
    {

        // ==============================================================================================
        //                                            Sets
        // ==============================================================================================

        // HashSet: using a hash map behind the set; 16 - size of hash table
        // LinkedHashSet: using a linked list as a collision management technique in the hash map which is used behind the set
        // EnumSet: much faster than HashSet.
        // TreeSet: using a tree behind the set; implementation of the SortedSet

        Set<String> set1 = new HashSet<>();             // the same methods as ArrayList
        Set<String> set2 = new LinkedHashSet<>();       // extends the HashSet class without adding any new methods
        Set<Cars> set3;
        Set<String> set4 = new TreeSet<>();

        set1.add("Ukraine");                            // adds value in case of this value hasn't contained in a set
        set1.add("France");
        set1.add("Switzerland");
        set1.add("England");

        Iterator<String> iterator1 = set1.iterator();    // returns iterator
                                                         // while (iterator.hasNext())
                                                         //     System.out.println(iterator.next());

        set2.add("Ukraine");
        set2.add("France");
        set2.add("Sweden");
        set2.add("Poland");

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);                              // union of 2 or more sets

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);                    // intersection of 2 or more sets (save only equal values)

        Set<String> difference = new HashSet<>(set1);    // save only not equal values from 1-st set
        difference.removeAll(set2);

        //  HashSet - unordered (The objects are inserted based on their hashcode); using only hash table
        //  LinkedHashSet - add values in order; using hash table and double linked list

        set3 = EnumSet.of(Cars.Volkswagen, Cars.Lamborghini,
                Cars.Mitsubishi, Cars.Ford);
        if(set3.contains(Cars.Ford))
            System.out.println(Cars.Ford);
        // An EnumSet will be used when you have the need for a variable to assume more than one Enum value at the same time.

        // All of the elements in an enum set must come from a single enumeration type that is specified when
        // the set is created either explicitly or implicitly.

        set4.add("Ukraine");
        set4.add("France");
        set4.add("Switzerland");
        set4.add("England");

        // It behaves like a simple set with the exception that it stores elements in a sorted format.
        // TreeSet uses a tree data structure for storage. Objects are stored in sorted, ascending order.

        //  Complexity Of remove Method :
        //      HashSet remove method have constant time complexity O(1).
        //      TreeSet remove method have constant time complexity O(log(n)).
        //      LinkedHashSet remove method have constant time complexity O(1).

        //  Complexity Of add Method :
        //      HashSet add method have constant time complexity O(1).
        //      TreeSet add method have constant time complexity O(log(n)).
        //      LinkedHashSet add method have constant time complexity O(1).
    }

    public static void  mapCollection()
    {
        // ==============================================================================================
        //                                          Map
        // ==============================================================================================

        // HashMap: based on hash-tables; capacity by default = 16; max capacity = int.MAX / 2
        // LinkedHashMap: symbiosis of linked lists and hash maps
        // HashTable: same as HashMap but thread-safe
        // TreeMap:

        Map<Integer,String> map1 = new HashMap<>();         // 1. Table - For start array with type Entry[] - links on
                                                            //      lists of values
                                                            // 2. LoadFactor - coefficient between time and memory (0.75)
                                                            // 3. Threshold - limit of elements, after that value it
                                                            //      calculates like : capacity * LoadFactor
                                                            // 4. Size - count of elements

        map1.put(1,"first");                                // adding element
        map1.put(2,"first");                                // 1-st : check for null
                                                            // 2-nd : doing the hash-code : hash(hashCode)
                                                            // 3-rd : choosing the position for element - indexFor(hash, tableLength)
                                                            // 4-th : checking for duplicates; rewrite if hashCode and value
                                                            //          are equal for one of the elements
                                                            // 5-th : if this element is new - addEntry(hash, key, value, index)
                                                            //
                                                            // if element = null checks all table and calls addEntry(0, null, value, 0);
                                                            // hashcode & (length - 1) = 14 -- position in array
                                                            //      if this position occupied it goes in the start of array

        map1.put(2,"lol");                                  // changing element value
        map1.replace(2,"second");                           //

        map1.keySet();                                      // returns set of keys

        map1.entrySet();                                    // returns set of keys and values

        map1.values();                                      // returns set of values

        map1.remove(1);                                 // remove element with this key
        map1.remove(1,"first");                             // remove element if this value applies to this key (return boolean)

        // in case when size = 16; methods : resize(...),
        // transfer(newTable) - sorts all the elements of the current repository, recalculates their indexes
        //      and redistributes the elements in the new array.
        // no opportunity to use trimToSize()

        // Iterator varieties
        for(Map.Entry<Integer, String> entry : map1.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());

        for (Integer key: map1.keySet())
            System.out.println(map1.get(key));

        Iterator<Map.Entry<Integer, String>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        // - Adding an element is performed in time O(1), because new elements are inserted at the beginning of the chain;
        // - Item retrieval and deletion operations can be performed in time O(1) if the hash function distributes
        //          the elements evenly and there are no collisions.
        // - Keys and values can be of any type, including null. Appropriate wrap classes are used to store primitive types;
        // - Not synchronized.

        Map<Integer, String> map2 = new LinkedHashMap<>();          // 1. Header - head of list (head.hash = -1)
                                                                    // 2. Access order - if true -> while we get() this element goes to end
                                                                    //                   if false -> in order of inserting

        map2.put(1,"first");                                        // put() -> addEntry() -> createEntry()

        // Time add(), contains(), remove() remains a constant - O(1).
        // You will need a little more memory space to store the items and their connections.
        // There are not many serious differences in the implementation of HashMap and LinkedHashMap. We can mention a couple of small:
        // The transfer() and containsValue() methods are a bit simpler due to the bi-directional connection between the elements;
        // The recordRemoval() and recordAccess() methods are implemented in the LinkedHashMap.Entry class
        // (the same one that ends an element with accessOrder = true). In HashMap, both of these methods are empty.

        Map<Integer, String> map3 = new TreeMap<>();                // realization of black-red tree

        map3.put(2,"first");                                        // first - root, other elements - left or right to root
        map3.put(1,"first");
        map3.put(0,"first");
    }

    public static void queue()
    {
        Queue<String> queue1 = new PriorityQueue<>();   // FIFO - first in first out (sorted)

        queue1.add("one");                              // add element first in queue
        queue1.offer("two");                         // same as add but doesn't throw an exception

        Iterator<String> iterator = queue1.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        queue1.peek();                                  // returns first element
        queue1.element();                               // same as peek but throws an exception

        queue1.poll();                                  // returns first element and deletes it
        queue1.remove();                                // same as poll() but it throws an exception

        Queue<String> queue2 = new LinkedList<>();      // like linked list (order of adding)

        Deque<String> deque1 = new LinkedList<>();      // LIFO - last in first out ; like queue and stack

        Deque<String> deque2 = new ArrayDeque<>();      // same as linked list but based on array (better to use)
                                                        // faster than stack (used as a stack)
                                                        //      and linked list (used as a queue)
    }

    public static void stack()
    {
        Stack<String> stack1 = new Stack<>();           // LIFO -last in first out ; like queue and stack
                                                        // thread-safe

        stack1.add("one");                              // from vector
        stack1.add("three");                            //
        stack1.push("two");                        // stack method

        Iterator<String> iterator = stack1.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}

enum Cars
{
    Volkswagen(8),
    Lamborghini(10),
    Ford(7),
    Mitsubishi(8);

    private int rating;

    Cars(int rating)
    {
        this.rating = rating;
    }

    public int getRating (){
        return this.rating;
    }
}