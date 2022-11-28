import java.util.*;

public class PracTest12 {

    static int match(String n1, String n2){
        int score = 0;
        if(n1.charAt(0) == n2.charAt(0)){
            score += 4;
        }
        for(char c1 : n1.toCharArray()){
            for(char c2 : n2.toCharArray()){
                if(c1 == c2){
                    score++;
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[] names = new String[5];
        for(int i = 0; i < 5; i++){
            System.out.println("Enter name: ");
            names[i] = keyboard.nextLine();
        }
        for(String n1 : names){
            for(String n2 : names){
                if(n1 != n2) { // do not use .equals() since if two people have the same, they are not necessarily the same person
                    int score = match(n1, n2);
                    System.out.printf("%-15s%2d\n", n1 + ", " + n2, score);
                }
            }
        }
    }
}

/*
public class PracTest12 {
    public static void main(String[] args) {
        int points = 0;
        Scanner keyboard = new Scanner(System.in);
        String[] names = new String[5];
        String[] pairs = new String[20];
        System.out.println("Enter five names: ");

        for (int i = 0; i < 5; i++) {
            names[i] = keyboard.nextLine();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                if(names[i] != names[j]) {
                    if (("" + names[i].charAt(0)).equals("" + names[j].charAt(0))) {
                        points += 5;
                    }
                    if(points == 5) {
                        for (char lett : names[i].substring(1).toCharArray()) {
                            for(char lett2 : names[j].toCharArray()){
                                if ((""+lett).equals(""+lett2)) {
                                    points++;
                                }
                            }
                        }
                    }
                    else{
                        for (char lett : names[i].toCharArray()) {
                            for(char lett2 : names[j].toCharArray()){
                                if ((""+lett).equals(""+lett2)) {
                                    points++;
                                }
                            }
                        }
                    }
                    System.out.println(names[i] + " " + names[j] + "               " + points);
                    points = 0;
                }
            }
        }
    }
}

 */
