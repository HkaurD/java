import java.util.*;

public class Test12 {
    static int asInt(String day){
        int d = Integer.parseInt(day.substring(0, 2));
        int m = Integer.parseInt(day.substring(3));

        int[] len = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 0; i < m - 1; i++){
            d += len[i];
        }
        return d;
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter dd/mm");
        String d1 = keyboard.next();
        System.out.println("Enter dd/mm");
        String d2 = keyboard.next();

        int bet = Math.abs(asInt(d1) - asInt(d2));
        System.out.println("Days between: " + bet);
    }
}

/*
public class Test12 {
    public static void main(String[] args){
        int[] dayInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the first date: ");// dd/mm
        String[] startDate = keyboard.next().split("/"); // [dd, mm]

        System.out.println("Enter the second date: ");
        String[] endDate = keyboard.next().split("/");

        if(startDate[1] != endDate[1]){
            if(Integer.parseInt(startDate[1]) > Integer.parseInt(endDate[1])){
                String[] temp = startDate;
                startDate = endDate;
                endDate = temp;
            }
        }
        else{
            if(Integer.parseInt(startDate[0]) > Integer.parseInt(endDate[0])) {
                String[] temp = startDate;
                startDate = endDate;
                endDate = temp;
            }
        }
        int startDay = Integer.parseInt(startDate[0]);
        int endDay = Integer.parseInt(endDate[0]);;

        for(int i = 0; i < Integer.parseInt(startDate[1]) - 1; i++){
            startDay += dayInMonths[i];
        }
        for(int j = 0; j < Integer.parseInt(endDate[1]) - 1; j++){
            endDay += dayInMonths[j];
        }
        System.out.println(endDay - startDay);
    }
}
 */