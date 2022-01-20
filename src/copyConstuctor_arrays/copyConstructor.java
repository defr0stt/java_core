package copyConstuctor_arrays;

import java.util.Arrays;

public class copyConstructor
{
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] intArray = { 5, 2, 1, 4, 5 };
        int[] intArray2 = { 6, 7, 8, 9, 10 };
        Arrays.copyOf(intArray,3);

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(Arrays.copyOf(intArray,3)));
        System.out.println(Arrays.toString(Arrays.copyOf(intArray,7)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(intArray,3,6)));
        int[] example = Arrays.copyOf(intArray,3);
//        Arrays.fill(collections,12);                              // заповнення масиву
//        System.out.println(Arrays.toString(collections));
        System.out.println(Arrays.toString(example));
        System.out.println(Arrays.equals(example, Arrays.copyOf(intArray,3)));
        Arrays.sort(example);
        System.out.println(Arrays.toString(example));

    // =======================================================================================

            User u1 = new User(1, "Name 1", new NewOne());

            User u2 = new User(u1);
            User u3 = u1.clone();

            System.out.println(u1 + " " + u1.getId() + " - " + u1.getName() + " - " + u1.getNewOne());
            System.out.println(u2 + " " + u2.getId() + " - " + u2.getName() + " - " + u2.getNewOne());
            System.out.println(u3 + " " + u3.getId() + " - " + u3.getName() + " - " + u3.getNewOne());
    }
}

class User implements Cloneable
{
    private int id;
    private String name;
    private NewOne newOne;

    User(int id, String name, NewOne newOne){
        this.id = id;
        this.name = name;
        this.newOne = newOne;
    }

    User(User user){        // copy constructor
        this(user.getId(),user.getName(),user.getNewOne());
    }       // copy constructor

    @Override
    protected User clone() throws CloneNotSupportedException {   // Overriding clone
//        User user = (User) super.clone();
//        user.newOne = newOne.clone();

        // or

         User user = new User(this.id, this.name, this.newOne);

         return user;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public NewOne getNewOne() { return newOne; }
}

class NewOne implements Cloneable       // if in class structure there is a reference type, so you need to Override it in that class
{                                       // it's called deep cloning
    int simpleValue = 2;

    @Override
    protected NewOne clone() throws CloneNotSupportedException { return (NewOne)super.clone(); }
}