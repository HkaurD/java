// Question 2 - Write a program to find the sum of a number of terms of an infinite series 1 + x + x**2 + x**3
// + x**4 + ...where the user enters the number of terms to be used and what x is.  Save as BasicEx2.java.
import java.util.*;

class BasicEx2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the number of terms: ");
        int numOfTerms = keyboard.nextInt();

        System.out.println("Enter the value of the base: ");
        double base = keyboard.nextDouble();

        double sum = (Math.pow(base, numOfTerms) - 1)/(base - 1);
        System.out.println("The sum is: " + sum);
    }
}


/*import java.util.*;

class BasicEx2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter the number of terms: ");
    int numOfTerms = keyboard.nextInt();

    System.out.println("Enter the value of the base: ");
    double base = keyboard.nextDouble();
    double sum = 0;

    for(int i = 0; i < numOfTerms; i++){
      sum += Math.pow(base, i);
    }
    System.out.println("The sum is: " + sum);
  }
}*/

