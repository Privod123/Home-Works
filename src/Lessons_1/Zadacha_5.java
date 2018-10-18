package Lessons_1;

/*
Задать размер ипотечного кредита, процентную ставку, кол-во лет.
Найти переплату по кредиту.Значение переплаты вывести в консоль.
 */

public class Zadacha_5 {
    public static void main(String[] args) {
        int summaIpoteki = 3_000_000;
        double procentIpoteka = 9.8;
        int yearIpoteka = 10;

        System.out.println("Переплата по ипотеке составляет : " + summaIpoteki/100*procentIpoteka*yearIpoteka + " руб.");

    }
}
