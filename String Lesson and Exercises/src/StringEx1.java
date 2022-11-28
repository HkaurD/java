/* Question 1 - Mrs Rankinis very concerned about the use of swear words on the computer. She feels the situation has 
gotten out of control and she wants me to handle it in an automated fashion. Because I don't like seeing swear words 
even in programs I think it's best if we simply get rid of all four letter words. Create a program that reads in one line 
from the user and repeats the line back with all four-letter words removed. Save as StringEx1.java */
import java.util.*;

class StringEx1{
    public static void main(String []args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a sentence: ");

        String sent = keyboard.nextLine();
        String[] words = sent.split(" ");

        for(String word : words){
            if(word.length() != 4){
                System.out.print(word + " ");
            }
        }
    }
}