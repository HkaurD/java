import java.util.*;

/*
2 approaches
1. stimulate each balloon going along the cells, checking each tower at each cell
2. calculating the damage a balloon will take by going to each cell, then checking how far each ballon would make it

the second approach is easier to optimize
lets break it down into 2 parts
1. calculating the damage dealt in each cell by the towers
2. calculating how far each balloon can go without dying

since each tower deals a certain amount of damage to a range of cells, we can see that this
part can be reduced to range increments. we use difference arrays to do this in O(1) for each tower, resulting in O(n)

now that we know the damage a balloon will receive in each cell, how can we find out how far it will go in sublinear time?
 */

public class bloonattack {
    static final int nax = (int)1e3 + 5;
    public static int numCells, numTowers, cell, range, dmg, numBloons, health;
    public static int[] diffarr = new int[nax];
    public static int[] psa = new int[nax];

    static void solve(){
        Arrays.fill(diffarr, 0); // re-setting the array to zeros for the next test case
        Scanner kb = new Scanner(System.in);
        numCells = kb.nextInt(); numTowers = kb.nextInt();

        for(int i = 1; i <= numTowers; i++){
            cell = kb.nextInt(); range = kb.nextInt(); dmg = kb.nextInt();
            // the range over which the damage extends
            diffarr[Math.max(1, cell - range)] += dmg; // first cell is 1; the damage range can't go to the negatives
            diffarr[Math.min(numCells, cell + range) + 1] -= dmg; // the damage range can't go greater than the number of cells
        }

        for(int i = 1; i <= numCells; i++){
            psa[i] = psa[i - 1] + diffarr[i];
        }

        numBloons = kb.nextInt();
        for(int i = 0; i < numBloons; i++){
            health = kb.nextInt();
            int lo = 0, high = numCells, ans = 0;
            while(lo <= high){
                int mid = lo + (high - lo)/2;
                if(psa[mid] < health){ // can sustain, try to find more damage
                    lo = mid + 1;
                    ans = mid;
                } else if(psa[mid] >= health){ // too much damage, try to find less greater damage
                    high = mid - 1;
                }
            }
            if(ans == numCells && health > psa[numCells]){
                System.out.println("Bloon leakage"); // made it to the end
            } else{
                System.out.println(ans + 1); // the cell where the bloon died
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // num of test scenarios

        for(int i = 0; i < t; t++){
            solve();
        }
    }
}