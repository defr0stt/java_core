package pattern_matcher;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pattern_matcher
{

    public static void main(String[] args) {

        System.out.println("\n\t\t-- String.split --\n");

        String line = "Hello, I'm Dima. Java developed by Sun Microsystems.";
        String[] array = line.split("[.,]");    // вказується елемент-роздільник
        for (String temp : array){
            System.out.println(temp);
        }


        //================================================================================================


        System.out.println("-------------------------------------------\n\n\t\t-- String Tokenizer --\n");

        StringTokenizer stringTokenizer = new StringTokenizer(line.toString(),".,",true); // вказується елемент-роздільник
        while (stringTokenizer.hasMoreTokens()){                    // перевірка на подальші роздільники
            System.out.println(stringTokenizer.nextToken());        // вивід тексту
        }


        //================================================================================================


        System.out.println("-------------------------------------------\n\n\t\t-- Scanner --\n");

        Scanner scanner = new Scanner(line);
        while (scanner.hasNext()){
            if(scanner.hasNext("Java"))     // вказується елемент, який потрібно знайти
                System.out.println(" -* " + scanner.next() + " *- ");
            else
                scanner.next();
        }

        line = "1Java2Java3Java";
        scanner = new Scanner(line);

        scanner.useDelimiter("Java");   // вказується елемент, який будемо оминати (рядок пишеться разом)
        while (scanner.hasNext())
            System.out.println(scanner.next());

        //================================================================================================


        System.out.println("-------------------------------------------\n\n\t\t-- Pattern and matcher --\n");

        line = "1 Java 2 Java 3 Java";
        scanner = new Scanner(line);

        scanner.useDelimiter("\\s*Java\\s*");   // вказується кількість пробілів перед та після Java (0...n)
        while (scanner.hasNext())
            System.out.println(scanner.next());

        scanner.useDelimiter("\\s{0}Java\\s{0}");   // вказується кількість пробілів = 0
        while (scanner.hasNext())
            System.out.println(scanner.next());

//        Pattern pattern = Pattern.compile("^1.*");        // починається з чогось
//        Pattern pattern = Pattern.compile("\\w[0-9]\\w");    // в любому місці слово

//        Pattern pattern = Pattern.compile("1\\+1=2");     //
        Pattern pattern = Pattern.compile("\\Q1+1=2\\E");   //  одне й те саме, тільки тут задається чткий шаблон

        Matcher matcher = pattern.matcher("1+1=2");
//        System.out.println(matcher.matches());                // порівняння чисто по заданому шаблону

        while (matcher.find())
            System.out.println("start = " + matcher.start() + " - " + matcher.group());

        System.out.println("dima.sb713@gmail.com".matches("[a-zA-z0-9.]+@[a-z]+.[a-z]{2,4}"));

        line = "my email is dima.sb713@gmail.com";
        pattern = Pattern.compile("\\b[a-zA-z0-9.]+@[a-z]+\\.[a-z]{2,4}");
        matcher = pattern.matcher(line);

        while (matcher.find())
            System.out.println("start = " + matcher.start() + " - " + matcher.group());

        System.out.println("============");

        line = "513ab 57";
        pattern = Pattern.compile("\\d|\\s");       // цифра або пробіл
        matcher = pattern.matcher(line);

        while (matcher.find())
            System.out.println("start = " + matcher.start() + " - " + matcher.group());

        pattern = Pattern.compile(".* 57$");       // кінець рядка
        matcher = pattern.matcher(line);
        while (matcher.find())
            System.out.println("start = " + matcher.start() + " - " + matcher.group());

        System.out.println(matcher.matches());

        System.out.println("============");

        pattern = Pattern.compile("\\d\\d[- /.]\\d\\d[- /.]\\d\\d\\d\\d");       // цифра або пробіл
        matcher = pattern.matcher("01-11-2004");

        while (matcher.find())
            System.out.println("start = " + matcher.start() + " - " + matcher.group());
        System.out.println(matcher.matches());
    }

}