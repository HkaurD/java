import java.util.*;

public class rps {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        String[] obj = {"r", "p", "s"};
        HashMap<String, String> win = new HashMap<>();
        win.put("p", "r"); win.put("s", "p"); win.put("r", "s");
        String lasttwo = "";

        for(int i = 0; i < t; i++){
            if(lasttwo.length() == 2){
                System.out.println(win.get(lasttwo.substring(0, 1)));
                lasttwo = "";
            }
            else {
                int objtype = (int) (Math.random() * 3);
                System.out.println(obj[objtype]);
                lasttwo += obj[objtype];
                kb.nextLine();
            }
        }
    }
}