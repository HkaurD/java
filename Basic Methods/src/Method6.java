// Method6
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
/* This method takes in a two-dimensional array which represents the 8 by 8 grid from the top left corner, (0, 0) to the
 bottom right corner, (7, 7). The elements in the array are the time it takes to reach that "square" or coordinate. This
 program involves two methods, the first one takes in the grid and calls the second method with specific parameters like
 the x-coordinate and y-coordinate, and the second method recursively creates all possible paths from the top left to the
 bottom right coordinate with the directions and total time it takes. The path with the least amount of time is printed.
 */

public class Method6 {
    static int bestTime = 1001; // this will hold the best time; the question says to assume that it always takes a max of 1000 seconds
    static String bestPath = ""; // this will contain directions of the best path
    static void fastPath(int[][] grid){
        fastPath(grid, "", 0, 0, 0); // calling the second method containing the recursion
    }
    static void fastPath(int[][] grid, String dir, int xcoor, int ycoor, int time){
        if(xcoor == 7 && ycoor == 7){ // the base case is when the path is at the end, point (7, 7)
            if(time < bestTime){
                // these values constantly change until the best time and path are found
                bestTime = time;
                bestPath = dir;
            }
        }
        else{
            if(xcoor == 7) { // if the path has turned right 7 times, it can only go down
                fastPath(grid, dir + "D", xcoor, ycoor + 1, time + grid[xcoor][ycoor + 1]);
            }
            else if(ycoor == 7){ // if the path has went down 7 times, it can only go right
                fastPath(grid, dir + "R", xcoor + 1, ycoor, time + grid[xcoor + 1][ycoor]);
            }
            else{ // making two new paths containing both down and right respectively
                fastPath(grid, dir + "D", xcoor, ycoor + 1, time + grid[xcoor][ycoor + 1]);
                fastPath(grid, dir +"R", xcoor + 1, ycoor, time + grid[xcoor + 1][ycoor]);
            }
        }
        if(xcoor == 0 && ycoor == 0){// since recursion stacks back to the beginning, point (0, 0), this prints the
                                     // best time and path after the recursive program
            System.out.println(bestTime + "\n" + bestPath);
        }
    }
    public static void main(String[] args){
        int[][] grid =
                {{ 0,21,20, 5,25,25,35,15},
                {12,26,43,29,15,26,15,12},
                { 7,18,23,28,36,32,12,18},
                {43,34,35,18,25,18,21,25},
                {32,41,23, 9,21,17,24,14},
                {12, 9,20,42, 9,19,26,22},
                {30,17,17,35,14,25,14,21},
                {15,21,37,24,19,15,35,15}};
        fastPath(grid);
    }
}