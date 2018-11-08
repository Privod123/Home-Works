package lesson7.zadacha2;

import java.util.*;

public class Pupil {
    private int id;
    private ExamResult examResult[];
    int numberLesson;

    {
        System.out.println("Введите id студента : " );
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        //---------------------------------------
        System.out.println("Введите колличество сдаваемых предметов студентом " + id + " : " );
        try {
            numberLesson = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Kолличество сдаваемых предметов студентом может быть только цифра");
        }
        examResult = new ExamResult[numberLesson];
        //---------------------------------------
        String ex[] = new String[numberLesson];
        System.out.println("Введите предметы сдаваемые студентом " + id + " : " );
        int i = 0;
        while (i < numberLesson){
            scanner = new Scanner(System.in);
            String subject = scanner.nextLine();
            if (subject.equals("")){
                System.out.println("не ввели предмет");
                continue;
            }
            subject = subject.replaceAll("\\d"," ");
            if (subject.equals(" ")){
                System.out.println("Было введено число,сдаваемый предмет это слово");
                continue;
            }
            ex[i] = subject;
            i++;
        }
        //---------------------------------------
        int marks[] = new int[numberLesson];
        System.out.println("Введите оценки полученные студентом " + id + " : " );
        int j = 0;
        while (j < numberLesson) {
            try {
                System.out.print(ex[j] + " : ");
                scanner = new Scanner(System.in);
                int mark = scanner.nextInt();
                marks[j] = mark;
                j++;
            } catch (InputMismatchException e){
                System.out.println("Оценка может быть только цифра");
                continue;
            }
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
