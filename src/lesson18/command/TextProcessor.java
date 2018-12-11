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
        System.out.println("Введи текст или команду");
        label: while (true){
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
                        history.addCommand(process);
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
                        history.addCommand(repeat);
                        sb.delete(0,sb.length()); // стираем данные что ввел пользователь,команда выполнилась
                    }else {
                        System.out.println("ОШИБКА записи в хранилище данных");
                    }
                    break;
                case "cancel":
                    CancelCommand cancel = new CancelCommand(this);
                    if (history.isEmpety() ){
                        System.out.println("Хранилище данных пустое");
                        history.addCommand(cancel);
                    } else if (!history.isEmpety() &&
                            history.getHistoryCommand().get(history.getHistoryCommand().size() - 1).name().equals("CancelCommand")){
                        System.out.println("Несколько раз подрят команду \"cancel\" вводить нельзя");
                    } else if (!history.isEmpety() &&
                            history.getHistoryCommand().get(history.getHistoryCommand().size() - 1).name().equals("RepeatCommand")){
                        int i = 0;
                        while (i < 2) {
                            if (cancel.execute(sb,storage)){
                               if (i == 1)  System.out.println("Последнее сообщение удалили");
                            } else {
                                System.out.println("ОШИБКА выполнения программы");
                            }
                            i++;
                        }
                        history.removeCommand(); // удаляем предыдущую команду из логов команд
                        history.addCommand(cancel);
                    } else {
                        if (cancel.execute(sb,storage)){
                            System.out.println("Последнее сообщение удалили");
                        } else {
                            System.out.println("ОШИБКА выполнения программы");
                        }
                        history.removeCommand();
                        history.addCommand(cancel);
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
        listCommand.put("cancel","команда удаляет записанный ранее текст из хранилища и последнюю команду из логов команд");
        int i = 1;
        for (Map.Entry map : listCommand.entrySet()){
            System.out.println( i++ + " : " + map.getKey() + " - " + map.getValue());
        }
    }

}

