package lesson1;

/*
В три переменные a,b и c записаны три вещественных числа.
Создать программу,которая будет находить и выводить на экран вещественные корни квадратного уравнения ax2+bx+c=0,
либо сообщать корней нет.
 */

public class Zadacha_6 {
    public static void main(String[] args) {
        double a = 1;
        double b = -8;
        double c = 2;
        double diskriminant = Math.pow(b, 2) - 4 * a * c;
        if (diskriminant < 0) {
            System.out.println("корней нет");
        }else if (diskriminant == 0){
            System.out.println("Уравнение имеет один корень : " + -b/2*a);
        }else {
            System.out.println("Корень # 1 уравнения  : " +(-b + Math.sqrt(diskriminant))/2*a);
            System.out.println("Корень # 2 уравнения  : " +(-b - Math.sqrt(diskriminant))/2*a);
        }
    }
}
