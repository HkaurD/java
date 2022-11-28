import java.util.*;
//  blue cards that Alphonse has and the number of red cards that Beryl has
// 0 = blue, else red
public class Cards {
    public static final int maxcards = (int)2e5 + 10;
    static int[] alphonse = new int[maxcards];
    static int[] beryl = new int[maxcards];

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(), m = kb.nextInt(), k = kb.nextInt();
        for(int i = 0; i < n; i++){
            alphonse[i] = kb.nextInt();
        } for(int i = 0; i < m; i++){
            beryl[i] = kb.nextInt();
        }

        for(int i = 0; i < k; i++){ // each time the cards are exchanged
            
        }
    }
}