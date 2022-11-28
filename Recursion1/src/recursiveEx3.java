public class recursiveEx3 {
    public static String toBinary(int n){
        if(n == 1){
            return "1";
        }
        else{
            return toBinary(n/2) + n % 2;
        }
    }
    public static void main(String[] args){
        System.out.println(toBinary(25));
    }
}
