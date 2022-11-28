// BasicAssign4
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
/* This program runs an experiment generating random birthdays until there is a repeat. After running through the experiment
 * 10 000 times, it prints the average number of birthdays in each experiment.*/
import java.util.*;

class BasicAssign4{
    public static void main(String[] args){
        int[] birthdays = new int[365]; // this array contains all the generated birthdays and is used to check if there is a repeat
        double sum = 0; // sum of number of dates in each of the 10000 experiments
        int date;
        for(int j = 0; j < 10000; j++){
            for(int i = 0; i < 365; i++){
                date = (int)(Math.random() * 365 + 1); // generates a day between 1 and 365 inclusive
                // since an "empty" array is filled with 0's as placeholders, I change the (date-1)th index to 1. If the same date is generated, the value in the
                // array would be 1 so there is a repeat.
                if(birthdays[date - 1] == 0){
                    birthdays[date - 1] = 1;
                }
                else{
                    sum += i + 1;

                    Arrays.fill(birthdays, 0); // re-filling the array with 0's to redo the experiment 10000 times
                    break;
                }
            }
        }
        System.out.println(sum / 10000);
    }
}
