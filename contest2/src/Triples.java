import java.util.*;
public class Triples {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int p = kb.nextInt(), s = kb.nextInt();
        int ans = 0;
        for(int i = 1; i <= s; i++){
            for(int j = 1; j <= s; j++){
                for(int k = 1; k <= s; k++){
                    if(i * j * k <= p && i + j + k <= s){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}