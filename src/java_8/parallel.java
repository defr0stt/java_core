package java_8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class parallel
{
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("Start of adding : " +
                date.getHours()+ ":" + date.getMinutes() + ":" + date.getSeconds());

        List<Integer> integers = new ArrayList<>();
        for(int i=0; i < 10_000_000; i++){
            integers.add(i);
            integers.add(10_000_000 - i);
        }
        date = new Date();
        System.out.println("End of adding : " +
                date.getHours()+ ":" + date.getMinutes() + ":" + date.getSeconds());
        integers.stream().parallel().count();

        date = new Date();
        System.out.println("After parallel.count() : " +
                date.getHours()+ ":" + date.getMinutes() + ":" + date.getSeconds());
    }
}