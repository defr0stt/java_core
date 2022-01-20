package exceptions;

public class own extends Exception {

    public own(String message) {
        super(message);
    }
    public own(String message, Throwable cause){
        super(message, cause);
    }
    public own(Throwable cause) {
        super(cause);
    }
    protected own(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public own(){}
}
