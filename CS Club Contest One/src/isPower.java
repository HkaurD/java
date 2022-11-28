import java.util.*;
public class isPower {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int pow;
        int a = kb.nextInt();
        int b = kb.nextInt();
        for(int i = 0; i <= a; i++){
            pow = (int)Math.pow(b, i);
            if(pow == a){
                System.out.println("Yes");
                break;
            }
            if(pow > a){
                System.out.println("No");
                break;
            }
        }
    }
}