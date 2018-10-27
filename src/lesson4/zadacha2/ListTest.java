package lesson4.zadacha2;
/*
Реализовать однонаправленный список, с методами add() и  remove().
 */
public class ListTest {
    public static void main(String[] args) {

        List list = new List();
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(8);

        System.out.println("Посмотрим весь сформированный список:");
        list.print();


        list.remove(5);

        System.out.println("Посмотрим весь сформированный список:");
        list.print();

    }
}
