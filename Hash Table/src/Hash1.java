import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Hash1 {
    public static int randint(int low, int high){
        int range = high - low + 1;
        return(int)(Math.random() * range + low);
    }
    public static void main(String[] args){
        // pigeonhole principle; there's more strings than integers so hash codes are not unique
        //System.out.println("Harbin Kaur".hashCode());
        HashTab<Integer> nums = new HashTab<Integer>();
        //HashTab<String> names = new HashTab<String>();

//        for(int i = 0; i < 10; i++){
//            nums.add(randint(1, 100));
//        }

        nums.add(73598);
        nums.add(652);
        nums.add(9416);
        nums.add(758);
        nums.add(1953);
        nums.add(84);
        nums.add(9);
        nums.add(68);
        nums.add(42);
        nums.add(134);
        nums.add(443242);

        System.out.println(nums);
        System.out.println(nums.getLoad());

//        int matches = 0;
//        long before = System.nanoTime();
//        for(int i = 0; i < 10000; i++){
//            int n = randint(1, 10000);
//            if(nums.contains(n)){
//                matches++;
//            }
//        }
//
//        long after = System.nanoTime();
//        System.out.println((after - before)/1000000);
//        System.out.println(matches);

//        names.add("Mike");
//        names.add("Ivan");
//        names.add("Denny");
//        names.add("Lena");
//        names.add("Yash");
//        names.add("Luney");
//        System.out.println(names);
    }
}

class HashTab<T>{
    ArrayList<LinkedList<T>> table; // the main hashtable
    private double maxLoad = 0.7; // if the maxLoad is reached, the table is resized; default is 70%
    int elements; // num of elements; different from the table's size

    public HashTab(){
        elements = 0;
        table = new ArrayList<LinkedList<T>>();
        for(int i = 0; i < 10; i++){
            table.add(null); // ten blank spots
        }
    }

    public boolean contains(T v){
        int pos = Math.abs(v.hashCode()) % table.size();
        if(table.get(pos) != null){ // if the linked list contains the value, return true
            return table.get(pos).contains(v);
        }
        return false; // no linked list, or the element is not there
    }

    public void resize(){
        ArrayList<LinkedList<T>> tab = table; // shallow copy
        int newSize = table.size() * 2;
        table = new ArrayList<LinkedList<T>>();

        for(int i = 0; i < newSize; i++){
            table.add(null);
        }
        elements = 0; // since calling add() increases elements, the num of elements start from 0

        for(LinkedList<T> list : tab){
            if(list != null){
                for(T val : list){
                    add(val); // re-adding the values to the resized table
                }
            }
        }
    }

    public void add(T v){ // generic type; can be string, int, etc.
        int pos = Math.abs(v.hashCode()) % table.size();
        if(table.get(pos) == null){
            table.set(pos, new LinkedList<T>());
        }
        table.get(pos).add(v); // adds the element to the front of the linked list
        elements++;
        // resize if load > 70%
        double load = (double)elements/table.size();
        if(load > maxLoad){
            resize();
        }
    }

    public void setMaxLoad(double percent){
        if(0.1 <= percent && percent <= 0.8) {
            maxLoad = percent;
        }
    }

    public void setLoad(double percent){
        if(0.1 <= percent && percent <= 0.8 && percent < maxLoad) {
            maxLoad = percent;
        }
    }

    public void remove(T v){
        int pos = Math.abs(v.hashCode()) % table.size();
        if(table.get(pos).size() > 1){ // if the linked list contains many elements (collisions)
            table.get(pos).remove(v); // removing the value from the linked list in the
        } else if(table.get(pos).size() == 1){ // if the linked list only contains the one element being removed
            table.set(pos, null);
        }
    }

    public T get(int hcode){
        for(LinkedList<T> list : table){
            if(list != null){
                for(T val : list){
                    if(val.hashCode() == hcode){
                        return val;
                    }
                }
            }
        }
        return null;
    }

    public double getLoad(){
        return (double)elements/table.size();
    }

//    public ArrayList<T> toArray(){
//
//    }

    @Override
    public String toString(){
        String ans = "";
        for(LinkedList<T> list : table){
            if(list != null){
                for(T val : list){
                    ans += ", " + val;
                }
            }
        }
        if(!ans.equals("")){
            ans = ans.substring(2);
        }
        return "// " + ans + " \\\\";
    }
}