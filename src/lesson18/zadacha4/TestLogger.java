package lesson18.zadacha4;

/**
 * Created by Hello on 12.12.2018.
 */
public class TestLogger {

    public static void main(String[] args) {

        Logger logger = new Logger();

        logger.setiLogger(new ConsoleLogger());
        logger.executeLogger("Use ConsoleLogger - " + "Hello world");

        logger.setiLogger(new FileLogger());
        logger.executeLogger("Use FileLogger - " + "Space");

        logger.setiLogger(new TimeFileLogger());
        logger.executeLogger("Use TimeFileLogger - " + "Space Time");



    }
}
