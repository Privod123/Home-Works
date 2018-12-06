package lesson16.zadacha3;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hello on 02.12.2018.
 */
public class CopyFiles {
    public static void main(String[] args) {
        File file1 = new File(args[0]);
        File[] list = file1.listFiles();
        List<File> list1 = Arrays.asList(list);
        print(list1);
        System.out.println("---------------------");
        String wayWhereCopyFile = args[1] + "\\";
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).isFile()){
                byte[] insideFile = readFile(list1.get(i));
                File file2 = new File(wayWhereCopyFile + list1.get(i).getName());
                copyFile(file2,insideFile);
            }
        }

    }

    public static void print(List<File> list){
        for (File f: list) {
            System.out.println(f);
        }
    }

    public static byte[] readFile(File file){
        byte[] insideFile = null;
        try (InputStream in = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(in);
             ByteArrayOutputStream storange = new ByteArrayOutputStream()) {
            int l;
            while ((l = bis.read())!= -1){
                storange.write(l);
            }
            insideFile = storange.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return insideFile;
    }

    public static void copyFile(File file,byte[] copyInfo){
        try (OutputStream out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out)){
            bos.write(copyInfo,0,copyInfo.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
