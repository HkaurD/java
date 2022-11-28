import java.util.*;
// https://dmoj.ca/problem/dmopc13c3p5

public class Dinner {
    static int[][][] dp = new int[151][301][101]; // dp[i][j][k], where i = num of restaurants, j = time, k = amt of food, stores the total impression/value v
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt(); // max time
        int u = kb.nextInt(); // max amt of food
        int r = kb.nextInt(); // num of restaurants

        for(int i = 1; i <= r; i++){
            int v = kb.nextInt(), t = kb.nextInt(), f = kb.nextInt(); // v = value, t = time, f = food served
            for(int j = 1; j <= m; j++){
                for(int k = 1; k <= u; k++){
                    dp[i][j][k] = dp[i - 1][j][k]; // not going to the restaurant, same total time and food
                    if(j >= t && k >= f){ // must be possible to take the item
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - t][k - f] + v); // we want the max impression
                    }
                }
            }
        }
        System.out.println(dp[r][m][u]);
    }
}