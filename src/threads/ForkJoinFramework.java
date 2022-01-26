package threads;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFramework
{
    static long numOfOperations = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        long longOne = 0;
        System.out.println(new Date());
        for (long i=0; i<numOfOperations; i++){
            longOne += i;
        }
        System.out.println("longOne = " + (longOne));
        System.out.println(new Date());

        System.out.println("--------------------");
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        pool.invoke(new MyFork(0,numOfOperations));
        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long>
    {

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to-from) <= numOfOperations/numOfThreads){       // if operation consists of several parts
                long longOne = 0;
                for (long i=from; i<to; i++){
                    longOne += i;
                }
                return longOne;
            } else {    // if not break into several parts
                long middle = (to+from)/2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1 , to);
                secondHalf.fork();
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}