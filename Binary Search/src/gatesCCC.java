import java.util.*;

// ccc 2015 senior 3
public class gatesCCC {
    public static void main(String[] args){
        TreeSet<Integer> gates = new TreeSet<Integer>();
        Scanner kb = new Scanner(System.in);
        int g = kb.nextInt(); // num of gates
        int ans = 0; // the num of planes that dock at the airport

        for(int i = 1; i <= g; i++){
            gates.add(i); // storing the gates consecutively in the tree set
        }

        int p = kb.nextInt(); // num of planes that will land
        for(int i = 0; i < p; i++){
            int gate = kb.nextInt(); // need to dock the plane between gates 1 to the inputted integer
            // floor - Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
            if(gates.floor(gate) == null){ // if there is no possible docking gate, close the airport
                break;
            } else {
                gates.remove(gates.floor(gate));
                ans++;
            }
        }

        System.out.println(ans);
    }
}