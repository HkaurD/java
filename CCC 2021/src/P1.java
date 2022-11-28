import java.util.*;
public class P1 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int d = kb.nextInt();
        String curr = kb.next();
        boolean foundbigger = false;
        for(int i = 1; i < d; i++){
            if(Integer.parseInt(""+curr.charAt(i)) > Integer.parseInt(""+curr.charAt(i - 1))){
                String newStr = curr.substring(0, i - 1) + curr.charAt(i) + curr.charAt(i - 1) + curr.substring(i + 1);
                System.out.println(newStr);
                foundbigger = true;
                break;
            }
        }
        if(!foundbigger){
            System.out.println(curr);
        }
    }
}