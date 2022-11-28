// Method3
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This method takes in an array of ints and an integer as parameters and adds the integer to the end of the array

import java.util.*;
public class Method3 {
    static int[] arrayAdd(int[] arr, int num){
        int[] newArr = new int[arr.length + 1]; // the new array has to be one larger to add the new element
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i]; // adding the original array's elements into the new array
        }
        newArr[newArr.length - 1] = num; // adding the num from the parameter to the end of the new array
        return newArr;
    }
    public static void main(String[] args){
        int[] nums = {0, 2, 4, 6, 8};
        int[] numsAdd = arrayAdd(nums, 10);
        System.out.print(Arrays.toString(numsAdd));
    }
}