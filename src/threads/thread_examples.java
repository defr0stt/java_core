package threads;

public class thread_examples
{
    public static void main(String[] args) {

        // they can interrupt each other
        Example example = new Example();
        example.start();

        Example example1 = new Example();
        example1.start();
    }
}

class Example extends Thread
{
    @Override
    public void run() {
        System.out.println();
        for (int i=0; i<=50; i++){
            System.out.println(" i = " + i + "; Current thread : " + Thread.currentThread().getName());
        }
    }
}