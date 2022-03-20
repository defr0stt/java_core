package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    public static void main(String[] args) {
        logger.info("Start logging");
        logger.log(Level.WARNING,"Warning");

        Handler fileHandler = null;
        try {
            fileHandler = new FileHandler("D:\\Dima\\Programming\\java\\TRAINING\\src\\logging\\log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileHandler.setFormatter(new Logging.MyFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.info("START OF THE PROGRAM");
        logger.log(Level.WARNING,"Warning in the file");
    }
}