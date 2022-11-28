import java.util.*;

public class COS1 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int numOfMarks = keyboard.nextInt();
        int[] intMarks = new int[numOfMarks];
        String diffMarks = "";

        keyboard.nextLine();

        String[] marks = keyboard.nextLine().split(" ");

        for(int i = 0; i < marks.length; i++){
            intMarks[i] = Integer.parseInt(marks[i]);
        }

        Arrays.sort(intMarks);

        if(intMarks[0] == intMarks[intMarks.length - 1] || intMarks.length == 1){
            System.out.println(-1);
        }
        else{
            for(int mark : intMarks){
                if(!diffMarks.contains(String.valueOf(mark))){
                    diffMarks += String.valueOf(mark) + ",";
                }
            }
            String[] diffMarkArr = diffMarks.split(",");
            System.out.println(intMarks[intMarks.length - 2]);
        }
    }
}
