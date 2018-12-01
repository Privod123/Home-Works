package lesson16.zadacha1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Hello on 01.12.2018.
 */
public class ReadConsole {

    int startLimit;
    int finishLimit;
    String inputNameFile;
    String outputNameFile;
    String outputNameDir;

    public void readConsol(){
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите колличество символов содержащихся в слове , например 4-6 :");
                String diapazon = in.nextLine();
                String[] limitDiapazon = diapazon.split("-");
                try {
                    startLimit = Integer.parseInt(limitDiapazon[0].trim());
                    finishLimit = Integer.parseInt(limitDiapazon[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Диапазон символов был введен не правильно.");
                    continue;
                }
                System.out.println("Введите имя файла который читаем, например z.txt");
                inputNameFile = in.nextLine();
                if (!checkFileTxt(inputNameFile)) continue;
                System.out.println("Введите диркторию куда записывается файл, например MyFile");
                outputNameDir = in.nextLine();
                System.out.println("Введите имя файла в который записываем, например y.txt");
                outputNameFile = in.nextLine();
                break;
            }
        }
    }
    private boolean checkFileTxt(String file){
        if (file.toLowerCase().endsWith(".txt") ){
           if (checkFile(file)){
               return true;
           }else {
               return false;
           }
        }else {
            System.out.println("Введенный файл из которого читаем не является текстовым(не имеет расширение TXT)");
            return false;
        }
    }
    private boolean checkFile(String file){
         File file1 = new File("src\\lesson16\\TxtFileLesson16\\" + file);
         if (file1.exists()) return true;
         else {
             System.out.println("Данного файла нет по указанному пути.");
             return false;
         }
     }

}
