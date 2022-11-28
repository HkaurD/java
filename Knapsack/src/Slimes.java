import java.util.*;
// https://dmoj.ca/problem/dpn

public class Slimes {
    public static final int maxa = (int)1e9 + 5;
    static long[] a = new long[401];
    static long[][] dp = new long[401][401]; // stores the min cost to combine the interval of slimes from [i...j]
    static long solve(int l, int r){ // l, r = left and right interval respectively
        // base case
        if(l == r){
            return 0; // only one slime left; cannot combine with any adjacent slime
        }
        long cur = dp[l][r];
        if(cur == -1){
            // process this state for the first time
            cur = Long.MAX_VALUE;
            long sum = 0;
            for(int k = l; k < r; k++){ // iterating through the interval
                cur = Math.min(cur, solve(l, k) + solve(k + 1, r));
                sum += a[k];
            }
            cur += sum + a[r];
        }
        return cur;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // num of slimes
        for(int i = 1; i <= n; i++){
            a[i] = kb.nextInt(); // the sizes of the ith slime
        }
        for(long[] longs : dp){
            Arrays.fill(longs, -1); // -1 means that the state has not been visited yet
        }
        System.out.println(solve(1, n));
    }
}