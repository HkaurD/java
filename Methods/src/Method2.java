import java.util.*;
import java.awt.*;

public class Method2 {
    // All parameters in Java are "Call by Value"
    // This means that changing the parameter has no effect on the argument you passed in.
    static void add(int x){
        x += 10;
    }

    static void add(int[] x){
        for(int i = 0; i < x.length; i++){
            x[i] += 10;
        }
    }

    static void clear(int[] x){
        x = new int[x.length];
    }

    static void move(Point p){
        p.x += 100;
    }

    static void doctorfy(String name){
        name = "Dr. " + name;
        System.out.println(name); // DOES print Dr. + name
    }

    public static void main(String[] args){
        int a = 20;
        add(a);
        System.out.println(a); // stays as 20, doesn't change

        int[] nums = {1, 2, 3};
        add(nums);
        System.out.println(Arrays.toString(nums)); // changes

        clear(nums);
        System.out.println(Arrays.toString(nums));

        Point pt = new Point(10, 50);
        move(pt);
        System.out.println(pt);

        String name = "Avnoor";
        doctorfy(name);
        System.out.println(name); // DOES NOT print Dr. + name
    }
}
