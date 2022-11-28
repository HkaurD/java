// Method5
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
/* This program involves two methods that take in an array of words, strings, and generates a random license plate with
four letters, a space and three numbers. If the licence plate has one of the words in the original array, a new license
plate is created. A valid license plate is returned.
*/

public class Method5 {
    static int randint(int low, int high){ // this method generates a random number between two integers
        return (int)(Math.random() * (high - low + 1) + low); // I use this method to get a random ASCII value between 65 and 90
    }
    static String licensePlate(String[] words){
        String plateWord = ""; // the random word on the license plate
        while (true){
            boolean valid = true; // initially the license plate is valid
            for(int i = 0; i < 4; i++) {
                plateWord = plateWord + (char)(randint('A', 'Z')); // A to Z have ASCII values of 65 to 90
            }
            for(String word : words){
                if(word.equalsIgnoreCase(plateWord)){ // if any word in the original array is in the plateWord, the license plate is not valid
                    valid = false;
                    break; // goes back to the top and generates a new plateWord
                }
            }
            if(valid){
                // this prints the plateWord, a space and then three digits; i.e. 000 to 999
                return plateWord + " " + randint(0, 9) + randint(0, 9) + randint(0, 9);
            }
        }
    }

    public static void main(String[] args){
        String[] words = {"fail", "flub", "rand"};
        System.out.println(licensePlate(words));
    }
}