package threads;

import java.util.concurrent.*;

public class thread_executor
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // it works in thread pool, so newFixedThreadPool(2) - there is
        // a number of threads what we want to use in program
        // it's so good when we have a program with a big count of threads
        // and every time these 2 threads are going to reuse within creating
        // new threads

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println(executorService.submit(new thread_callable.MyCallable()).get());
        executorService.shutdown();     // waits while threads is going to end their work

        // it's like a scheduler, who says to thread when it will be running

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new thread_condition.ThreadConditionPlus(), 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}