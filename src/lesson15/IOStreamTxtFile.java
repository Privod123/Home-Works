package lesson15;

import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;

/**
 * Created by Hello on 24.11.2018.
 */
public class IOStreamTxtFile{

    private String inputNameFile;
    private String outputNameFile;
    private  boolean inputFileIsNorma; // проверяем что указанный файл расширения TXT
    private  boolean outputFileIsNorma;  // проверяем что указанный файл расширения TXT

    public IOStreamTxtFile(String inputNameFile, String outputNameFile)  {
        if (inputNameFile.toLowerCase().endsWith(".txt") ){
            this.inputNameFile = inputNameFile;
            inputFileIsNorma = true;
        }else {
            System.out.println("Введенный файл из которого читаем не является текстовым(не имеет расширение TXT)");
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputNameFile.toLowerCase().endsWith(".txt")){
            this.outputNameFile = outputNameFile;
            outputFileIsNorma = true;
        }else {
            System.out.println("Введенный файл в который читаем не является текстовым(не имеет расширение TXT)");
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(Charset charset) {
        if (inputFileIsNorma == true && outputFileIsNorma == true){
            System.out.println("Началась процедура копирования файла.");
            File inputFile = new File("src\\lesson15\\zadacha1\\" + inputNameFile);
            String text = null; // информацию что прочитали из файла
            boolean readIsNorma = false; // проверяем что чтение файла прошло успешно
            //---------------------------------------------------
            try {
                try (InputStream in = new FileInputStream(inputFile);
                     BufferedInputStream bis = new BufferedInputStream(in);
                     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
                ){
                    int l;
                    while ((l = bis.read()) != -1){
                        byteArrayOutputStream.write(l);
                    }
                    text = new String(byteArrayOutputStream.toByteArray(),charset);
                    readIsNorma = true;
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
            }
            //---------------------------------------------------
            if (readIsNorma == true){
                File outputFile = new File("src\\lesson15\\zadacha1\\" + outputNameFile);
                try {
                    try (OutputStream out = new FileOutputStream(outputFile,false);
                         BufferedOutputStream bout = new BufferedOutputStream(out)){
                        byte[] bytes = text.getBytes();
                        System.out.println("Колличество скопированных байт : " + bytes.length);
                        bout.write(bytes,0,bytes.length);
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл");
                }
                System.out.println("Закончилась процедура копирования файла.");
            }
        }
    }
}
