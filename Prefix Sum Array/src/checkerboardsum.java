import java.util.*;

public class checkerboardsum {
    static int[][] board = new int[1000][1000];
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();

        while(true){
            int r = kb.nextInt(), c = kb.nextInt(), x = kb.nextInt();
            if(r == 0){
                break;
            }
            board[r][c] = x * ((r + c) % 2 == 0 ? 1 : -1);
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
            }
        }
        while(true){
            int r1 = kb.nextInt(), c1 = kb.nextInt(), r2 = kb.nextInt(), c2 = kb.nextInt();
            if(r1 == 0){
                break;
            }
            int ans = board[r2][c2] - board[r2][c1 - 1] - board[r1 - 1][c2] + board[r1 - 1][c1 - 1];
            if((r1 + c1) % 2 == 0){
                System.out.println(ans);
            }
            else{
                System.out.println(ans * -1);
            }
        }
    }
}