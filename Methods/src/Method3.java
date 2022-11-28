import java.util.*;
import java.awt.*;

public class Method3 {
    // global variables (Not a "true" global because it is local to the class)
    static int rangeCount = 0; // since the variable belongs to the class, not an object, it must be static
    // variables in Java should always have the smallest scope that still work

    static int[] range(int n){
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
            rangeCount ++;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = range(10);
        System.out.println(Arrays.toString(nums));
        System.out.println(rangeCount);
    }
}
