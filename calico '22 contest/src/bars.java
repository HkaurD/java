import java.util.*;
public class bars {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt(); // test cases

        for(int i = 0; i < t; i++){
            int n = kb.nextInt();
            int days = 0;
            int eaten = 0;
            if(n == 0){
                System.out.println(0);
            } else if(n == 1){
                System.out.println(1);
            }

            for(int j = 1; j <= n; j++){
                if(eaten + j <= n){
                    eaten += j;
                    days++;
                } else{
                    System.out.println(days);
                    break;
                }
            }
        }
    }
}