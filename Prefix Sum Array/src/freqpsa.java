import java.util.*;

public class freqpsa {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        char[] letts = kb.nextLine().toCharArray();
        int[] freq = new int[letts.length + 1];
        int[] psa = new int[letts.length + 1];

        for(int i = 1; i <= letts.length; i++){
            if(("" + letts[i - 1]).equals("G")){
                freq[i] = 1; // the whole array is already filled with 0s, so I don't have to say else fre[i] = 0
            }
            psa[i] = psa[i - 1] + freq[i];
        }

        int n = kb.nextInt();
        for(int i = 0; i < n; i++){
            int start = kb.nextInt() + 1, end = kb.nextInt() + 1;
            System.out.println(psa[end] - psa[start - 1]);
        }
    }
}