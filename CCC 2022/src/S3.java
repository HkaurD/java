import java.util.*;
public class S3 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(), m = kb.nextInt(), k = kb.nextInt();
        ArrayList<String> perms = new ArrayList<>();

        int[] pitches = {1, 2};
        String og = "";
        String[] strs = new String[20];
        for(int i = 0; i < n; i++){
            og += "1";
        }
        strs[0] = og;
        for(int i = 0; i < n; i++){
            strs[i] = og.substring(0, strs.length - 1);
            og = strs[i];
        }
        System.out.println(Arrays.toString(strs));
    }
}