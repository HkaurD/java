import java.awt.*;

public class ArrayEx3 {
    public static int randint(int low, int high){
        return (int)(Math.random() * (high - low + 1) + low);
    }

    public static void main(String[] args){
        Point[] trees = new Point[10];
        boolean clear = false;
        while(clear == false) {
            for (int tree = 0; tree < 10; tree++) {
                trees[tree] = new Point(randint(0, 29), randint(0, 29));
            }
            clear = true;
            for(int i = 0; i < 10; i++){
                for(int j = i + 1; j < 10; j++){
                    double dist = trees[i].distance(trees[j]);
                    if(dist < 3){
                        clear = false;
                    }
                }
            }
        }
        int[][] yard = new int[30][30];
        for(int tree = 0; tree < 10; tree++) {
            System.out.printf("%3d%3d\n", trees[tree].x, trees[tree].y);
            yard[trees[tree].x][trees[tree].y] = 1;
        }
        for(int i = 0; i < 30; i++){                                 // !a       ,     a++ -----> unary operator
            for(int j = 0; j < 30; j++){                             // a + b    ,   c < b -----> binary operator
                char c = yard[i][j] == 1 ? '*' : ' ';                // c ? t : f          -----> ternary operator
                System.out.print(c + " ");                           //     t, if c is true
            }                                                        //     f, is c is false
            System.out.println();
        }
        /* char c = yard[i][j] == 1 ? '*' : ' ';
        same as...
        char c =;
        if(yard[i][j] == 1){
            c = '*';
        }
        else{
            c = ' ';
        }
         */
    }
}
