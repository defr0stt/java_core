package threads;

public class thread_deadlock
{
    public static void main(String[] args) {

        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        MyDeadLock1 myDeadLock1 = new MyDeadLock1();
        MyDeadLock2 myDeadLock2 = new MyDeadLock2();

        myDeadLock1.resourceA = resourceA;
        myDeadLock2.resourceB = resourceB;

        myDeadLock1.start();
        myDeadLock2.start();

    }
}

class MyDeadLock1 extends Thread
{
    ResourceA resourceA;
    @Override
    public void run() {
        resourceA.getI();
    }
}

class MyDeadLock2 extends Thread
{
    ResourceB resourceB;
    @Override
    public void run() {
        resourceB.getI();
    }
}

class ResourceA
{
    ResourceB resourceB;
    synchronized public int getI(){
        return resourceB.returnI();
    }
    synchronized public int returnI(){
        return 1;
    }
}

class ResourceB
{
    ResourceA resourceA;
    synchronized public int getI(){
        return resourceA.returnI();
    }
    synchronized public int returnI(){
        return 1;
    }
}