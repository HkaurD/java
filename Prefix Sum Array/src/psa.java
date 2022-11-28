import java.util.*;

public class psa {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // num of values - length of the array
        int q = kb.nextInt(); // the num of queries

        int[] arr = new int[n + 1];
        int[] psa = new int[n + 1]; // prefix sum array

        for(int i = 1; i <= n; i++){
            arr[i] = kb.nextInt(); // storing the array's contents
        }
        for(int i = 1; i <= n; i++){
            psa[i] = psa[i - 1] + arr[i];
        }
        for(int i = 0; i < q; i++){
            int start = kb.nextInt(), end = kb.nextInt();
            System.out.println(psa[end] - psa[start - 1]); // taking the sum of all the elements up to the end, and then subtracting the sum of the elements before the start
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(psa));

    }
}

// 8 4
// 3 2 4 5 1 1 5 3
// 2 4
// 5 6
// 1 8
// 3 3