import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        int n, k, curr;
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        k = kb.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }

        for(int i = 0; i < k; i++) {
            curr = kb.nextInt();
            boolean found = false;
            int low = 0, high = n - 1;

            while(low <= high){
                //int mid = (low + high) / 2;
                int mid = low + (high - low) / 2;

                if (arr[mid] == curr) {
                    found = true;
                    break;
                }
                else if(arr[mid] > curr){
                    high = mid - 1;
                }
                else if(arr[mid] < curr){
                    low = mid + 1;
                }
            }
            if(found){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}

// 10 10
// 1 61 126 217 2876 6127 39162 98126 712687 1000000000
// 100 6127 1 61 200 -10000 1 217 10000 1000000000