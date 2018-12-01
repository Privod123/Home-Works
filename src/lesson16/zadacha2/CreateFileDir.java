package lesson16.zadacha2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * Created by Hello on 01.12.2018.
 */
public class CreateFileDir {
    public static void main(String[] args) {
        File file = new File(args[0]);
        System.out.println("Каталог который смотрим - " + file.getAbsolutePath());
        File[] listDir = file.listFiles();
        for (File f: listDir) {
            if (f.isFile()){
                StringBuilder sb = new StringBuilder();
                sb.append(f.getAbsolutePath());
                sb.append(" |---------| ");
                sb.append(f.getName());
                sb.append(" |---------| ");
                sb.append(findTimeCreatFile(f));
                sb.append("\n");
                write(sb.toString().getBytes());
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    // метод ищет время создания файла
    public static String findTimeCreatFile(File f){
        Path path = f.toPath();
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String timeCreatedFull = new String(attr.creationTime().toString());
        String[] timeCreated = timeCreatedFull.split("T");
        return timeCreated[0];
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void write( byte[] massivBytes){
        System.out.println("----------------------------------------");
        System.out.println("Началась процедура записи в файл.");
        File outputFile = new File("src\\lesson16\\TxtFileLesson16\\z2_l16_out.txt");
        try {
            try (OutputStream out = new FileOutputStream(outputFile,true);
                 BufferedOutputStream bout = new BufferedOutputStream(out)){
                 bout.write(massivBytes,0,massivBytes.length);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        System.out.println("Окончена процедура записи в файл.");
    }

}
