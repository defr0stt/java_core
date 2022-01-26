package threads;

import java.util.concurrent.Exchanger;

public class thread_exchenger
{
    public static void main(String[] args) {

        // this class helps to give information from
        // one thread to another
        // 1-st thread(Man) writes info to exchanger
        // 2-nd thread(Exchanger) takes this info
        Exchanger<String> exchanger = new Exchanger<>();

        new Man(exchanger);
        new Information(exchanger);
    }

    static class Man extends Thread
    {
        Exchanger<String> exchanger;
        public Man(Exchanger<String> exchanger){
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("I'm Donald");
                sleep(1000);
                exchanger.exchange("I'm 20");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Information extends Thread
    {
        Exchanger<String> exchanger;
        public Information(Exchanger<String> exchanger){
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));   // null because of this thread
                System.out.println(exchanger.exchange(null));   // don't give any info
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}