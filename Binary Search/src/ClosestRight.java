import java.util.*;

public class ClosestRight {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // array length
        int k = kb.nextInt(); // num of queries

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }

        for(int i = 0; i < k; i++){
            int curr = kb.nextInt();
            int minInd = n;
            int low = 0, high = n - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(arr[mid] >= curr){
                    minInd = mid; // store the current lowest index
                    high = mid - 1; // looking for a small index
                }
                else if(arr[mid] < curr){ // since the current middle element is less than the one being found, look towards the right
                    low = mid + 1;
                }
            }
            System.out.println(minInd + 1);
        }
    }
}

// 5 5
// 3 3 5 8 9
// 2 4 8 1 10