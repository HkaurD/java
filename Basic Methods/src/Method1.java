// Method1
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This method takes in an array of ints as a parameter and returns the mean of the elements as a double

public class Method1 {
    static double mean(int[] arr){
        int avg = 0;
        for(int i = 0; i < arr.length; i++){ // looping through the array and adding the elements
            avg += arr[i];
        }
        return avg/arr.length; // dividing by the num of elements; the average
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(mean(nums));
    }
}
