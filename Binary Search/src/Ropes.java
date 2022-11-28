import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Ropes {
    static double[] lengths = new double[10005]; // the number of lengths of ropes is less than 10000
    static int n, k; // n = num of ropes, k = num of pieces to cut

    static int f(double length){
        int ropecnt = 0;
        for(int i = 1; i <= n; i++){
            ropecnt += Math.floor(lengths[i] / length); // since it's int division, the answer is automatically floored
        }
        return ropecnt;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); k = kb.nextInt();
        for(int i = 1; i <= n; i++){
            lengths[i] = kb.nextInt(); // taking in the length of rope_i into the array of lengths
        }
        double lo = 0, high = 1e7;
        while(high - lo >= 1e-7){ // to make the answer VERY close to the whole double answer (accurate to 10^7)
            double mid = lo + (high - lo)/2;
            if(f(mid) >= k){
                // we can cut more than k ropes of length l, try cutting longer lengths (l)
                lo = mid; // searching through reals, not ints
            } else if(f(mid) < k){
                // we cannot cut k ropes of length mid, try cutting shorter ropes
                high = mid;
            }
        }
        System.out.println(BigDecimal.valueOf(lo).setScale(10, RoundingMode.HALF_UP).doubleValue());
    }
}