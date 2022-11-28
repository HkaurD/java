import java.util.*;
public class S1 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int ans = 0;
        for(int i = 0; i <= n; i++){
            int numFives = n - 4 * i;
            if(numFives >= 0 && numFives % 5 == 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}