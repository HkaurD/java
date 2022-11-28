import java.util.*;

public class library {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt(); // test cases
        kb.nextLine();

        for(int i = 0; i < t; i++){
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> owners = new ArrayList<>();
            String absent = kb.next();
            int numreturns = kb.nextInt();
            kb.nextLine();
            names.add(absent);
            for(int j = 0; j < numreturns; j++){
                String[] turnin = kb.nextLine().split(" ");
                names.add(turnin[0]);
                owners.add(turnin[3].substring(0, turnin[3].length() - 2));
            }
            for (String name : names) {
                if (!owners.contains(name)) {
                    System.out.println(absent + " HAS " + name + "'s BOOK");
                    break;
                }
            }
        }
    }
}