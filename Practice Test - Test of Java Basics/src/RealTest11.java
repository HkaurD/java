import java.util.*;

public class RealTest11 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of triangles: ");
        int numOfTri = keyboard.nextInt();

        while(numOfTri > 0) {
            int sideA = (int) (Math.random() * 49 + 1);
            int sideB = (int) (Math.random() * 49 + 1);
            int sideC = (int) (Math.random() * 49 + 1);
            if (sideC * sideC == sideA * sideA + sideB * sideB) {
                System.out.println(sideA + " " + sideB + " " + sideC);
                numOfTri--;
            }
        }
    }
}
