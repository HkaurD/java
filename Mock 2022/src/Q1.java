import java.util.*;
public class Q1 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int sum = kb.nextInt();
        int ans = 0;

        for(int i = 0; i <= sum; i++){
            int num2 = sum - i;
            if(num2 <= i && i <= 5){ // 5 fingers
                ans++;
            }
        }
        System.out.println(ans);
    }
}