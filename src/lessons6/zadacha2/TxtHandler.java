package lessons6.zadacha2;

public class TxtHandler implements Handler {
    @Override
    public void read() {
        System.out.println("Прочел файл .txt");
    }

    @Override
    public void write() {
        System.out.println("Записал в файл .txt");
    }
}
