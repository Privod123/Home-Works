package lesson19.zadacha1;

/**
 * Created by Hello on 09.12.2018.
 */
public class ToyCar extends Toy {

    private String owner = "Tom";
    public String name = "Ferrary";
    public int price = 1000;

    @Override
    public String toString() {
        return "ToyCar{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
