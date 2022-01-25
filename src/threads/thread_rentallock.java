package threads;

import java.util.concurrent.locks.ReentrantLock;

public class thread_rentallock
{
    public static void main(String[] args) {
        Lock lock = new Lock();
        lock.start();
    }
}
// ReentrantLock it's like synchronized but more flexible
// you can put reentrantLock.lock() at the start of method and reentrantLock.unlock()
// at the end and these methods will be something like synchronized
class Lock extends Thread
{
    ReentrantLock reentrantLock = new ReentrantLock();
    int i;
    int j;
    @Override
    public void run() {
        this.plusI();
        this.plusJ();
    }

    public void plusI(){
        reentrantLock.lock();       // start of lock
        int i = this.i;
        i++;
        this.i = i;
        System.out.println(" i = " + this.i + "; Method plus : " + Thread.currentThread().getName());
    }
    public void plusJ(){
        int j = this.j;
        j++;
        this.j = j;
        System.out.println(" j = " + this.j + "; Method plus : " + Thread.currentThread().getName());
        reentrantLock.unlock();     // end of lock
    }
}