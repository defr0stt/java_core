package threads;

import java.util.concurrent.CountDownLatch;

public class thread_countDownLatch
{
    public static void main(String[] args) throws InterruptedException {

        // countDownLatch is like counter of threads
        // for start all job is going to be done with method await()
        // and then program can do other things
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        countDownLatch.await();
        System.out.println("So, all jobs are done");
    }
}

class Work extends Thread
{
    CountDownLatch countDownLatch;

    Work(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        start();
    }

    static int i = 1;
    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work #" + (i++) + " is done");
        countDownLatch.countDown();
    }
}