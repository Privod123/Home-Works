package lesson17.factory;

/**
 * Created by Hello on 03.12.2018.
 */
abstract class Hendler{
    abstract void read();
    abstract void write();
}

class TxtYandler extends Hendler{
    @Override
    void read() {
        System.out.println("Read from txt");
    }

    @Override
    void write() {
        System.out.println("Wrote in txt");
    }
}

class XmlYandler extends Hendler{
    @Override
    void read() {
        System.out.println("Read from Xml");
    }

    @Override
    void write() {
        System.out.println("Wrote in Xml");
    }
}

public class Factory {

}
