package lesson18.zadacha4;

/**
 * Created by Hello on 12.12.2018.
 */
public class Logger {

    private ILogger logger;

    public void setiLogger(ILogger iLogger) {
        this.logger = iLogger;
    }

    public boolean executeLogger(String message){
        return logger.write(message);
    }
}
