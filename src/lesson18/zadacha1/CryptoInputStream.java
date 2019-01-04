package lesson18.zadacha1;

import java.io.*;
/**
 * Created by Hello on 06.12.2018.
 */
public class CryptoInputStream extends FilterInputStream implements Closeable{

    private byte[] password;
    private int number=0;

    public CryptoInputStream(InputStream in, byte[] password) {
        super(in);
        this.password = password;
    }

    @Override
    public int read() throws IOException {
        int l = super.read();
        int res = l^password[number%password.length];
        number++;
        return res;
    }
}
