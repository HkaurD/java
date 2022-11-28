public class PracTest11 {
    public static void main(String[] args){
        double money = 0, dep = 2000;
        for(int i = 0; i < 20; i++){
            money += dep;
            money *= 1.08;
            dep *= 1.05;
        }
        System.out.printf("You would have $%.2f.\n", money);
    }
}
