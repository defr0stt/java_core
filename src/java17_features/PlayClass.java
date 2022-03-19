package java17_features;

import java.time.ZonedDateTime;
import java.util.UUID;

public class PlayClass
{
    public static void main(String[] args) {

        System.out.println("Sum = " + StrictFP.calculate());

        Record record = new Record(UUID.randomUUID(),"Apple",15);
        System.out.println(record);
        System.out.println("--------------------");
        System.out.println(record.uuid() + ", " + record.name() + ", " + record.price());


        SealedBird sealedBird = new Mallard().bird();
        // Pattern matching for instanceof
        //      стандартная проверка instanceof, но если true, то
        //      присваеваеться значение sealedBird в duck
        if(sealedBird instanceof Duck duck){
            System.out.println(duck.noise());
        }
        sealedBird = new EmperorPenguin().bird();
        System.out.println(sealedBird instanceof Duck duck ? duck.noise() : "it's not a duck");


        // Switch expressions
        //      теперь switch можеть возвращать значения
        String day = switch (ZonedDateTime.now().getDayOfWeek()){
            case SATURDAY, SUNDAY -> "It's a weekend";
            case MONDAY, THURSDAY, WEDNESDAY -> {
                System.out.println("This day one of the first 3 days");
                // в єтом случае yield вместо return
                yield "MON, TUE or WED";
            }
            default -> "It's a work day";
        };
        System.out.println(day + " : " + ZonedDateTime.now().getDayOfWeek());


        // Text blocks
        // """ - открытие и закрытие соостветственного текстового блока
        String info = """
                Apple is %s and big
                Orange is bigger than a plum
                """.formatted("red");
        System.out.println(info);
    }
}