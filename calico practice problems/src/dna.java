import java.util.*;

public class dna {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String ans = "";
        int t = kb.nextInt(); // test cases
        kb.nextLine();
        for(int i = 0; i < t; i++){
            char[] dnastrip = kb.nextLine().toCharArray();
            for(char ch : dnastrip){
                if(ch == 'A'){
                    ans += "T";
                } else if(ch == 'T'){
                    ans += "A";
                } else if(ch == 'C'){
                    ans += "G";
                } else if(ch == 'G'){
                    ans += "C";
                }
            }
            System.out.println(ans);
            ans = "";
        }
    }
}