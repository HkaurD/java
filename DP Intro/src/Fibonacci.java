//---------------------------------- D Y N A M I C      P R O G R A M M I N G ----------------------------------//

//  DP is similar to divide and conquer where you split up a large, complex problem into smaller sub-problems. But it differs
//  where DP consists of overlapping sub-problems that can be stored and used later, greatly improving efficiency in terms
//  of time complexity, but coming at the cost of space efficiency.

//To split up a large problem into smaller subproblems, there are two thought processes that we need to dive into.
// These are top-down and bottom-up. These also create two techniques that you will need to use for DP called tabulation
// and memoization

// For a top-down approach, we would start from the bigger picture then work our way down to the smaller details that we
// can easily work on.
// For a bottom-up approach, we would start from the smallest picture then work our way up to the largest picture that
// we’re trying to solve.

// Memoization
//Memoization is a technique used to speed up your code by storing the results of any expensive function call and
// returning the stored value when we need to call that function.

//This is used in a top-down approach, as when you split off into smaller sub-problems, you would store the result of
// those sub-problems for later use.

//Tabulation
//Tabulation is a technique where we directly solve the sub-problems in dynamic programming, and as such is used in the
// bottom-up approach. It’s called tabulation since we’re calculating values in a table until we reach the answer for
// the bigger problem.

import java.util.Arrays;

public class Fibonacci {
    public static final int nax = (int)1e3 + 5;

    // this is a naive application of finding the nth fibonacci number; multiple operations are evaluated more than once
    static long naiveFib(int num){
        if(num <= 2){ // the first and second fib num are 1
            return 1;
        }
        return naiveFib(num - 1) + naiveFib(num - 2); // these calls stack up until the base case is left and an int is returned
    }

    // top-bottom approach
    static long[] mem = new long[nax];
    static long memFib(int num){
        //mem[1] = 1; mem[2] = 1; // the first two terms are 1
        if(num == 0 || num == 1){ // base case
            return num; // 0th and 1st term are 0 and 1 respectively
        }
        if(mem[num] != 0){ // 0 means that the fib term hasn't been evaluated
            return mem[num];
        }
        else {
            mem[num] = memFib(num - 1) + memFib(num - 2); // stores the answer
            return mem[num];
        }
    }

    // bottom-top approach
    static long tabFib(int num){
        long[] fib = new long[nax]; // will store all the fibonacci terms so it can be directly accessed; O(1)

        fib[1] = 1; fib[2] = 1; // the first two terms are 1
        for(int i = 3; i <= num; i++){ // storing the terms past the first two
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(Arrays.toString(fib));
        return fib[num];
    }

    public static void main(String[] args){
        System.out.println(memFib(90));
        //System.out.println(Arrays.toString(mem));
        System.out.println(tabFib(90));
        //System.out.println(naiveFib(1000));
    }
}