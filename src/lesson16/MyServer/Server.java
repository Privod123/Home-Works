package lesson16.MyServer;

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
                    getMessage(socket);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(Socket socket){
        try (InputStream in = socket.getInputStream()) {
            ObjectInputStream objIn = new ObjectInputStream(in);
            Object object = objIn.readObject();
            if (object instanceof Mes){
                Mes message = (Mes) object;
                list_user.add(message.getSender());
                if (!(message.getText().equals(""))){
                    printMessage(message);
                }
            }else {
                Command command = (Command) object;
                System.out.println(command.getSender() + " послал команду : ' " + command.getCommand() + " '");
                if (command.getCommand().equals("/list_users")){
                    System.out.println("Were on the server :");
                    for (String user : list_user) {
                        System.out.println(user);
                    }
                }
                if (command.getCommand().equals("/server_time")){
                    date = new Date();
                    System.out.println(date);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(Mes message){
        System.out.println(message.getSender() + "  :  " + message.getText());
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        server.start();
    }
}
