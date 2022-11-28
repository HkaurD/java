import java.util.*;

public class car {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();

        String[] speedanddist;
        for(int i = 0; i < t; i++){
            speedanddist = kb.next().split(":");
            double v = Double.parseDouble(speedanddist[0]);
            double x = Double.parseDouble(speedanddist[1]);
            double time = x/v;

            if(time <= 1){
                System.out.println("SWERVE");
            } else if(time <= 5){
                System.out.println("BRAKE");
            } else{
                System.out.println("SAFE");
            }
        }
    }
}
