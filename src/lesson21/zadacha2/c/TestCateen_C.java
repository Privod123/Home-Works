package lesson21.zadacha2.c;

/**
 * Created by Hello on 16.12.2018.
 */
public class TestCateen_C {
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
