/* Question 2 - Although I never swear, I feel bad for those who will now have all of their swear words censored.
 * So many students will be unable to fully express their feelings. To help them out we should encrypt their messages.
We will use a simple system where cut each line in half and build a new line by interleaving the letter from each half.
If you have an odd number of letters just tack the last one on the end. Save as StringEx2.java*/
import java.util.*;

class StringEx2{
    public static void main(String []args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a message: ");
        String msg = keyboard.nextLine();

        String firstHalf = msg.substring(0, msg.length()/2);
        String secondHalf = msg.substring(msg.length()/2);

        for(int i = 0; i < firstHalf.length(); i++){
            System.out.print("" + firstHalf.charAt(i) + secondHalf.charAt(i));
        }

        if(msg.length() % 2 == 1){
            System.out.print(secondHalf.charAt(secondHalf.length() - 1));
        }
    }
}


