import java.util.*;

public class bars2 {
    static int quad(int a, int b, long c){
        double descrim = Math.pow(b, 2) - 4 * a * c;
        int ans = 0;
        if(descrim >= 0){
            ans = (int) Math.floor((-b + Math.sqrt(descrim))/(2*a));
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        for(int i = 0; i < t; i++){
            long n = kb.nextLong();
            int ans = quad(1, 1, -2*n);
            System.out.println(ans);
        }
    }
}