package chat;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Hello on 03.12.2018.
 */
public class Client {

    private IOConnection connection;

    public void start(){
        ConsoleHelper.writeString("Enter your name :");
        String name = ConsoleHelper.readString();
        setConnection("",name);
        while (true){
            ConsoleHelper.writeString("Enter your massege");
            String mes = ConsoleHelper.readString();
            setConnection(mes,name);
//            try ( Socket socket = new Socket("localhost",8080)){
//                connection = new IOConnection(socket);
//                connection.send(new Message(mes,name));
//                Message answer = connection.receive();
//               ConsoleHelper.writeString(answer.getSender() + answer.getText());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    private void setConnection(String mes,String name){
        try ( Socket socket = new Socket("localhost",8080)){
            connection = new IOConnection(socket);
            connection.send(new Message(mes,name));
            Message answer = connection.receive();
            ConsoleHelper.writeString(answer.getSender() + answer.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
