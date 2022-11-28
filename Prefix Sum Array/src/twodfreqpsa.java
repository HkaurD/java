// forest queries
import java.util.*;
public class twodfreqpsa {
    static int[][] psa = new int[1000][1000]; // the 2d array to store the sum of all the elements from the top left corner to each possible bottom right
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // size of forest - n by n square
        int q = kb.nextInt(); // num of queries

        for(int i = 1; i <= n; i++){
            String s = kb.next();
            kb.nextLine();
            for(int j = 1; j <= n; j++){
                if(("" + s.charAt(j - 1)).equals("*")) {
                    psa[i][j] = 1; // * represents a tree
                }
                psa[i][j] += psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
            }
        }
        for(int i = 0; i < q; i++){
            int y1 = kb.nextInt(), x1 = kb.nextInt(), y2 = kb.nextInt(), x2 = kb.nextInt();
            System.out.println(psa[y2][x2] - psa[y1 - 1][x2] - psa[y2][x1 - 1] + psa[y1 - 1][x1 - 1]);
        }
    }
}

// 4 3
//.*..
//*.**
//**..
//****
//2 2 3 4
//3 1 3 1
//1 1 2 2

// prints out 3, 1, 2