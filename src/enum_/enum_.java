package enum_;

import hashCode_equals.Car;

public class enum_
{
    public static void main(String[] args) {

        String s1 = new String("collections");
        String s2 = new String(s1.toString());

        System.out.println(s1 + " " + s2);
        System.out.println(s1 == s2);

        String lol = "pointer";
        System.out.println(lol.charAt(5));

        System.out.println("\nLamborghini : " + Cars.Lamborghini.getRating() + " rate");

        String a = new String("a");
        palindrome(1,a );
        System.out.println(a);
    }

    public static String palindrome(int a, String b) {

        String eq = String.valueOf(a);
        b = "b";
        System.out.println(b);

        int left, right;
        left = 0;
        right = eq.length() - 1;
        while (left < right) {
            if (eq.charAt(left) != eq.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        if(left >= right) return "Palindrome";
        return "Not palindrome";
    }
}

enum Cars
{
    Volkswagen(8),
    Lamborghini(10),
    Ford(7),
    Mitsubishi(8);

    private int rating;

    Cars(int rating)
    {
        this.rating = rating;
    }

    public int getRating (){
        return this.rating;
    }
}