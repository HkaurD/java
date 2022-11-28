import java.util.*;
public class Q2 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[] psa1 = new int[n + 1];
        int[] psa2 = new int[n + 1];

        for(int i = 1; i <= n; i++){
            psa1[i] = psa1[i - 1] + kb.nextInt();
        }
        for(int i = 1; i <= n; i++){
            psa2[i] = psa2[i - 1] + kb.nextInt();
        }

        int days = 0;
        for(int i = 1; i < psa1.length; i++){
            if(psa1[i] == psa2[i]){
                days = i;
            }
        }

        System.out.println(days);
    }
}