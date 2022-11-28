import java.util.*;

public class twoddiffarr {
    public static final int nax = (int)5e3 + 5;
    static int[][] grid = new int[nax][nax];

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int k = kb.nextInt();

        for(int i = 0; i < k; i++){
            // (b, a) are top left corner and (d, c) are bottom right corner
            int a = kb.nextInt(); int b = kb.nextInt(); int c = kb.nextInt(); int d = kb.nextInt();
            // 2d difference array
            ++grid[a][b]; // top left corner
            --grid[c + 1][b]; // below the rectangle (transposed)
            --grid[a][d + 1]; // to the right of the rectangle
            ++grid[c + 1][d + 1]; // since the diagonally bottom corner was subtracted twice, add one again
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++) {
                // 2d prefix sum array
                // grid[i - 1][j] ------> rectangle above (transposed)
                // grid[i][j - 1] ------> rectangle to the left
                // grid[i - 1][j - 1] ------> top diagonal rectangle that was subtracted twice

                grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++) {
                // 2d prefix sum array
                // grid[i - 1][j] ------> rectangle above (transposed)
                // grid[i][j - 1] ------> rectangle to the left
                // grid[i - 1][j - 1] ------> top diagonal rectangle that was subtracted twice

                grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
            }
        }

        int q = kb.nextInt();
        for(int i = 0; i < q; i++){
            int a = kb.nextInt(); int b = kb.nextInt(); // top left corner
            int c = kb.nextInt(); int d = kb.nextInt(); // bottom right corner
            // to find the sum of the rectangle with top left coor (b, a) and bottom right (d, c),
            // use the psa at grid[c][d] and then subtract the rectangle sums...
            // grid[c - 1][b] ------> rectangle above (transposed)
            // grid[a][b - 1] ------> rectangle to the left
            // add grid[a - 1][b - 1] ------> top diagonal rectangle that was subtracted twice
            // DRAW OUT THE RECT AND THE PRINCIPLE OF INCLUSION AND EXCLUSION RECTS
            System.out.println(grid[c][d] - grid[c][b - 1] - grid[a - 1][d] + grid[a - 1][b - 1]);
        }
    }
}