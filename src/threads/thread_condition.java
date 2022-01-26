package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Conditions are so similar to wait() and notify()
// with methods await() and signal; At the same time we can
// use conditions with classes : Lock, ReentrantLock, ...

public class thread_condition
{
    static Lock reentrantLock = new ReentrantLock();
    static Condition condition = reentrantLock.newCondition();
    static int value;

    public static void main(String[] args) {
        new ThreadConditionMinus().start();
        new ThreadConditionPlus().start();
    }

    static class ThreadConditionPlus extends Thread
    {
        @Override
        public void run() {
            reentrantLock.lock();
            System.out.println("value = " + (++value));
            condition.signal();
            reentrantLock.unlock();
        }
    }

    static class ThreadConditionMinus extends Thread
    {
        @Override
        public void run() {
            reentrantLock.lock();
            if(value < 1){
                try {
                    System.out.println("No money, value = " + value);
                    condition.await();
                    System.out.println("Oh, there is something new, value = " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("value = " + (--value));
            reentrantLock.unlock();
        }
    }
}