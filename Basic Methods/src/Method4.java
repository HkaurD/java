// Method4
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
/* This method takes in an array of integers and returns an array half the size rounded down with the sum
 of the consecutive first half and second half elements. */

import java.util.*;
public class Method4 {
    static int[] fold(int[] nums){
        int[] newNums = new int[nums.length/2]; // array that will add the first half and second half of an array
        int[] secHalf = new int[nums.length - newNums.length]; // second half of the array

        for(int i = 0; i < newNums.length; i++){
            newNums[i] = nums[i]; // adding the first half of the original array into the new array
        }
        for(int j = 0; j < secHalf.length; j++){
            secHalf[j] = nums[j + newNums.length]; // adding the second half of the original array into the new array
        }
        for(int k = 0; k < newNums.length; k++){
            newNums[k] = newNums[k] + secHalf[k]; // summing the consecutive first and second half elements
        }
        return newNums;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] numsFold = fold(nums);
        System.out.print(Arrays.toString(numsFold));
    }
}