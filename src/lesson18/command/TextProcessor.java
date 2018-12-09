package lesson18.command;

import java.util.*;

/**
 * Created by Hello on 05.12.2018.
 */
public class TextProcessor {

    private Storage storage = new Storage(); //  хранилище данных
    private CommandHistory history = new CommandHistory();  // хранилище команд
    private StringBuilder sb = new StringBuilder(); // формируется строка сообщений от пользователя



    public TextProcessor() {
        System.out.println("Valar morghulis ,Пользователь.");
        System.out.println("Что бы осмотреть полный список команд, введи help" + "\n");
    }

    public void start(){
        Scanner in;
//        sb.append("-------------------------").append("\n");
        System.out.println("Введи текст или команду");
        label: while (true){
//            System.out.println("Введи текст или команду");
            in = new Scanner(System.in);
            String message = in.nextLine();
            switch (message){
                case "help":
                    listCommand();
                    break ;
                case "storage":
                    if (storage.isEmpety()){
                        System.out.println("Пользователь не записал ни одного сообщения в хранилище");
                    }else {
                        storage.printStorage();
                    }
                    break ;
                case "log":
                    if (history.isEmpety()){
                        System.out.println("Пользователь не вводил команд.");
                    }else {
                        history.listCommandHistory();
                    }
                    break ;
                case "process":
                    Command process = new ProcessCommand(this);
                   if (process.execute(sb,storage)){
                        history.add(process);
                        sb.delete(0,sb.length()); // стираем данные что ввел пользователь,команда выполнилась
                        System.out.println("Запись в хранилище данных прошла успешно");
                   }else {
                        System.out.println("ОШИБКА записи в хранилище данных");
                   }
                    break;
                case "repeat":
                    Command repeat = new RepeatCommand(this);
                    if (repeat.execute(sb,storage)){
                        if (repeat.execute(sb,storage)){
                            System.out.println("Запись в хранилище данных прошла успешно 2 раза");
                        }else {
                            System.out.println("ОШИБКА записи в хранилище данных");
                        }
                        history.add(repeat);
                        sb.delete(0,sb.length()); // стираем данные что ввел пользователь,команда выполнилась
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
        listCommand.put("repeat","команда добавляет записанный текст в хранилище 2 раза");
        int i = 1;
        for (Map.Entry map : listCommand.entrySet()){
            System.out.println( i++ + " : " + map.getKey() + " - " + map.getValue());
        }
    }

}

