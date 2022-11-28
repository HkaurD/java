import java.util.*;

public class Copies {
    static int numCopies, x, y;

    static int f(int t){ // num of copies made by both copiers in t secs
        return (t/x + t/y); // 0 <= t <= 10^9
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        numCopies = kb.nextInt(); x = kb.nextInt(); y = kb.nextInt();
        int lo = 0; int high = 5 * numCopies;
        int ans = 0; // min time needed to print n - 1 copies

        while(lo <= high){
            int mid = lo + (high - lo)/2;
            if(f(mid) >= numCopies - 1){
                ans = mid;
                high = mid - 1; // try to use less time

            } else if(f(mid) < numCopies - 1){
                lo = mid + 1; // use more time
            }
        }
        System.out.println(ans + Math.min(x, y));
    }
}