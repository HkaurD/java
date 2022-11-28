import java.util.*;

class Array1 {
    public static void main(String[] args) {
        // An array does not grow or shrink
        int []nums = {4, 5, 6};            // declare an array and initialize
        // nums = {24, 67, 89, 55};        can not do this
        nums = new int[]{24, 67, 89, 55};  // do this instead

        // If I just want to read the values but not change them
        for(int n : nums){ // read n in the Array nums
            System.out.println(n);
        }

        for(int i = 0; i <nums.length; i++){
            nums[i] *= 2;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}