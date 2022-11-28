import java.util.*;
// https://dmoj.ca/problem/cchange

/*
state: dp[i] stores the minimum number of coins to make i cents
transition: dp[i + j] = Math.min(dp[i + j], dp[i] + 1) for the n values j
base: dp[0] = 0
 */

public class CChange {
    public static final int maxcoin = (int) 1e5 + 5;
    static int[] coins = new int[maxcoin]; // stores the coin values
    static int[] dp = new int[maxcoin]; // dp[i] stores the minimum num of ways to make i cents

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt(); // cents to make
        int n = kb.nextInt(); // num of coin denominations

        for(int i = 0; i < n; i++){
            coins[i] = kb.nextInt();
        }

        // base case
        dp[0] = 0; // no way to make 0 cents

        for(int i = 0; i < x; i++){ // looping through the dp array
            for (int coin : coins) { // using all the coins
                // the coin can only be used when the cents being made are >= the coin's value; i + coin
                // you only take the min way to make 'i + coin' cents
                if (i + coin <= x) {
                    if (dp[i + coin] == 0 || dp[i] + 1 < dp[i + coin]) { // all the indices already contain 0s (not a min way) or if a smaller way is found
                        dp[i + coin] = dp[i] + 1;
                    }
                }
            }
        }
        System.out.println(dp[x]); // the min ways to make x coins
    }
}