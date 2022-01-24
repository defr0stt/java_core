package java_8;

public class anonymous_class
{
    public void eat(){
        System.out.println("I'm eating...");
    }
}

class Main{
    public static void main(String[] args) {
        anonymous_class anonymousClass = new anonymous_class();

        anonymous_class anonymousClass1 = new anonymous_class(){    // successor of anonymous_class class
            @Override                                               // it can override methods whereas to
            public void eat() {                                     // create new class
                System.out.println("You are eating...");;
            }
        };

        anonymousClass.eat();
        anonymousClass1.eat();
    }
}