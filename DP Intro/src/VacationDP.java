import java.util.*;
public class VacationDP {
    public static final int maxn = (int)1e5 + 5;
    static int[] a = new int[maxn]; static int[] b = new int[maxn]; static int[] c = new int[maxn]; // the events
    static int[][] dp = new int[maxn][3]; // first dimension is days and second dimension is the last event carried out

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i = 1; i <= n; i++){
            a[i] = kb.nextInt(); b[i] = kb.nextInt(); c[i] = kb.nextInt();
        }

        // --------- B A S E     C A S E -----------
        dp[0][0] = dp[0][1] = dp[0][2] = 0; // on day 0, each event a, b, c gives 0 pts of happiness

        // --------- T R A N S I T I O N S -----------
        for(int i = 1; i <= n; i++){
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + a[i]; // choosing activity a on the i-th day
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + b[i]; // choosing activity b on the i-th day
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + c[i]; // choosing activity c on the i-th day
        }

        System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));
    }
}