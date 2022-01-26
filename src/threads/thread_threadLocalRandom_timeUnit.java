package threads;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class thread_threadLocalRandom_timeUnit
{
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.random());      // not always effective with threads
        System.out.println(ThreadLocalRandom.current().nextInt());      // effective with threads

//        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        System.out.println(TimeUnit.DAYS.toSeconds(14));
    }
}
