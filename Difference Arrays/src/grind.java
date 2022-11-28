import java.util.*;

/*
what do difference arrays do?
- perform range updates in O(1)

how does it perform range updates?
- performs an operation like addition to the starting point of the range, then performs the inverse operation
(e.g. inverse of addition is subtraction) to the exclusive ending point of the range.
- when we calculate the prefix sum array of the array in the end, we are left with the updated array

- easy to implement
- can't access the elements in between updates in constant time
 */

public class grind {
    static final int nax = (int)1e7 + 5;
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int numEvents = kb.nextInt();
        int[] diffarr = new int[nax];
        int[] psa = new int[nax];
        int lastDay = 0, ans = 0;

        for(int i = 0; i < numEvents; i++){
            // the start day is inclusive but the end day is exclusive
            int start = kb.nextInt(), end = kb.nextInt();
            diffarr[start]++;
            // since in this question the end was inclusive, I directly subtracted one but if it was inclusive, do diffarr[end + 1]--;
            diffarr[end]--; // when the prefix sum array is calculated, the event increase is for all the days until the exclusive end day
            if(end > lastDay){
                lastDay = end; // how many elements to loop through
            }
        }

        for(int i = 1; i <= lastDay; i++){
            psa[i] = psa[i - 1] + diffarr[i];
            ans = Math.max(ans, psa[i]);
        }

        System.out.println(ans);
    }
}