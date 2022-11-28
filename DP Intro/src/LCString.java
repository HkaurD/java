import java.util.*;
// https://dmoj.ca/problem/dpf

public class LCString {
    public static final int maxn = (int)3e3 + 5;
    static String[][] dpstr = new String[maxn][maxn]; // stores the longest common subsequence at each prefix

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        String t = kb.nextLine();

        // base cases
//        for(int i = 1; i <= s.length(); i++){
//            dplen[i][0] = 0;
//        }
//        for(int i = 1; i <= t.length(); i++){
//            dplen[0][i] = 0;
//        }

        for(String[] st : dpstr){
            Arrays.fill(st, "");
        }

        // transition
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(dpstr[i - 1][j].length() > dpstr[i][j - 1].length()) {
                    dpstr[i][j] = dpstr[i - 1][j];
                } else{
                    dpstr[i][j] = dpstr[i][j - 1];
                }

                if(("" + s.charAt(i - 1)).equals("" + t.charAt(j - 1))){
                    dpstr[i][j] = dpstr[i - 1][j - 1]  + s.charAt(i - 1);
                }
            }
        }
        System.out.println(dpstr[s.length()][t.length()]);
    }
}