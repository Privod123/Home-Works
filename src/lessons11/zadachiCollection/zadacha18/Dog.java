package lessons11.zadachiCollection.zadacha18;

/**
 * Created by Hello on 15.11.2018.
 */
public class Dog {
    private int number;

    public Dog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Dog " +
                "№ " + number;
    }
}
