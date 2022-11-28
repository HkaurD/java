// Method2
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This method takes in a string and an integer as parameters and prints the string repeated "integer" times

public class Method2 {
    static void repeat(String s, int num){
        String ans = "";
        for(int i = 0; i < num; i++){
            ans += s; // adding the string to the answer "num" times
        }
        System.out.println(ans);
    }
    public static void main(String[] args){
        repeat("harbin", 5);
    }
}
