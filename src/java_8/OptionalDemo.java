package java_8;

import java.util.Optional;
import java.util.Random;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = stringReturn();
        if(optional.isPresent())
            System.out.println(optional);
        else
            System.out.println("fail :(");
    }

    public static Optional<String> stringReturn(){
        int temp = (new Random().nextInt(10)) + 1;
        if(temp <= 4)
            return Optional.of("value <= 4");
        return Optional.empty();
    }
}
