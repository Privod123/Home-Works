package lessons7.zadacha1;

import java.util.Arrays;
import java.util.Scanner;

public class Pupil {
    private int id;
//    private ExamResult examResult[] = new ExamResult[2];
    private ExamResult examResult[];

    public Pupil(int id) {
        this.id = id;
        //---------------------------------------
        // Вариант 1 инициализации предметов и оценок
//        String ex[] = {"Математика","Биология"};
//        int marks[] = {2,5};
        //---------------------------------------
        // Вариант 2 инициализации предметов и оценок
        System.out.println("Введите колличество сдаваемых предметов студентом " + id + " : " );
        Scanner scanner = new Scanner(System.in);
        int lenghtMassiv = scanner.nextInt();
        examResult = new ExamResult[lenghtMassiv];
        //---------------------------------------
        String ex[] = new String[lenghtMassiv];
        System.out.println("Введите предметы сдаваемые студентом " + id + " : " );
        int i = 0;
        while (i < lenghtMassiv){
            scanner = new Scanner(System.in);
            String subject = scanner.nextLine();
            ex[i] = subject;
            i++;
        }
        //---------------------------------------
        int marks[] = new int[lenghtMassiv];
        System.out.println("Введите оценки полученные студентом " + id + " : " );
        int j = 0;
        while (j < lenghtMassiv){
            scanner = new Scanner(System.in);
            int mark = scanner.nextInt();
            marks[j] = mark;
            j++;
        }
        scanner.close();
        //---------------------------------------
        for (int k = 0; k < examResult.length; k++) {
            examResult[k] = new ExamResult(ex[k],marks[k]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Студент : " + id + "\n");
        for (int i = 0; i < examResult.length; i++) {
            result.append(examResult[i].ex + " " + examResult[i].statusLesson + "\n");
        }
        return result.toString();
    }

    class ExamResult {
        String ex;
        int marks;
        String statusLesson;

        public ExamResult(String ex, int marks) {
            this.ex = ex;
            this.marks = marks;
            this.statusLesson = setExams(marks);
        }

        public String setExams(int marks){
            if (marks <= 2) {
                return "не сдал";
            } else {
                return  "сдал";
            }
        }
    }


}
