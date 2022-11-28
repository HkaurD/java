import java.util.*;
// https://dmoj.ca/problem/dpd

public class Knapsack1 {
    public static final int maxw = (int)1e5 + 5;
    static long[] dp = new long[maxw]; // dp[i], where i is the weight, stores the max value
    static long[] dp2 = new long[maxw]; // this is a copy which stores the previous values

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int nitems = kb.nextInt(); // num of items
        int maxWeight = kb.nextInt(); // weight capacity of the knapsack

        // base case is that dp[0][0] = 0 since 0 items have a weight of 0 and dp[0....i][0] = 0 and dp[0][0....j] = 0
        for(int i = 1; i <= nitems; i++){ // looping through the items
            int w = kb.nextInt();
            long v = kb.nextInt(); // w = weight and v = value
            for(int j = 1; j <= maxWeight; j++){ // looping through the weights
                dp[j] = dp2[j]; // at least has the same value as NOT taking the item; "base"
                if(j >= w){ // since we want to access the item before without the current weight
                    dp[j] = Math.max(dp[j], dp2[j - w] + v); // not taking vs taking the item; take the max value
                }
            }
            for(int j = 1; j <= maxWeight; j++){
                dp2[j] = dp[j];
            }
        }
        System.out.println(dp[maxWeight]);
    }
}

//3 8
//3 30
//4 50
//5 60
//90