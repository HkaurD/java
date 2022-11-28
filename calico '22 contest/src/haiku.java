import java.util.*;

public class haiku {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt(); // test cases
        for(int i = 0; i < t; i++){
            int numWords = kb.nextInt();
            ArrayList<Integer> syl = new ArrayList<Integer>();
            ArrayList<String> word = new ArrayList<String>();
            int sum = 0;
            for(int j = 0; j < numWords; j++){
                int syllable = kb.nextInt();
                syl.add(syllable);
                word.add(kb.next());
                sum += syllable;
            }
            if(sum < 17){
                System.out.println("IMPOSSIBLE");
                System.out.println("IMPOSSIBLE");
                System.out.println("IMPOSSIBLE");
            } else{
                ArrayList<Integer> totsyl = new ArrayList<>();
                totsyl.add(0); // no 0 syl words
                for(int k = 1; k < 8; k++){

                }
            }
        }
    }
}
