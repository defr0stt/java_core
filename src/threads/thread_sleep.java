package threads;

public class thread_sleep
{
    public static void main(String[] args) throws InterruptedException {
        Example1 example1 = new Example1();
        example1.start();
        Thread.sleep(1000);         // it does all doings in run() and then
                                          // stops for a 1 second

        Thread.yield();                   // the current thread is willing to yield its current use of a processor to
                                          // other threads

        example1.join();                  // waits while current thread ends
        System.out.println("main");
    }
}

class Example1 extends Thread
{
    @Override
    public void run() {
        System.out.println();
        for (int i=0; i<=10; i++){
            System.out.println(" i = " + i + "; Current thread : " + Thread.currentThread().getName());
        }
    }
}