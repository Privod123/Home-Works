package lessons6.zadacha2;

public class XmlHandler implements Handler {
    @Override
    public void read() {
        System.out.println("Прочел файл .xml");
    }

    @Override
    public void write() {
        System.out.println("Записал в файл .xml");
    }
}
