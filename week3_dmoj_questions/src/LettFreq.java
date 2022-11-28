import java.util.*;

public class LettFreq {
    static int[][] freq = new int[33][1000001]; // first dimension is letter and second dimension is psa of index the letter's found
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) % 97][i + 1] = 1; // adding the indices to the specific letters
        }

        for(int i = 0; i < freq.length; i++){
            for(int j = 1; j <= s.length(); j++){
                freq[i][j] += freq[i][j - 1];
            }
        }

        int q = kb.nextInt();

        for(int l = 0; l < q; l++){
            int i = kb.nextInt(); int j = kb.nextInt(); int c = kb.next().charAt(0);
            int[] lett = freq[c % 97];
            System.out.println(lett[j] - lett[i - 1]);
        }
    }
}