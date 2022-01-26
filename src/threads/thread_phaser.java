package threads;

import java.util.concurrent.Phaser;

// distribution of task stages

public class thread_phaser
{
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);          // count of registered threads
        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer extends Thread
    {
        Phaser phaser;
        Washer(Phaser phaser){
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for(int i=0; i<3; i++){
                if(getName().equals("Thread-0")){
                    System.out.println(getName() + " is washing the car inside...");
                } else if(getName().equals("Thread-1")){
                    System.out.println(getName() + " is washing the car outside...");
                }
                phaser.arriveAndAwaitAdvance();     // waiting while every thread don't end its job till this stage
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}