package lesson1;

/*
Создать программу, выводящую в консоль наибольшую цифру любого трехзначного натурального числа.
Примеры работы программы:
- В числе 208 наибольшая цифра 8
- В числе 774 наибольшая цифра 7
- В числе 613 наибольшая цифра 6
 */

public class Zadacha_7 {
    public static void main(String[] args) {

        int number = 579;
        int maxVarNumber = 0;
        int ostatokDeleniaSotki = 0;

        // определяем максимальную цифру  в сотых
        maxVarNumber = number / 100;
        // после смотрим (находим) десятичное число,отбрасывая сотые.
        ostatokDeleniaSotki = number % 100;
        // определяем максимальную цифру  в десятых
        maxVarNumber = (ostatokDeleniaSotki / 10 > maxVarNumber) ? ostatokDeleniaSotki / 10 : maxVarNumber ;
        // определяем максимальную цифру  в еденицах
        maxVarNumber = (ostatokDeleniaSotki % 10 > maxVarNumber) ? ostatokDeleniaSotki % 10 : maxVarNumber ;

        System.out.println("В числе " + number +  " наибольшая цифра " + maxVarNumber);
    }
}
