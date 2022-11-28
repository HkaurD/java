import java.util.*;

public class frame {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        ArrayList<String> quotes = new ArrayList<>();

        for(int i = 0; i < t; i++){
            quotes.add(kb.nextLine());
        }

        for(String quote: quotes){
            String[] words = quote.split(" ");
            int biggest = 0;
            for(String word : words){
                biggest = Math.max(word.length(), biggest);
            }
            System.out.println("*".repeat(biggest + 2));
            for(String word : words){
                System.out.println("*" + word + " ".repeat(biggest - word.length()) + "*");
            }
            System.out.println("*".repeat(biggest + 2) +"\n");
        }
    }
}