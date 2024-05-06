import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.println("First enter all the subjects one by on and press 1 when done");
        while (true){
            System.out.print("Enter name of the subject: ");
            String subject = input.next();
            if (Objects.equals(subject, "1")){
                break;
            }
            else
                subjects.add(subject);
        }
        for (String subject : subjects) {
            System.out.print("Enter marks for " + subject + " :");
            int mark = input.nextInt();
            marks.add(mark);
        }
        System.out.println("*********Subjects and grades**********");
        for (int i = 0; i < marks.size(); i++) {

            System.out.println(subjects.get(i) + " "+ getGrade(marks.get(i)));

        }
        int totalmarks=0;
        for (int mark: marks){
            totalmarks +=mark;
        }
        int average = totalmarks/marks.size();
        System.out.println("Total marks: "+ totalmarks+ " Average percentage: "+ average+ " grade: "+ getGrade(average));

    }
    private static String getGrade(float mark){
//        String grade = null;
        if (mark >70){
            return "A";
        }
        if (mark >60){
            return "B";
        }
        if (mark >50){
            return "C";
        }
        if (mark >40){
            return "D";
        }
        else
            return "F";
    }
}
