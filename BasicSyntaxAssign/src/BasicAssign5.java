// BasicAssign5
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
/* This program takes in a product code and prints out whether or not it is valid based on if:
   (1) The first part is all capitals,
   (2) The first part contains only 6 digits,
   (3) Both the first and second part of the code are seperated by one space
   (4) The second part consists of all digits, and
   (5) The product of the digits taken in pairs from left in the first part equals the number in the second part.*/

import java.util.*;

class BasicAssign5{
    public static void main(String[] args){
        boolean validCode = true; // this variable changes based on if the code follows the rules; I use this to print valid or invalid code
        int digitCount = 0;
        int product = 1; // product of digits in codePartOne taken in pairs
        String codeOneDigs = ""; // used to seperate the digits in codePartOne to find product

        Scanner keyboard = new Scanner(System.in);
        String code = keyboard.nextLine();

        if(!code.contains(" ") || code.contains("  ")){ // if there are no spaces or more than one, code is invalid
            System.out.println("Not valid code.");
        }
        else{
            String[] splitCode = code.split(" ");
            char[] codePartOne = splitCode[0].toCharArray(); // I split the code into two seperate parts to compare
            char[] codePartTwo = splitCode[1].toCharArray();

            for(char dig : codePartTwo){
                if(!Character.isDigit(dig)){ // this Character method checks if a character is a digit
                    validCode = false; // all of the characters in part two must be digits for the code to be valid
                }
            }
            for(char ch : codePartOne){
                if(Character.isDigit(ch)){
                    digitCount ++;
                    codeOneDigs = codeOneDigs + ch; // adding the digits from codePartOne to multiply after
                }
                else if(Character.isLowerCase(ch)){ // this Character method checks if a character is in lower case
                    validCode = false; // all characters must be uppercase
                }
            }
            if(digitCount == 6 && validCode){
                int codeTwoProd = Integer.parseInt(splitCode[1]); // converting the digits in codePartTwo to compare with product
                for(int i = 0; i < codeOneDigs.length(); i += 2){
                    product *= Integer.parseInt("" + codeOneDigs.charAt(i) + codeOneDigs.charAt(i + 1)); // multiplying the digits in pairs
                }
                if(product == codeTwoProd){
                    System.out.println("You entered valid code!");
                }
                else{
                    System.out.println("Not valid code.");
                }
            }
            else{
                System.out.println("Not valid code.");
            }
        }
    }
}