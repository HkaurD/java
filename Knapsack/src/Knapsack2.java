import java.util.*;
// https://dmoj.ca/problem/dpe

public class Knapsack2 {
    public static final int maxv = (int)1e5 + 5;
    static long[] dp = new long[maxv]; // dp[i][j] stores the min weight for each value i

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // num of items
        long maxweight = kb.nextInt(); // weight capacity of the knapsack

        Arrays.fill(dp, (long) 1e9 + 1);

        // base case
        dp[0] = 0; // 0 items with 0 value have 0 weight

        for(int i = 1; i <= n; i++){
            long w = kb.nextInt(), v = kb.nextInt();
            for(int j = 100004; j >= v; j--){ // the max value possible is 10^3 (max value) * 100 (num of items)
                dp[j] = Math.min(dp[j], dp[(int) (j - v)] + w); // taking the min weight; the current one or if the new item is taken
            }
        }

        for(int i = 100004; i >= 0; i--){
            if(dp[i] <= maxweight){
                System.out.println(i); // printing the value
                break;
            }
        }
    }
}

//3 8
//3 30
//4 50
//5 60
//90