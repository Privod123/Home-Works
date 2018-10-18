package Lessons_1;

/*
Задайте высоту,длину и ширину прямоугольного паралепипеда.
Найти:
1. его площадь;
2. узнайте что больше: ширина или высота и выведите информацию об это в консоль
 */

public class Zadacha_1 {
    public static void main(String[] args) {
        int height = 2;
        int lenth = 5;
        int width = 3;
        System.out.println("Площадь паралелепипеда = " + 2*(height*lenth + lenth*width + width*height));
        System.out.println((width > height) ? "ширина больше высоты" : "высота больше ширины");
    }
}
