import java.util.*;
public class P2 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(), k = kb.nextInt();
        int[] vals = new int[n + 5];
        String entries = kb.next();

        for(int i = 0; i < entries.length(); i++){
            if(("" + entries.charAt(i)).equals("0")){
                vals[i] = 1;
            } else{
                vals[i] = 2;
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){

        }
    }
}