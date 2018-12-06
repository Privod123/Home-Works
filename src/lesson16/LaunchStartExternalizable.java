package lesson16;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * Created by Hello on 26.11.2018.
 */
public class LaunchStartExternalizable implements Externalizable {

    private int launchCount;
    private Date lastLaunch;

    private String lastUser;

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 1;

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
        return "LaunchStartExternalizable{" +
                "launchCount = " + launchCount +
                ", lastUser = " + lastUser +
                ", lastLaunch = " + lastLaunch +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
        out.writeUTF(lastUser);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION){
            throw new IOException("unssuported version");
        }

        launchCount = in.readInt();
        lastLaunch = (Date) in.readObject();

        if (version > 0) {
            lastUser = in.readUTF();
        }
    }
}
