import java.util.*;
// L A R G E S T     I N C R E A S I N G     S U B S E Q U E N C E
// https://dmoj.ca/problem/dp1p3

public class LIS {
    public static final int maxn = (int)5e3 + 5;
    static int[] arr = new int[maxn];
    // state
    static int[] dp = new int[maxn]; // dp stores the largest increasing subsequence up to each index

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // num of elements

        for(int i = 1; i <= n; i++){
            arr[i] = kb.nextInt(); // the inputted numbers in specific order
        }

        // base case
        arr[0] = 0;

        // transition
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){ // the previous element must be strictly smaller
                if(arr[j] < arr[i]){
                    // can extend from a subsequence ending at a[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1); // if the previous found subsequence is longer, keep that length
                }
            }
        }

        int ans = 0; // finding the longest subsequence length
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}

// 1 5 2 6 4 ----> 3
// 1 2 5 4 3 6 ----> 4

// TO FIND THE ACTUAL SEQUENCE, BACKTRACK (e.g. dp[n] = largest seq, and dp[n] = dp[n - 5] + 1 so go to dp[n - 5].....