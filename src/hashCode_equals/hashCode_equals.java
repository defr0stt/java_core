package hashCode_equals;

import java.util.HashSet;
import java.util.Set;

public class hashCode_equals
{
    public static void main(String[] args) {

        Car car1 = new Car(2, "red");
        Car car2 = new Car(2, "red");

        System.out.println(car1.equals(car2));

        Set<Car> set = new HashSet<Car>();
        set.add(car1);
        set.add(car2);
        System.out.println(set.size());
    }
}