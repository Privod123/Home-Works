package lesson16.zadacha1;

import lesson9.Mylist.List;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Hello on 01.12.2018.
 */
public class DeleteWord {

    public String readFile(String nameFile){
        String readWithFile = null; // информацию что прочитали из файла
        System.out.println("----------------------------------------");
            System.out.println("Началась процедура чтения файла.");
            File inputFile = new File("src\\lesson16\\TxtFileLesson16\\" + nameFile);
            try (InputStream in = new FileInputStream(inputFile);
                     BufferedInputStream bis = new BufferedInputStream(in);
                     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                            int l;
                            while ((l = bis.read()) != -1) {
                            byteArrayOutputStream.write(l);
                        }
                            readWithFile = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));

            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
            }
        System.out.println("Закончилась процедура чтения файла.");
        return readWithFile;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void write(String outputNameFile, byte[] massivBytes, String outputNameDir){
        System.out.println("----------------------------------------");
            System.out.println("Началась процедура записи в файл.");
            File outputDir = new File("src\\lesson16\\TxtFileLesson16\\" + outputNameDir);
            boolean newDir = outputDir.mkdir();
            if (newDir) System.out.println("Директория была создана");
            else System.out.println("Директория уже существует");
            File outputFile = new File("src\\lesson16\\TxtFileLesson16\\" + outputNameDir + "\\" + outputNameFile);
            try {
                try (OutputStream out = new FileOutputStream(outputFile,false);
                     BufferedOutputStream bout = new BufferedOutputStream(out)){
                     bout.write(massivBytes,0,massivBytes.length);
                }
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
            }
            System.out.println("Окончена процедура записи в файл.");
    }
    //------------------------------------------------------------------------------------------------------------------
    public void deleteWordFromFile(String inputNameFile,int startLimit, int finishLimit,String outputNameDir, String outputNameFile){
        String text = readFile(inputNameFile);
        String[] textFile = text.split(" ");
        ArrayList<String> listNewTextFile = new ArrayList<>(); // содержаться слова которые больше или меньше указанного диапазона
        for (String word: textFile) {
            if (!(word.length() >= startLimit && word.length() <= finishLimit) ){
                listNewTextFile.add(word);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listNewTextFile.size(); i++) {
            if (i == listNewTextFile.size() - 1){
                sb.append(listNewTextFile.get(i));
            }else {
                sb.append(listNewTextFile.get(i) + " ");
            }
        }
        String newText = sb.toString();
        write(outputNameFile, newText.getBytes(),outputNameDir);
    }
}
