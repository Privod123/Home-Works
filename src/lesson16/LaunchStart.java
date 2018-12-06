package lesson16;

import java.io.*;
import java.util.Date;

/**
 * Created by Hello on 26.11.2018.
 */
public class LaunchStart implements Serializable{
    private int launchCount;
    private Date lastLaunch;

    //transient - это значит данное поле не будет использоваться при сериализации
    transient private String lastUser;

    public void  update(){
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name");
    }

    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;
    }

    @Override
    public String toString() {
        return "LaunchStart{" +
                "launchCount = " + launchCount +
                ", lastUser = " + lastUser +
                ", lastLaunch = " + lastLaunch +
                '}';
    }
}
