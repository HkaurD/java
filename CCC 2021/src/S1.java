import java.util.*;
public class S1 {
    static int[] heights = new int[10005];
    static int[] widths = new int[10005];
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i = 0; i < n + 1; i++){
            heights[i] = kb.nextInt();
        }
        for(int i = 0; i < n; i++){
            widths[i] = kb.nextInt();
        }
        double ans = 0;
        for(int i = 1; i <= n; i++){
            ans += (double)(heights[i] + heights[i - 1]) * (double)widths[i - 1]/2;
        }
        System.out.println(ans);
//        System.out.println(BigDecimal.valueOf(ans)
//                .setScale(3, RoundingMode.HALF_UP)
//                .doubleValue());
    }
}