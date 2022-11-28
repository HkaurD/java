import java.util.*;

public class ClosestLeft {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // length of array
        int k = kb.nextInt(); // num of queries

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }

        for(int i = 0; i < k; i++){
            int curr = kb.nextInt();
            int low = 0, high = n-1;
            int maxInd = -1;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(arr[mid] <= curr){
                    maxInd =  mid;
                    low = mid + 1;
                }
                else if(arr[mid] > curr){
                    high = mid - 1;
                }
            }
            System.out.println(maxInd + 1);
        }
    }
}

// 5 5
// 3 3 5 8 9
// 2 4 8 1 10