package lesson18.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Hello on 05.12.2018.
 */
public class TextProcessor {

    private Storage storage = new Storage();
    private StringBuilder sb = new StringBuilder();
    private static int countMesage = 1;

    static {
        System.out.println("Здравствуй,Пользователь.");
        System.out.println("Что бы осмотреть полный список команд, введи help");
    }

    public void start(){
        Scanner in;
        sb.append("-------------------------").append("\n").append(countMesage++).append("\n");
        label: while (true){
            System.out.println("Введи текст или команду");
            in = new Scanner(System.in);
            String message = in.nextLine();
            switch (message){
                case "help":
                    listCommand();
                    break ;
                case "showStorage":
                    storage.printStorage();
                    break ;
                case "process":
                   if (new ProcessCommand(this).execute(sb,storage,countMesage)){
                       countMesage++;
                       System.out.println("Запись в хранилище данных прошла успешно");
                   }else {
                       System.out.println("ОШИБКА записи в хранилище данных");
                   }
                    break;
                case "exit":
                    if(new ExitCommand(this).execute(sb,storage,countMesage)){
                        break label;
                    }else {
                        System.out.println("ОШИБКА выхода из программы");
                    }
                    break;
                default:
                    sb.append(message).append("\n");

            }
        }
    }

    private void listCommand(){
        Map<String,String > listCommand = new HashMap<>();
        listCommand.put("process","команда добавляет записанный текст в хранилище");
        listCommand.put("exit","команда заканчивает работу программы");
        int i = 1;
        for (Map.Entry map : listCommand.entrySet()){
            System.out.println( i++ + " - " + map.getKey() + " - " + map.getValue());
        }
    }
}

