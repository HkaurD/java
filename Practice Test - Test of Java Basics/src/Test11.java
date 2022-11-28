public class Test11 {
    public static void main(String[] args){
        double money = 1000000;
        int numOfYears = 0;

        while (money > 80000){
            money -= 80000;
            numOfYears ++;
            money *= 1.03;
        }
        System.out.printf("Your money lasts %d years.", numOfYears);
    }
}


