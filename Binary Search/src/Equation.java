import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

// f(x) = x^2 + sqrt(x)
// f(x) >= f(y) for all x >= y >= 0
// monotonic function : non-decreasing
public class Equation {
    static double eqn(double x){
        return x * x + Math.sqrt(x);
    }
    public static void main(String[] args){
        double c;
        Scanner kb = new Scanner(System.in);
        c = kb.nextDouble();
        double lo = 0; double high = 1e5; // when x = 10^5, eqn(x) will be greater than c; max value

        while(high - lo >= 1e-7){
            double mid = lo + (high - lo)/2;
            if(eqn(mid) > c){
                high = mid;
            } else if(eqn(mid) < c){
                lo = mid;
            }
        }

        // high - lo < 10^7
        System.out.println(BigDecimal.valueOf(lo).setScale(8, RoundingMode.HALF_UP).doubleValue()); // printing the answer to 8 decimal places, rounded up
    }
}