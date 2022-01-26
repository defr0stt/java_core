package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Similar to Runnable, but it returns some value
// using class FutureTask

public class thread_callable
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println("futureTask.get() = " + futureTask.get());   // at the time futureTask.get() all
                                                                        // doings are synchronized
    }

    static class MyCallable implements Callable<Integer>
    {
        @Override
        public Integer call() throws Exception {
            int lol = 0;
            for(int i=0; i<5;i++){
                lol += i;
                Thread.sleep(500);
                System.out.println("lol = " + lol);
            }
            Thread.sleep(500);
            return lol;
        }
    }
}