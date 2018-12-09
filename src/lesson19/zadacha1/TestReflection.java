package lesson19.zadacha1;



/**
 * Cделал только частично. С аннтотацией задание не работает.
 */
public class TestReflection {
    public static void main(String[] args) {
        Toy car = new ToyCar();

        System.out.println(ReflectoinToString.tooString(car));
    }
}
