public class recursiveEx1 {
    static void anagram(String word){
        anagram("", word);
    }
    static void anagram(String ans, String left){
        if(left.equals("")){
            System.out.println(ans);
        }
        else{
            for(int i = 0; i < left.length(); i++){
                String ans2 = ans + left.charAt(i);
                String left2 = left.substring(0, i) + left.substring(i + 1);
                anagram(ans2, left2);
            }
        }
    }
    public static void main(String[] args){
        anagram("stain");
    }
}