package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class thread_atomic
{
    static AtomicInteger atomicInteger = new AtomicInteger();  // uses when it needed to change value of the variable
                                                               // using few threads
    static int example = 0;

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());   // creates synchronized ArrayList
                                                                                // all methods are synchronized

        for (int i=0; i<10_000; i++){
            new MyThread().start();
            new MyThread().start();
        }
        Thread.sleep(1_000);
        // sometimes result can be different because of default variable is caching
        System.out.println("Atomic integer = " + atomicInteger);
        System.out.println("Default integer = " + example);
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
            example++;
        }
    }
}