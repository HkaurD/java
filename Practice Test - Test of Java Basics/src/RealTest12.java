import java.util.*;

public class RealTest12 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String senten = keyboard.nextLine();

        String[] words = senten.split(" ");
        String firstHalf = "";
        String secHalf = "";
        int half = words.length / 2 + words.length % 2;

        for (int i = 0; i < half; i++) {
            firstHalf += words[i] + " ";
        }
        for (int i = half; i < words.length; i++) {
            secHalf += words[i] + " ";
        }
        System.out.println(("" + secHalf.charAt(0)).toUpperCase() + secHalf.substring(1, secHalf.length() - 1) + ", " + firstHalf);
    }
}

