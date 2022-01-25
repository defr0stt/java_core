package threads;

public class thread_synch
{
    public static void main(String[] args) {
        Example2 example2 = new Example2();
        Example2 example21 = new Example2();

        Resource resource = new Resource();
        resource.i = 0;

        example2.resource = resource;
        example21.resource = resource;

        example2.resource.i = 5;
        example21.resource.i = 5;

        example2.start();
        example21.start();
    }
}

class Example2 extends Thread{
    Resource resource;
    @Override
    public void run() {
        resource.plus();
    }
}

class Resource {
    int i = 0;
    synchronized public void plus(){    // don't allow threads to interrupt each other
        int i = this.i;
        i++;
        this.i = i;
        System.out.println(" i = " + this.i + "; Method plus : " + Thread.currentThread().getName());
    }
}