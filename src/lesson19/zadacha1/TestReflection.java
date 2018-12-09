package lesson19.zadacha1;


public class TestReflection {
    public static void main(String[] args) {
        Toy car = new ToyCar();

        System.out.println(ReflectoinToString.tooString(car));
    }
}
