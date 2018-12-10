package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Hello on 02.12.2018.
 */
public class IOConnection {

    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public IOConnection(Socket socket)  {
        this.socket = socket;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //send(Message message) - должен записывать (сериализовать) сообщение message в ObjectOutputStream.
    public void send(Message message){
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // receive() - должен читать(десериализовать) данные из ObjectInputStream.
    public Message receive(){
        Message obj = null;
        try {
            obj = (Message) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //getRemoteSocketAddress() - должен возвращать  удаленный адрес сокетного соединения.
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }
}
