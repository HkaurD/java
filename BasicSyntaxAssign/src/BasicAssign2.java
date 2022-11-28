// BasicAssign2
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This program takes a String from the user and prints the number of same consecutive characters along with the character type.

import java.util.*; // I imported the util package so that I could use Scanner to get inputs 

class BasicAssign2{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = keyboard.next();

        int count = 1; // I initialized the count of letters as one since when I compare, the count becomes 2, 3, etc.
        for(int i = 1; i < inputString.length(); i++){ // looping through the String to compare each character one by one
            if(inputString.charAt(i) == inputString.charAt(i - 1)){ // if the second and first are the same ; I used the indexes i and i - 1 since using i and i + 1 was beyond the String
                count ++;
            }
            else{
                System.out.print(count + "" + inputString.charAt(i - 1));
                count = 1; // re-initialize the count variable to 1 to count the number of next characters
            }
        }
        // in my for loop, the else is not reached if the second-last and last letters are the same so they are not printed.
        System.out.print(count + "" + inputString.charAt(inputString.length() - 1));
    }
}