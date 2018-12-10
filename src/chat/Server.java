package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hello on 27.11.2018.
 */
public class Server {

    private  int port;
    private Set<String> list_user;
    private Date date;

    public Server(int port) {
        this.port = port;
        this.list_user = new HashSet<>();
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
                System.out.println("Server started on: " + serverSocket);
                while (true){
                    Socket socket = serverSocket.accept();
                    IOConnection ioConnection = new IOConnection(socket);
                    Message text = ioConnection.receive();
                    if (!(text.getText().equals(""))) {
                        printMessage(text);
                        String answer = " получил сообщение от " + text.getSender();
                        ioConnection.send(new Message(answer, "Server"));
                    } else {
                        list_user.add(text.getSender());
                        String answer = " работает ";
                        ioConnection.send(new Message(answer, "Server"));
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(Message message){
        System.out.println(message.getSender() + "  :  " + message.getText());
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        server.start();
    }
}
