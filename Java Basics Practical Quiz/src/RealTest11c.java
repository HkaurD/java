import java.util.*;
public class RealTest11c {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many can you do now?");
        int pushups = keyboard.nextInt();
        System.out.println("What is your goal?");
        int goal = keyboard.nextInt();

        int randIncrease;
        int day = 1;
        while (pushups < goal){
            randIncrease = (int)(Math.random()*5 + 1);
            if(pushups + randIncrease < goal) {
                pushups += randIncrease;
                System.out.println("Day " + day + ": " + pushups);
                day++;
            }
            else{
                System.out.println("Day " + day + ": " + goal);
                break;
            }
        }
    }
}
