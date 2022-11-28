import java.util.*;
public class Elevator {
    private int dir, max, floor;
    private int[] calls;

    public static final int STOP = 0, UP = 1, DOWN = -1;
    public Elevator(int mx){
        max = mx;
        floor = 0;
        dir = STOP;
        calls = new int[max + 1];
    }
    // If you want to access private fields, you need some public method
    // If all you want to do is get/set from/to the field you could use getter and setter methods
    // e.g. If I want to have controlled access to floor, I would add getFloor and setFloor
    public int getFloor(){
        return floor;
    }

    public void setFloor(int f){
        floor = f;
    }

    public void request(int f1){
        calls[f1] ++;
    }

    private boolean callsUp(){
        for(int f = floor + 1; f <= max; f++){
            if(calls[f] > 0){
                return true;
            }
        }
        return false;
    }

    private boolean callsDown(){
        for(int f = floor - 1; f >= 0; f--){
            if(calls[f] > 0){
                return true;
            }
        }
        return false;
    }

    public void move(){
        if(calls[floor] > 0){
            calls[floor] = 0;
        }
        else {
            if (!callsUp() && !callsDown()) {
                dir = STOP;
            } else if (!callsUp() && callsDown()) {
                dir = DOWN;
            } else if (callsUp() && !callsDown()) {
                dir = UP;
            }
            // last case is calls in both directions, keep going in the same direction
            floor += dir;
        }
    }
    public void display(){
        System.out.println(Arrays.toString(calls));
        System.out.printf("%" + (floor * 3 + 2) + "s\n", "E");
    }
}