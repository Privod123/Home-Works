package lesson16.MyServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * Created by Hello on 27.11.2018.
 */
public class Client<T> {

    private SocketAddress socketAddress;
    private Scanner scanner;

    public Client(SocketAddress socketAddress, Scanner scanner) {
        this.socketAddress = socketAddress;
        this.scanner = scanner;
    }

    public void start(){
        System.out.println("Enter your name :");
        String name = scanner.nextLine();
        buildAndSendMes("",name);

        while (true){
            System.out.println("Enter your massege");
            String mes = scanner.nextLine();
            if (mes.equals("/list_users") || mes.equals("/server_time")){
                buildAndSendExecute(mes,name);
            } else{
                buildAndSendMes(mes, name);
            }
        }
    }

    private void buildAndSendExecute(String text,String name){
        Command  command= new Command();
        command.setSender(name);
        command.setCommand(text);
        sendMes((T) command);
    }

    private void buildAndSendMes(String text, String name){
        Mes message = new Mes(text,name);
        sendMes((T) message);
    }

    private void sendMes(T text){
        try ( Socket socket = new Socket()){
            socket.connect(socketAddress);
            try (OutputStream out = socket.getOutputStream()){
                ObjectOutputStream objOut = new ObjectOutputStream(out);
                objOut.writeObject(text);
                objOut.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static SocketAddress parseAddress (String address) {
        String[] strings = address.split(":");
        return new InetSocketAddress(
                strings[0].trim(),
                Integer.parseInt(strings[1].trim())
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client(parseAddress(args[0]),scanner);
        client.start();
    }
}
