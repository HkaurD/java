public class Recursion1 {
    // recursion is when a method calls itself
    // 5! = 5 * 4 * 3 * 2 * 1
    // 1! = 1
    // n! = n * (n - 1)!

    // factorial
    static int fact(int n){
        if(n == 1){ // base case
            return 1;
        }
        else{
            return n * fact(n - 1);
        }
    }

    // fibonacci
    // 0 1 1 2 3 5 8 13 .....
    // fib(6) -> 8
    /*
    For recursion to work, you need two things.
    1. Base case. A situation where the method does not call itself. ***** there can be more than one base case
    2. Call itself in a way that approaches the base case.
     */

    static int fib(int n){
        if(n < 2){
            return n;
        }
        else{
            return fib(n - 1) + fib(n - 2); // this recursive graph branches since the fib() method is called twice.
        }
    }

    public static void main(String[] args){
        System.out.println(fact(5));
        System.out.println(fib(6));
    }
}
