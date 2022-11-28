// Question 1 - Write a program that gets numbers from the user until they enter zero then tells the user the average
// of all the numbers, the largest number entered, the smallest number entered. Save as BasicEx1.java.
import java.util.Scanner;

class BasicEx1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int num, total = 0, count = 0;
        int big = Integer.MIN_VALUE; // smallest integer possible
        int small = Integer.MAX_VALUE; // largest integer possible

        while (true) {
            System.out.println("Enter a num: ");
            num = keyboard.nextInt();
            if (num == 0){
                break;
            }

            // method 1 - if comparison
            if (num > big) {
                big = num;
            }
            // method 2 - built-in Java max function
            big = Math.max(num, big);
            // method 3 - terinary operator
            big = num > big ? num : big;
            //  <condition> ? <true value> : <false value>
            // the expression takes on either the true value or the false value, based on the condition

            small = Math.min(small, num);

            total += num;
            count ++;
        }
        System.out.println("The average is: " + (double)total / count);
        System.out.println("The smallest is: " + small);
        System.out.println("The largest is: " + big);
    }
}



