package Lessons_2;
/*
Задать количество тарелок и количество моющего средства.
Моющее средство расходуется из расчета 0,5 на одну тарелку.
В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
В конце вывеcти,сколько тарелок осталось,когда моющее средство закончилось или наоборот.
 */

public class Zadacha_9 {
    public static void main(String[] args) {
        int numberPlates = 10;
        double numberFairy = 35;
        while (true){
            numberPlates--;
            numberFairy = numberFairy - 0.5;
            if (numberFairy == 0){
                System.out.println("");
                System.out.println("Моющее средство закончилось");
                System.out.println("Осталось помыть  тарелок - " + numberPlates);
                break;
            }else if (numberPlates == 0){
                System.out.println("");
                System.out.println("Все тарелки помыты");
                System.out.println("Моющего средства осталось - " + numberFairy);
                break;
            }else {
                System.out.println("Помыли тарелку. Моющего средства осталось - " + numberFairy);
            }
        }
    }
}
