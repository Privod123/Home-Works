package lesson22.zadacha3;

/**
 * Created by Hello on 29.12.2018.
 */
public class Prichal {

    private static int count = 0;
    private int id;
    private boolean status;

    public Prichal(boolean status) {
        count++;
        this.id = count;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Prichal : " +
                "  № = " + id +
                ", status = " + (status ? "Причал занят": "Причал свободен");
    }
}
