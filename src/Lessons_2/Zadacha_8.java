package Lessons_2;

/*
Есть три вершины X,Y,Z
Их координаты (х1,х2),(y1,y2),(z1,z2)заданы как целые числа.
нужно определить - является ли треугольник с заданными координатами прямоугольным.
 */

public class Zadacha_8 {
    public static void main(String[] args) {
        int x1 = -1;
        int x2 = -1;
        int y1 = 0;
        int y2 = 1;
        int z1 = 1;
        int z2 = 0;

        double lengthXY2 = Math.pow((y1 - x1),2) + Math.pow((y2 - x2),2);
        double lengthYZ2 = Math.pow((z1 - y1),2) + Math.pow((z2 - y2),2);
        double lengthZX2 = Math.pow((x1 - z1),2) + Math.pow((x2 - z2),2);

        if ((lengthXY2 == lengthYZ2 +lengthZX2) ||
                (lengthYZ2 == lengthZX2 +lengthXY2) ||
                    (lengthZX2 == lengthXY2 +lengthYZ2)){
            System.out.println("Треугольник прямоугольный");
        }else {
            System.out.println("Треугольник не прямоугольный");
        }

    }
}
