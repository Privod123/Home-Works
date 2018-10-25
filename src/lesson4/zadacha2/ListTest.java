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
        System.out.println(list.getHeadIndex().toString());
        System.out.println("--------------------");
        list.setCurrentIndex(list.getHeadIndex());
        while (list.getCurrentIndex() != null){
            System.out.println("Ячейка " + list.getCurrentIndex() + " содержит значение - " + list.getCurrentIndex().getVar());
            list.setCurrentIndex(list.getCurrentIndex().getNextAdres());
        }

        list.remove(6);

        System.out.println("--------------------");
        System.out.println("Посмотрим весь сформированный список:");
        System.out.println(list.getHeadIndex().toString());

    }
}
