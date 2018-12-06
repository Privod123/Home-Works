package lesson16;

import java.io.*;

/**
 * Created by Hello on 26.11.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        File  file = new File("start.bin");
//
//        LaunchStart start;
//
//        // метод exist проверяет есть ли такой файл
//        if (!file.exists()){
//            start = new LaunchStart();
//        }else {
//            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))){
//                start = (LaunchStart) objIn.readObject();
//            }
//        }
//        if (start.isFirstLaunch()){
//            System.out.println("Первый запуск");
//        } else {
//            System.out.println(start);
//        }
//
//        start.update();
//
//        // сохранение
//        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))){
//            objOut.writeObject(start);
//        }

//        File  file = new File("start2.bin");
//
//        ListUser start;
//
//        // метод exist проверяет есть ли такой файл
//        if (!file.exists()){
////            start = new LaunchStartExternalizable();
//            start = new ListUser("nom");
//        }else {
//            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))){
//                start = (ListUser) objIn.readObject();
//                System.out.println( start);
//            }
//        }
////        if (start.isFirstLaunch()){
////            System.out.println("Первый запуск");
////        } else {
////            System.out.println(start);
////        }
////
////        start.update();
//
//        // сохранение
//        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))){
//            objOut.writeObject(start);
//        }
//        System.out.println("--------------------");
//        System.out.println( start);
    }
}
