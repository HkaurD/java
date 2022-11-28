import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        HashMap<String, ArrayList<String>> together = new HashMap<>();
        HashMap<String, ArrayList<String>> sep = new HashMap<>();
        HashMap<String, ArrayList<String>> groups = new HashMap<>();

        int x = kb.nextInt();
        kb.nextLine();
        for(int i = 0; i < x; i++){
            String[] names = kb.nextLine().split(" ");
            if(together.get(names[0]) == null) {
                ArrayList<String> pair = new ArrayList<>();
                pair.add(names[1]);
                together.put(names[0], pair); // these two must be together
            } else{
                together.get(names[0]).add(names[1]);
            }
        }

        int y = kb.nextInt();
        kb.nextLine();
        for(int i = 0; i < y; i++){
            String[] names = kb.nextLine().split(" ");
            if(sep.get(names[0]) == null) {
                ArrayList<String> pair2 = new ArrayList<>();
                pair2.add(names[1]);
                sep.put(names[0], pair2); // these two must be together
            } else{
                sep.get(names[0]).add(names[1]);
            }
        }

        int ans = 0; // num of violations
        int g = kb.nextInt();
        kb.nextLine();

        for(int i = 0; i < g; i++){ // the num of groups
            String[] names = kb.nextLine().split(" ");

            ArrayList<String> gr = new ArrayList<>();
            gr.add(names[1]); gr.add(names[2]);
            groups.put(names[0], gr);

            ArrayList<String> gr2 = new ArrayList<>();
            gr2.add(names[0]); gr2.add(names[2]);
            groups.put(names[1], gr2);

            ArrayList<String> gr3 = new ArrayList<>();
            gr3.add(names[0]); gr3.add(names[1]);
            groups.put(names[2], gr3);
        }

        for (String key : together.keySet()) { // looping through all the pairs that must be together
            for (String pair : together.get(key)) { // looping through the partners arraylist
                if (!groups.get(key).contains(pair)) { // if the partner is not in the group, it's a violation
                    ans++;
                }
            }
        }

        for (String key : sep.keySet()) {
            for (String pair : sep.get(key)) {
                if (groups.get(key).contains(pair)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}