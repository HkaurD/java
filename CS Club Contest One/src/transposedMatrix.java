import java.util.*;
public class transposedMatrix {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String[] rowCols= kb.nextLine().split(" ");
        int rows = Integer.parseInt(rowCols[0]);
        int cols = Integer.parseInt(rowCols[1]);
        int[][] matrix = new int[cols][rows];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                matrix[j][i] = kb.nextInt();
            }
        }
        int t = kb.nextInt();
        System.out.println();
        if(t % 2 == 0){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++) {
                    System.out.print(matrix[j][i] + " ");
                }
                System.out.println();
            }
        }
        else{
            for(int i = 0; i < cols; i++){
                for(int j = 0; j < rows; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}