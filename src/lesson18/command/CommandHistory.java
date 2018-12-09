package lesson18.command;

import java.util.*;

/**
 * Created by Hello on 05.12.2018.
 */
public class CommandHistory {
    private List<Command> historyCommand = new ArrayList<>();

    public void add(Command command){
        historyCommand.add(command);
    }

    public void listCommandHistory(){
        System.out.println("/--------------------------/");
        System.out.println("Список команд введеных пользователем:");
        for (int i = 0; i < historyCommand.size(); i++) {
            System.out.println(historyCommand.get(i).name());
        }
        System.out.println("/--------------------------/");
    }


    public boolean isEmpety(){
        return historyCommand.isEmpty();
    }
}
