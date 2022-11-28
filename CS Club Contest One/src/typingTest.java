import java.util.*;
public class typingTest {
    public static void main(String[] args){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner kb = new Scanner(System.in);
        int len = kb.nextInt();
        String word = kb.next();
        int energy = 0;
        for(int i = 1; i < len; i++){
            energy += Math.abs(alphabet.indexOf(word.charAt(i)) - alphabet.indexOf(word.charAt(i - 1)));
        }
        System.out.println(energy);
    }
}
