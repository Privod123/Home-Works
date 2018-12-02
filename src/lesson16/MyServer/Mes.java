package lesson16.MyServer;

import java.io.Serializable;
/**
 * Created by Hello on 27.11.2018.
 */
public class Mes implements Serializable{

    private String text;
    private String sender;

    public Mes(String text, String sender) {
        this.text = text;
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Mes{" +
                " text='" + text + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
