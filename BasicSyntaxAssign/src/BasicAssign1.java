// BasicAssign1
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This program takes a String from the user and prints a hollow square with side length one greater than the length of the square.

import java.util.*; // I imported the util package so that I could use Scanner to get inputs

class BasicAssign1{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String msg = ""; // since msg is an "empty" String, I could add the user's input to the variable without knowing the length
        msg = keyboard.next();

        char[] sides = msg.substring(1).toCharArray(); // this array is used for the left and right sides of the square - exluding the first letter
        msg = msg + msg.charAt(0); // since the hollow square has a side length that is one greater than the string entered, I added the first letter
        char[] letts = msg.toCharArray(); // this is used to print out the top and bottom sides of the hollow square
        String hollowWhite = ""; // the hollow white space inside the square

        for(char ch : letts){
            System.out.print(ch); // printing the top side
        }
        System.out.println(" "); // since I used print(), I have to add a println tp "eat" the extra whitespace to print the sides of the square

        for(int i = 0; i < sides.length; i++){
            hollowWhite = hollowWhite + " "; // the hollow white space is the length of the sides, so this creates spaces
        }

        for(int i = 0; i < sides.length; i++){
            System.out.println(sides[sides.length - 1 - i] + hollowWhite + sides[i]); // printing the sides of the square line by line
        }

        for(int i = 0; i < letts.length; i++){
            System.out.print(letts[letts.length - 1 - i]); // printing the bottom of the square in reverse from the top
        }
    }
}