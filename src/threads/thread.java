package threads;

public class thread
{
    public static void main(String[] args) {

        // these 2 threads are working parallel, so they always go to "thread pool"
        // they can start in random order
        MyThread myThread = new MyThread();
        myThread.start();   // process of creating new thread, it can start 1 time, then it closes

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}

class MyThread extends Thread
{
    // it overrides because of start "turn on" method start
    @Override
    public void run() {
        System.out.println("\nCurrent thread : " + Thread.currentThread().getName());
        System.out.println("This is new thread (class extends Thread)");
    }
}

class MyRunnable implements Runnable
{
    @Override
    public void run() {
        System.out.println("\nCurrent thread : " + Thread.currentThread().getName());
        System.out.println("This is new thread (class implements Runnable)");
    }
}