/*
ArrayList is part of the Java Collection Framework. It is a collection. Other common collections are:
    - TreeSet
    - HashSet
    - LinkedList
    - HashMap
    - TreeMap
    There are a set of methods that all of these collections can use.
 */
import java.util.*;

public class ArrayList1 {
    public static void main(String[] args){
        /*ArrayList nums = new ArrayList<>();
        // ALL THESE ADDED ELEMENTS ARE OBJECTS; cannot add objects
        nums.add(12);
        nums.add(132);
        nums.add(512);
        nums.add(127);
        nums.add("Dog");
        nums.set(1, 33);
        System.out.println(nums);
        System.out.println(nums.get(0));*/
        ArrayList<Integer> nums = new ArrayList<Integer>();
        // ALL THESE ADDED ELEMENTS ARE PRIMITIVE TYPES
        nums.add(12); // Autoboxing - automatically converts from primitive to wrapper
        nums.add(132);
        nums.add(512);
        nums.add(127);
        //                 unboxing
        System.out.println(nums.get(0) + nums.get(2));
        // Collections.sort(nums);
    }
}
