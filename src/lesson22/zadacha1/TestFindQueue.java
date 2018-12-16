package lesson22.zadacha1;



/**
 * Created by Hello on 16.12.2018.
 */
public class TestFindQueue {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FindTopWord find = new FindTopWord();
        find.start();
        long finish = System.currentTimeMillis();
        System.out.println("Время работы : " + ((finish - start)/1000) + " сек" );
    }
}
