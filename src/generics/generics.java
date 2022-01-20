package generics;

import java.util.ArrayList;

public class generics
{
    public static void main(String[] args) {

        Information<String> information = new Information<>("10");
        System.out.println(information.toString());

        ArrayList<Integer> arrayList= new ArrayList<>();
        arrayList.add(1);
        int result = arrayFirstElement(arrayList);
        System.out.println(" -- " + result + " -- ");

        Qwerty<Temp> qwerty1 = new Qwerty<Temp>(new Temp());
        qwerty1.car();
        Qwerty<Temporary> qwerty2 = new Qwerty(new Temporary());
        qwerty2.car();

        Information<? super Toyota> information1 = new Information<Car>(new Toyota());  // <Toyota>
        Information<? extends Toyota> information2 = new Information<Toyota>(new Corolla());  // <Corolla>
    }

    public static <Type> Type arrayFirstElement(ArrayList<Type> arrayList){
        return arrayList.get(0);
    }
}

class Car{}
class Toyota extends Car{}
class Corolla extends Toyota{}

class Information <Type>
{
    private Type infoValue;
    Information(Type infoValue){
        this.infoValue = infoValue;
    }

    public Type getInfoValue() {
        return infoValue;
    }

    @Override
    public String toString(){
        return "Info value = " + infoValue;
    }
}

class Temp{
    void speed(){
        System.out.println("km/h - value");
    }
}

class Temporary extends Temp{}

class Qwerty<Type extends Temp>{    // запозичення характеристик

    Type variable;
    Qwerty(Type variable){
        this.variable = variable;
    }
    void car(){
        variable.speed();
    }
}