package exceptions;

public class exceptions {

    // he Throwable class is the superclass of all errors and exceptions in the Java language.
    // Only objects that are instances of this class (or one of its subclasses) are thrown by the
    // Java Virtual Machine or can be thrown by the Java throw statement.

    public static void main(String[] args) throws own {
        try {
             throw new Exception("it's default exception");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new own("lol, it's my exception", e);
        }
    }
}