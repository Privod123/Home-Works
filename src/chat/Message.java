package chat;

import java.io.Serializable;
/**
 * Created by Hello on 03.12.2018.
 */
public class Message  implements  Serializable{
    private String text;
    private String sender;

    public Message(String text, String sender) {
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
