package threads;

import java.util.concurrent.Semaphore;

public class thread_semofore
{
    public static void main(String[] args) {

        // the analogy - tables in restaurant
        // in constructor Semaphore(2) - 2 is count of threads
        // what can work at the same time
        // methods table.acquire() and table.release() check count
        // of threads that are working
        Semaphore table = new Semaphore(2);

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();
        Person person7 = new Person();

        person1.table = table;
        person2.table = table;
        person3.table = table;
        person4.table = table;
        person5.table = table;
        person6.table = table;
        person7.table = table;

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();
    }
}

class Person extends Thread
{
    Semaphore table;
    @Override
    public void run() {
        System.out.println(this.getName() + " waiting for a table");
        try {
            table.acquire();
            System.out.println(this.getName() + " is eating at the table");
            for (int i=0;i<3;i++){
                sleep(500);
                System.out.print(".");
            }
            System.out.println();
            System.out.println(this.getName() + " released the table");
            table.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}