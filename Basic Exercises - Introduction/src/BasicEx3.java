// Question 3 - Ask the user for an integer between 1 and 50 and output all of the factors of that integer.
// Save as BasicEx3.java.
import java.util.*;

class BasicEx3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter an integer between 1 and 50: ");
        int num = keyboard.nextInt();
        System.out.println("The factors of " + num + " are: ");
        for (int i = 1; i < num + 1; i ++){
            if (num % i == 0){
                System.out.print(i + " ");
            }
        }
    }
}

