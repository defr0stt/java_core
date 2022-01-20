package comparable_comparator;

import java.util.*;

class Person implements Comparable<Person>      // інтерфейс додається у тому випадку, якщо є доступ для
{                                               // певного класу, щоб перевизначити compareTo
    private int age;
    private String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.getAge();
    }
}

class CompareAge implements Comparator<Person> {     // Collections.sort(...)

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

class CompareName implements Comparator<Person> {     // Collections.sort(...)

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

public class comparable_comparator
{

    public static void main(String[] args) {

        Set<Person> set = new TreeSet<>();      // примітивні типи сортуються самостійсно
        set.add(new Person(5,"Bob"));
        set.add(new Person(4,"Mike"));
        set.add(new Person(2,"Justin"));
        set.add(new Person(1,"Jonathan"));
        set.add(new Person(10,"Zack"));

        for(Person obj : set)
            System.out.println(obj.getName() + " - " + obj.getAge());

        List<Person> list = new ArrayList<>();
        list.add(new Person(6,"Bob"));
        list.add(new Person(4,"Mike"));
        list.add(new Person(2,"Justin"));
        list.add(new Person(1,"Jonathan"));
        list.add(new Person(10,"Zack"));

        System.out.println("\n-----------\nAge comparison:\n");

        Collections.sort(list,new CompareAge());

        for(Person obj : list)
            System.out.println(obj.getName() + " - " + obj.getAge());

        System.out.println("\n-----------\nName comparison:\n");

        Collections.sort(list,new CompareName());

        for(Person obj : list)
            System.out.println(obj.getName() + " - " + obj.getAge());
    }

}