package lesson21.zadacha2.a;

/**
 * Created by Hello on 15.12.2018.
 */
public class TestCarteen {
    public static void main(String[] args) {
        Carteen carteen = new Carteen();
        Client client = new Client(carteen);
        Waiter waiter = new Waiter(carteen);
        Cooker cooker = new Cooker(carteen);
        new Thread(client).start();
        new Thread(waiter).start();
        new Thread(cooker).start();
    }
}
