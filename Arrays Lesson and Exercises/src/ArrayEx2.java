import java.util.*;

public class ArrayEx2 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        // We watched Friday night lights last Wednesday, it was pretty good.
        System.out.println("Enter a line: ");
        String line = keyboard.nextLine();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "~?~?"};

        for(int i = 6; i >= 0; i--){
            line = line.replace(days[i], days[i + 1]);
        }
        line = line.replace(days[7], days[0]);
        System.out.println(line);
    }
}