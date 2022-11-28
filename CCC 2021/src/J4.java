import java.util.*;
public class J4 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String books = kb.nextLine();
        int l = 0, m = 0;
        int swaps = 0;

        for(int i = 0; i < books.length(); i++){
            if(("" + books.charAt(i)).equals("L")){
                l++;
            } else if(("" + books.charAt(i)).equals("M")){
                m++;
            }
        }

        ArrayList<String> large = new ArrayList<>(); ArrayList<String> medium = new ArrayList<>(); ArrayList<String> small = new ArrayList<>();
        for(int i = 0; i < books.length(); i++){
            if(i < l){
                large.add(""+books.charAt(i));
            } else if(i < l+m){
                medium.add(""+books.charAt(i));
            } else{
                small.add(""+books.charAt(i));
            }
        }
        while(true){
            if(large.contains("S")){
                if(small.contains("L")) {
                    large.set(large.indexOf("S"), "L");
                    small.set(small.indexOf("L"), "S");
                    swaps++;
                } else if(medium.contains("L")){
                    large.set(large.indexOf("S"), "L");
                    medium.set(medium.indexOf("L"), "S");
                    swaps++;
                }
            } else if(large.contains("M")){
                if(medium.contains("L")) {
                    large.set(large.indexOf("M"), "L");
                    medium.set(medium.indexOf("L"), "M");
                    swaps++;
                } else if(small.contains("L")){
                    large.set(large.indexOf("M"), "L");
                    small.set(small.indexOf("L"), "M");
                    swaps++;
                }
            } else if(medium.contains("S")){
                if(small.contains("M")) {
                    medium.set(medium.indexOf("S"), "M");
                    small.set(small.indexOf("M"), "S");
                    swaps++;
                }
            } else{
                System.out.println(swaps);
                break;
            }
        }
    }
}