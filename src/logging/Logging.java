package logging;

import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Logging {

    public static class MyFormatter extends Formatter {

        @Override
        public String format(LogRecord record)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            String time = localDateTime.getDayOfMonth() + "-" + localDateTime.getMonthValue() + "-" + localDateTime.getYear() +
                    " " + localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond();
            return time + " -- " + record.getLevel() + " : " + record.getMessage() + "\n";
        }
    }
}