package lesson22.zadacha3;

/**
 * Created by Hello on 29.12.2018.
 */
public class TestPort {
    public static void main(String[] args) {
        Port port = new Port();
        Prichal prichal1 = new Prichal(false);
        port.showStatusPort();
        System.out.println("/---------------------/");
        Ship ship1 = new Ship("West");
        port.shipTakePrichal(prichal1,ship1);
        port.showStatusPort();
//        Ship ship1 = new Ship("West");
        System.out.println("/---------------------/");
        Ship ship2 = new Ship("Nord");
        port.shipTakePrichal(prichal1,ship2);
        port.showStatusPort();
        System.out.println("/---------------------/");
        port.shipPutPrichal(prichal1,ship1);
        port.showStatusPort();
        System.out.println("/---------------------/");
        port.shipTakePrichal(prichal1,ship2);
        port.showStatusPort();


    }
}
