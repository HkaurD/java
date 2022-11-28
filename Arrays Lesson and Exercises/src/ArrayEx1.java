/* Question 4 - Create a program that takes the users 8 marks from last year, displays them in order and tells them how
much above or below their average the mark is. Save as ArrayEx1.java */
import java.util.*;

class ArrayEx1{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your marks from last year: ");
        double []marks = new double[8];
        double sum = 0;

        for(int i = 0; i < 8; i++){
            marks[i] = keyboard.nextDouble();
            sum += marks[i];
        }
        Arrays.sort(marks);
        double avg = sum / 8;

        for(double mark : marks){
            System.out.println(mark + "           " + (mark-avg));
        }
    }
}