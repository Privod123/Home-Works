package lessons6.zadacha2;

public class Main {
    public static void main(String[] args) {

        String nameFile = null;
        TxtHandler txtHandler;
        XmlHandler xmlHandler;

        if (nameFile.endsWith(".txt")){
            txtHandler = new TxtHandler();
        }
        if (nameFile.endsWith(".hml")){
            xmlHandler = new XmlHandler();
        }

    }
}
