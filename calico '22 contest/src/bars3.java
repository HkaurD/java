import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class bars3 {
    static long quad(int a, int b, BigInteger c){
        double descrim = Math.pow(b, 2) - c.longValue() * 4 * a;
        long ans = 0;
        if(descrim >= 0){
            ans = (long) Math.floor((-b + Math.sqrt(descrim))/(2*a));
        }
        return ans;
    }

    public static void main(String[] args){
       Scanner kb = new Scanner(System.in);
       int t = kb.nextInt();
        for(int i = 0; i < t; i++){
            BigInteger n = kb.nextBigInteger();
            n = n.multiply(BigInteger.TWO);
            long ans = quad(1, 1, n.negate());
            System.out.println(ans);
        }
    }
}
