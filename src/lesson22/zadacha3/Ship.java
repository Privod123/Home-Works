package lesson22.zadacha3;

/**
 * Created by Hello on 29.12.2018.
 */
public class Ship {

    private String nameShip;

    public Ship(String nameShip) {
        this.nameShip = nameShip;
    }

    public String getNameShip() {
        return nameShip;
    }

    @Override
    public String toString() {
        return "Ship {" +
                " nameShip= " + nameShip +
                '}';
    }
}
