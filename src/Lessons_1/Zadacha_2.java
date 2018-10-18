package Lessons_1;

/*
На садовом участке площадью 10 соток,разбили грядки 15 на 25 метров.
Сколько м2 осталось не занято?
 */


public class Zadacha_2 {
    public static void main(String[] args) {
        int squareGarden = 10;
        int lenthGardenBed = 25;
        int widthGadenBad = 15;
        // вычислим площать участка в м2.
        int squareGardenMetri = squareGarden * 100;
        // вычислим площадь одной грядки
        int squareGardenBad = lenthGardenBed * widthGadenBad;
        // найдем сколько целых грядок поместиться на участке
        int amountGardenBad = squareGardenMetri/squareGardenBad;
        // найдем сколько осталось свободного места
        int freeLandGarden = squareGardenMetri - amountGardenBad * squareGardenBad;
        System.out.println("Осталось не занято : " + freeLandGarden + " м2");
    }
}
