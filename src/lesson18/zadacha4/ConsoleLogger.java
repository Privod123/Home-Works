package lesson18.zadacha4;

/**
 * Created by Hello on 11.12.2018.
 */
public class ConsoleLogger implements ILogger {

    @Override
    public boolean write(String message) {
        System.out.println(message);
        return true;
    }
}
