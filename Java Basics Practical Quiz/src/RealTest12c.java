import java.util.*;
public class RealTest12c {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Sentence: ");
        String senten = keyboard.nextLine();
        int product = 1;

        for(int i = 1; i < senten.length(); i++){
            if(Character.isDigit(senten.charAt(i))){
                if(Character.isDigit(senten.charAt(i - 1))) {
                    product *= Integer.parseInt("" + senten.charAt(i) + senten.charAt(i + 1));
                }
                else{
                    product *= Integer.parseInt(""+senten.charAt(i));
                }
            }
        }

        String productStr = String.valueOf(product);
        System.out.println("PIN:" + productStr.substring(productStr.length() - 4));
    }
}
