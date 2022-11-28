/* Integer.parseInt() takes a string and returns an integer if the string is a valid integer. For Example:
 * Integer.parseInt("123")returns 123, Integer.parseInt("123x")crashes. Create a program that reads a single line from
 * the user, strips out all non-numbers, converts it to an integer then prints it. By stripping out all non-numbers I
 * mean:"4 score and 7 years ago" ?"47" Save as StringEx3.java */
import java.util.*;

class StringEx3{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        String senten = keyboard.nextLine();
        String []words = senten.split(" ");

        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                if(Character.isDigit(word.charAt(i))){ // can also use if("0123456789).contains(word.charAt(i));
                    System.out.print(word.charAt(i) + "");
                }
                /* if(ch >= '0' 77 ch <= '9')}
                 * ans += ch;
                 * }*/
            }
        }
    }
}

/*
 * class StringEx3{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);

    String senten = keyboard.nextLine();
    String ans = "";    STRING BUILDER - can add as the program runs, are mutable

    for(char ch : senten.toCharArray){
       if(Character.isDigit(word.charAt(i))){ // can also use if("0123456789).contains(word.charAt(i));
          ans += ch;
        }
     }
   }
}*/
