public class Recursion2 {
    /*static void fourBit(){ // fourBit example ---> 0110
        for(int i =0; i < 2; i++){
            for(int j =0; j < 2; j++){
                for(int k =0; k < 2; k++){
                    for(int m =0; m < 2; m++){
                        System.out.println("" + i + j + k + m);
                    }
                }
            }
        }
    }*/

    static void bits(int n){
        bits(n, "");
    }
    static void bits(int n, String ans){
        if(n == 0){
            System.out.println(ans);
        }
        else{
            bits(n - 1, ans + "0");
            bits(n - 1, ans + "1");
        }
    }
    public static void main(String[] args){
        bits(6);
    }
}
