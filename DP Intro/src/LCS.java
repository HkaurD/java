import java.util.*;
// L A R G E S T     C O M M O N     S U B S E Q U E N C E
// https://dmoj.ca/problem/lcs

public class LCS {
    public static final int maxn = (int)1e3 + 5;
    static int[] a = new int[maxn]; static int[] b = new int[maxn];

    // state
    // two-d dp array since there are two arrays to analyze; first dimension = a and second dimension = b
    static int[][] dp = new int[maxn][maxn]; // stores the largest common subsequence in the prefixes a[1...i] and b[1...j]

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(), m = kb.nextInt();

        for(int i = 1; i <= n; i++){
            a[i] = kb.nextInt();
        }

        for(int i = 1; i <= m; i++){
            b[i] = kb.nextInt();
        }

        // base cases - draw a n by m table to visualize
        for(int i = 1; i <= n; i++){
            // when one array has a length of 0, nothing is common
            dp[i][0] = 0;
        }
        for(int i = 1; i <= m; i++){ // draw a n by m table
            dp[0][i] = 0;
        }

        // transition
        // case 1 : a[i] == a[j], look at the sub-problem involving the elements before; dp[i - 1][j - 1] + 1 and check
        // if this is larger than dp[i - 1][j] and dp[i][j - 1]
        // case 2 : a[i] != a[j], so take the max of dp[i - 1][j] ans dp[i][j - 1] to store the largest current subsequence

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // this is true no matter if case 1 satisfies

                if(a[i] == b[j]){ // case 1
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1); // the elements before a[i] and b[j]
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}

// 5 3
// 1 4 3 4 2
// 2 1 3