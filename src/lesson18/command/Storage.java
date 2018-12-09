package lesson18.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hello on 09.12.2018.
 */
public class Storage {

    private List<String> storageMessage = new ArrayList<>();

    public void add(String text){
        storageMessage.add(text);
    }

    public void printStorage(){
        System.out.println("/--------------------------/");
        System.out.println("История сообщений введеных пользователем:");
        for (int i = 0; i < storageMessage.size(); i++) {
            System.out.println(storageMessage.get(i));
        }
        System.out.println("/--------------------------/");
    }

    public boolean isEmpety(){
        return storageMessage.isEmpty();
    }

}
