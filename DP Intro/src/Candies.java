import java.util.*;
// https://dmoj.ca/problem/dpm

public class Candies {
    public static final int mod = (int)1e5;
    static long[] a = new long[105]; // the max candies child i can take
    static long[][] dp = new long[105][100005]; // num of ways to distribute j candies to i children ; dp[i][j]
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        long n = kb.nextInt(); // num of children
        long k = kb.nextInt(); // num of candy

        for(int i = 1; i <= n; i++){
            a[i] = kb.nextInt();
        }

        // base case
        // 0 children can distribute 0 candies in 1 way
        dp[0][0] = 1;

        // psa
        for(int j = 1; j <= k; j++){
            dp[0][j] = dp[0][j - 1];
        }
        // transition
        for(int i = 1; i <= n; i++){ // children
            for(int j = 0; j <= k; j++){ // candies
                // first i children took j candies
                // i-th child takes between 0 and a[i] candies
                // j - 0 = j (max that the first i - 1 children took) and j - a[i] (min)
                // then the first i - 1 children took between j - a[i] and j candies
                dp[i][j] += dp[i - 1][j] - (j - a[i] <= 0 ? 0 : dp[i - 1][(int) (Math.max(j - a[i], 0) - 1)]);
                dp[i][j] %= mod;
                if(j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.println((dp[(int) n][(int) k] + mod) % mod);
    }
}