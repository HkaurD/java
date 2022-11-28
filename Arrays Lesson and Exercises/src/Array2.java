import java.util.*;

class Array2{
    public static void main(String [] args){
        String tmp = "this is a test";
        String [] words = tmp.split(" ");   // can't leave it blank, but can use regex
        char [] letts = tmp.toCharArray();

        System.out.println(Arrays.toString(words));
        System.out.println(Arrays.toString(letts));

        for(char ch : letts){
            if(!"aeiouAEIOU".contains("" + ch)){
                System.out.println(ch);
            }
        }
        double money = 1000;
        int year = 0;
        System.out.println("Year       Money");
        while(money < 2000){
            year += 1;money *= 1.06;
            System.out.printf("%4d%12.2f\n", year, money);
        }
    }
}