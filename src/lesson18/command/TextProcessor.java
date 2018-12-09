package lesson18.command;

import java.util.*;

/**
 * Created by Hello on 05.12.2018.
 */
public class TextProcessor {

    private Storage storage = new Storage(); //  хранилище данных
    private CommandHistory history = new CommandHistory();  // хранилище команд
    private StringBuilder sb = new StringBuilder(); // формируется строка сообщений от пользователя
    private static int countMesage = 1; // колличество команд которые выполнились

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
                case "storage":
                    storage.printStorage();
                    break ;
                case "log":
                    history.listCommandHistory();
                    break ;
                case "process":
                    Command process = new ProcessCommand(this);
                   if (process.execute(sb,storage)){
                        history.add(process);
                        sb.delete(0,sb.length()); // стираем данные что ввел пользователь,команда выполнилась
                        sb.append("-------------------------").append("\n").append(countMesage++).append("\n");
                        System.out.println("Запись в хранилище данных прошла успешно");
                   }else {
                        System.out.println("ОШИБКА записи в хранилище данных");
                   }
                    break;
                case "exit":
                    if(new ExitCommand(this).execute(sb,storage)){
                        break label;
                    }else {
                        System.out.println("ОШИБКА выхода из программы");
                    }
                    break;
                default:
                    sb.append(message).append("\n");

            }
        }
        in.close();
    }

    // формируем список команд
    private void listCommand(){
        System.out.println("Список команд доступных пользователю:");
        Map<String,String > listCommand = new HashMap<>();
        listCommand.put("process","команда добавляет записанный текст в хранилище");
        listCommand.put("exit","команда заканчивает работу программы");
        listCommand.put("storage","команда показвает все сообщения записанные в хранилище");
        listCommand.put("log","команда показвает историю всех команд введеных пользователем");
        int i = 1;
        for (Map.Entry map : listCommand.entrySet()){
            System.out.println( i++ + " - " + map.getKey() + " - " + map.getValue());
        }
    }

}

