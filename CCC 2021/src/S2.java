import java.util.*;
public class S2 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();
        int[] cols = new int[n];
        int[] rows = new int[m];
        int[][] canvas = new int[n][m];

        int k = kb.nextInt();
        for(int i = 0; i < k; i++){
            String sec = kb.next();
            int num = kb.nextInt();
            if(sec.equals("R")) { // rows
                rows[num - 1]++; // freq array for rows
            } else{
                cols[num - 1]++;// freq array for columns
            }
        }
        for(int i = 0; i < canvas.length; i++){
            for(int j = 0; j < canvas[i].length; j++){
                canvas[i][j] += rows[j];
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                canvas[i][j] += cols[i];
                if(canvas[i][j] % 2 == 1){
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}