package lesson21.zadacha1;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hello on 13.12.2018.
 */
public class ReadFile {
    private File nameFile;

    public ReadFile(File nameFile) {
        this.nameFile = nameFile;
    }

    public String readFile(){
        String allFileInOneString = null;
        try (InputStream in = new FileInputStream(nameFile);
                BufferedInputStream bis = new BufferedInputStream(in);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream()){
                        int l;
                        while ((l = bis.read()) > 0){
                            baos.write(l);
                        }
                        allFileInOneString = new String(baos.toByteArray(), Charset.forName("UTF-8"));
                    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allFileInOneString;
    }
}
