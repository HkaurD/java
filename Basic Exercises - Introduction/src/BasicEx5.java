/* Question 4 - Write a program that computes the factorial of a given number. Factorials are used in statistics to
determine the probability of events.  The  �!� is used as the factorial symbol. Some Examples:5! = 5 * 4 * 3 * 2 * 1= 120
6!= 6 * 5 * 4 * 3 * 2 * 1= 720. Write a program that asks the user for a number and computes the factorial of that
number. Save as BasicEx5.java. */
import java.util.*;

class BasicEx5 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = keyboard.nextInt();
        int product = 1;

        for (int i = num; i > 1; i--){
            product *= i;
        }

        System.out.printf("%d! = %d", num, product);
    }
}
