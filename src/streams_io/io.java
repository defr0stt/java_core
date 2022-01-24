package streams_io;

import java.io.*;
import java.nio.charset.StandardCharsets;

// The main difference between Byte Stream and Character Stream in Java is that the Byte Stream helps
// to perform input and output operations of 8-bit bytes while the Character Stream helps
// to perform input and output operations of 16-bit Unicode.
//
// A stream is a sequence of data that is available over time. A source generates data as a stream.
// Destination consumes or read data are available as a stream. In other words,
// a stream explains the flow of data which allows reading or writing. Two ways of performing
// operations on streams in Java are by using Byte Stream and character stream.

// FileReader/FileWriter - character
// FileInputStream/FileOutputStream - byte

public class io
{
    public static void main(String[] args) {

        File file = new File("example.txt");
        // check file if it exists
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File was not created yet");
            }
        }

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        InputStreamReader inputStreamReader = null;
        FileWriter fileWriter = null;

        int bytes = 0;
        String line = "-- KAWABANGA --";
        String result = "";

        try {
            // rewriting data to file
            fileOutputStream = new FileOutputStream("example.txt");
            fileOutputStream.write(line.getBytes(StandardCharsets.UTF_8));

            // reading data from file
            fileInputStream = new FileInputStream("example.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");     // note second parameter
            while ((bytes = inputStreamReader.read()) != -1){                                  // as coding
                result += Character.toString(bytes);
            }
            System.out.println("Info from file :\n" + result);

            // adding info to file
            fileWriter = new FileWriter(file, true);    // second parameter it's a boolean value that means
            fileWriter.write(line);                            // what we want to do with file : rewrite or add info

        }  catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// A stream refers to a sequence of data. Two methods of performing operations on streams
// in Java are using Byte Stream and character stream. The main difference between
// Byte Stream and Character Stream in Java is that Byte Stream helps to perform
// input and output operations of 8-bit bytes while Character stream helps to perform
// input and output operations of 16-bit Unicode.