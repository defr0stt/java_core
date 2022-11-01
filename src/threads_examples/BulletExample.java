package threads_examples;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class BulletExample {
    static int shootCount;
    static AtomicInteger accurateShots;
    static int ammo;
    static Random random = new Random();

    {
        accurateShots = new AtomicInteger(0);
        ammo = 5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t  --> Shooting gallery <--");
        System.out.print("\n\tEnter count of tries : ");
        shootCount = scanner.nextInt();

        BulletExample bulletExample = new BulletExample();
        BulletThreadShoot bulletThreadShoot = new BulletThreadShoot(bulletExample);
        BulletThreadReload bulletThreadReload = new BulletThreadReload(bulletExample);
        new Thread(bulletThreadReload).start();
        new Thread(bulletThreadShoot).start();
    }

    synchronized public void shoot(){    // ammo capacity = 5
        while (ammo < 3) {
            try {
                System.out.println("  Count of ammo = " + ammo);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(random.nextInt(2) == 1)
            accurateShots.incrementAndGet();
        ammo--;
        System.out.println("  --> Shoot!");
        notifyAll();
    }

    synchronized public void reload(){
        while (ammo>=5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("  Added 1 ammo");
        ammo++;
        notifyAll();
    }

    synchronized public static void stats(){
        System.out.println("\n  Statistic : " + accurateShots.get() + "/" + shootCount +
                " = " + new DecimalFormat("#0.00").format(((double)(accurateShots.get())/(double)(shootCount))*100) + "% accuracy");
    }
}

class BulletThreadShoot implements Runnable {

    BulletExample bulletExample;
    BulletThreadShoot(BulletExample bulletExample){
        this.bulletExample = bulletExample;
    }

    @Override
    public void run() {
        for(int i=0;i<BulletExample.shootCount;i++)
            bulletExample.shoot();
        bulletExample.stats();
    }
}

class BulletThreadReload implements Runnable {

    BulletExample bulletExample;
    BulletThreadReload(BulletExample bulletExample){
        this.bulletExample = bulletExample;
    }

    @Override
    public void run() {
        for (int i = 0; i < BulletExample.shootCount; i++)
            bulletExample.reload();
    }
}