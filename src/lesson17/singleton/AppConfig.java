package lesson17.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Hello on 03.12.2018.
 */
public class AppConfig {
    private static final File CONFIG = new File("app.properties");

    private static AppConfig instance;

    private final Properties properties;

    private AppConfig(){
        properties = new Properties();
        try {
            // загружаем конфигурацию из потока- файла
            properties.load(new FileInputStream(CONFIG));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  AppConfig getCongig(){
        if (instance == null){
            instance = new AppConfig();
        }
        return instance;
    }

    public String getParam(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        // использование
        AppConfig config = AppConfig.getCongig();
        System.out.println(config.getParam("db.login"));
    }
}
