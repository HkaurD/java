import java.util.*;
// https://dmoj.ca/problem/dpl

public class Deque {
    static long[] a = new long[3005]; // the int sequence
    static long[][] dp = new long[3005][3005]; // the first dimension is the left interval and the second dimension is the right interval

    static long solve(int l, int r){
        // base case
        if(l == r){
            return a[l]; // only one num can be chosen
        }
        long cur = dp[l][r];
        if(cur == -1){
            // have not visited this state
            cur = Math.max(a[l] - solve(l + 1, r), a[r] - solve(l, r - 1));
        }
        return cur;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // length of the sequence, a
        for(int i = 1; i <= n; i++){
            a[i] = kb.nextInt();
        }

        for(long[] longs : dp){
            Arrays.fill(longs, -1);
        }
        System.out.println(solve(1, n));
    }
}