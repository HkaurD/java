import java.util.*;
public class compress {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int numLines = keyboard.nextInt();
        keyboard.nextLine();
        String[] charLines = new String[numLines];

        for(int i = 0; i < numLines; i++){
            charLines[i] = keyboard.nextLine();
        }

        String curr = ""+charLines[0].charAt(1);
        int count = 0;

        for(int i = 0; i < charLines.length; i++){
            for(int j = 0; j < charLines[i].length(); j++){
                if(curr.equals(""+charLines[i].charAt(j))){
                    count++;
                }
                else{
                    System.out.print(count + curr + " ");
                    curr = ""+charLines[i].charAt(j);
                    count = 1;
                }
            }
        }
    }
}

/*
4
+++===!!!!
777777......TTTTTTTTTTTT
(AABBC)
3.1415555
 */
