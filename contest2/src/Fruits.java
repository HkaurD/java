import java.util.*;

public class Fruits {
    static int[][][] dp = new int[305][305][305]; // num of boxes, num of apples, num of bananas
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(), app = kb.nextInt(), ban = kb.nextInt();

        for(int[][] x : dp){
            for(int[] y : x){
                Arrays.fill(y, (int)1e5);
            }
        }
        dp[0][0][0] = 0; // base case
        for(int i = 1; i <= n; i++){
            int a = kb.nextInt(), b = kb.nextInt(), cost = kb.nextInt();
            for(int j = 1; j <= app; j++){
                for(int k = 1; k <= ban; k++){
                    dp[i][j][k] = dp[i - 1][j][k]; // before taking the box; default cost if a box is not taken
                    if(j >= a && k >= b) {
                        if(dp[i][j][k] == 0){
                            dp[i][j][k] = dp[i - 1][j - a][k - b] + cost;
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - a][k - b] + cost); // taking the same num of apples and bananas based on the lowest cost
                        }
                    }
                }
            }
        }
        if(dp[n][app][ban] == (int)1e5){
            System.out.println(-1);
        } else {
            System.out.println(dp[n][app][ban]);
        }
    }
}