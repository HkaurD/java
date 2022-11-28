public class recursiveEx2 {
    static void caps(String word){
        caps("", word.toLowerCase());
    }
    static void caps(String ans, String left){
        if(left.equals("")){
            System.out.println(ans);
        }
        else{
            String ans2 = ans + left.substring(0, 1);
            String ans3 = ans + left.substring(0, 1).toUpperCase();
            String word2 = left.substring(1);

            caps(ans2, word2);
            caps(ans3, word2);
        }
    }
    public static void main(String[] args){
        caps("dog");
    }
}
