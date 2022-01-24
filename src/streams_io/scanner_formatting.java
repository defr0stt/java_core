package streams_io;

// Java provides a class java.util.Scanner object of which are used to break
// the formatted input data to the particular tokens according to their data type.
// Scanner separates the tokens using a delimiter, the default delimiter that the
// Scanner uses is the white space except this to use a delimiter one can use
// the useDelimiter() method by giving a specified pattern.

// Scanning it's like scanner when we write info (scanner and methods with it)
// Formatting it's when we show our info (print,println,printf,String.format)

import java.util.Scanner;

public class scanner_formatting
{
    public static void main(String[] args) {

        System.out.print("Enter your value : ");

        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        String exampleText = String.format("Example ~text~ with -[special]- format : your value = %d",value);
        System.out.println(exampleText);
    }
}
