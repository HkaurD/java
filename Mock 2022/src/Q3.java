import java.util.*;

public class Q3 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Integer> read = new ArrayList<Integer>(); // the readings
        ArrayList<Integer> fbiggest = new ArrayList<Integer>(); // the largest frequencies of elements
        ArrayList<Integer> sbiggest = new ArrayList<Integer>(); // the smallest frequencies of elements

        HashMap<Integer, Integer> freq = new HashMap<>(); // the frequency of each distinct reading

        for(int i = 0; i < n; i++){
            read.add(0);
        }

        for(int i = 0; i < n; i++){
            read.set(i, kb.nextInt());
        }

        Set<Integer> s = new HashSet<>(read); // taking the unique elements
        for(int x : s){
            freq.put(x, Collections.frequency(read, x)); // each element key has a value of its frequency
        }
        ArrayList<Integer> vals = new ArrayList<>(freq.values());
        Collections.sort(vals); // sorting the frequencies from smalelst to largest

        for(int key : freq.keySet()){
            if(freq.get(key).equals(vals.get(vals.size() - 1))){ // if the element has the highest frequency
                fbiggest.add(key); // one of the biggest frequencies
            } else if(freq.get(key).equals(vals.get(vals.size() - 2))){ // if the element has the second highest frequency
                sbiggest.add(key);
            }
        }
        Collections.sort(fbiggest);
        Collections.sort(sbiggest);
        if(fbiggest.size() > 1){ // more than one frequency elements; have to find the largest absolute difference
            System.out.println(fbiggest.get(fbiggest.size() - 1) - fbiggest.get(0));
        } else{
            int ans = 0;
            for(int f : sbiggest){
                ans = Math.max(Math.abs(fbiggest.get(0) - f), ans);
            }
            System.out.println(ans);
        }
    }
}