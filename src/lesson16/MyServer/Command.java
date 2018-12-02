package lesson16.MyServer;

import java.io.*;
/**
 * Created by Hello on 29.11.2018.
 */
public class Command implements Externalizable {

//    private String list = "/list_users";
    private String command;
    private String sender;

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 1;

    public String getCommand() {
        return command;
    }

    public String getSender() {
        return sender;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeUTF(command);
        out.writeUTF(sender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION){
            throw new IOException("unssuported version");
        }

        command = in.readUTF();
        sender = in.readUTF();
    }
}
