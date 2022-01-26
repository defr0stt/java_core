package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// this class point how many times method await()
// will be called and after that second parameter
// starts method start()

public class thread_cyclicBarier
{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new Run());
        new SportsMen(cyclicBarrier);
        new SportsMen(cyclicBarrier);
        new SportsMen(cyclicBarrier);
    }

    static class Run extends Thread
    {
        CyclicBarrier cyclicBarrier;
        @Override
        public void run() {
            System.out.println("Race is begun");
        }
    }

    static class SportsMen extends Thread
    {
        CyclicBarrier cyclicBarrier;
        public SportsMen(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println("Sportsman is waiting...");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}