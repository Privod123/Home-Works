package lessons11.zadachiCollection.zadacha18;

/**
 * Created by Hello on 15.11.2018.
 */
public class Cat{
    private int number;

    public Cat(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cat " +
                "№ " + number;
    }
}
