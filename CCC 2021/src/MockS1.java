import java.util.*;
public class MockS1 {
    static ArrayList<String> arr = new ArrayList<>();
    static ArrayList<String> perms = new ArrayList<>();

    static void permutation(String ans, String left){
        if(left.equals("") && !arr.contains(ans)){
            arr.add(ans);
        } else{
            for(int i = 0; i < left.length(); i++){
                String newAns = ans + left.charAt(i);
                String newLeft = left.substring(0, i) + left.substring(i + 1);
                permutation(newAns, newLeft);
            }
        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String alpha = kb.nextLine();
        String og = kb.nextLine();
        permutation("", og);

        for(String word : perms) {
            for (int i = 0; i < alpha.length(); i++) {
                String new1 = word.substring(0, word.indexOf(alpha.charAt(i))) + word.substring(word.indexOf(alpha.charAt(i)) + 1); // removing a character
                System.out.println(new1);
                if(!arr.contains(new1)){
                    arr.add(new1);
                }
                String new2 = word + alpha.charAt(i); // adding a character
                System.out.println(new2);
                if(!arr.contains(new2)){
                    arr.add(new2);
                }
            }
        }
        System.out.println(arr);
    }
}