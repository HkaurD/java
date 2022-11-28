// CheckersBoard (class)
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This class is used to play a game of checkers with red pieces at the top and black at the bottom.
class CheckersBoard{
    // stores the initial board in checkers
    private int board[][] =
                    {{2, 0, 2, 0, 0, 0, 1, 0},
                    {0, 2, 0, 0, 0, 1, 0, 1},
                    {2, 0, 2, 0, 0, 0, 1, 0},
                    {0, 2, 0, 0, 0, 1, 0, 1},
                    {2, 0, 2, 0, 0, 0, 1, 0},
                    {0, 2, 0, 0, 0, 1, 0, 1},
                    {2, 0, 2, 0, 0, 0, 1, 0},
                    {0, 2, 0, 0, 0, 1, 0, 1}};
    public static final int OPEN = 0; // empty squares
    public static final int BLACK = 1; // black pieces
    public static final int RED = 2; // red pieces

    /*
    This recursive method is used in the move method for capture moves or jumps.
    x1, y1 represents the piece to be moved, x2, y2 is where the user wants to move the piece,
    dir is the direction since red pieces go down(1) and black go up(-1). other is the opposite piece
    of the one to be moved and path stores the coordinates of the pieces that are captured.
    This method returns the path and an empty String if the move is not possible.
     */
    private String jumpCapt(int x1, int y1, int x2, int y2, int dir, int other, String path){
        String leftPath = "";
        String rightPath = "";
        if(x1 == x2 && y1 == y2){ // base case -> the initial piece reaches the new spot
            return path;
        }
        else{
            boolean left = false, right = false;
            // these two if statements check if a left or right path from the original square is possible
            if(board[x1 + 1][y1 + dir] == other && get(x1 + 2,y1 + dir * 2) == OPEN) {
                String p = ""+(x1 + 1) + (y1 + dir); // adding the coordinate of the piece that is captured to the path
                rightPath = jumpCapt(x1 + 2, y1 + dir * 2, x2, y2, dir, other, path + p);
                right = !rightPath.equals(""); // returns true if there is a valid path
            }
            if(board[x1 - 1][y1 + dir] == other && get(x1 - 2, y1 + dir * 2) == OPEN){
                String p = ""+(x1 - 1) + (y1 + dir);
                leftPath = jumpCapt(x1 - 2, y1 + dir * 2, x2, y2, dir, other, path+p);
                left = !leftPath.equals("");
            }
            // if a right or left path is possible
            if(right){
                return rightPath; // recursively finding the next square to jump to
            }
            else if(left) {
                return leftPath;
            }
            else{
                return ""; // an empty String means that there is no path from x1, y1 to x2, y2
            }
        }
    }

    /*
    This method is used to move a piece from x1, y1 to x2 to y2.
    It returns true if the move is valid and the pieces are moved on the board.
     */
    public boolean move(int x1, int y1, int x2, int y2){
        // if the inital spot is empty, if the destination square is off the board or is not empty or if the move is to the same square, invalid move
        if(board[x1][y1] == OPEN || x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7 || board[x2][y2] != OPEN || x1 == x2 && y1 == y2){
            return false;
        }
        else{
            int myColour = board[x1][y1];
            int other = BLACK + RED - myColour;
            int direct = myColour == BLACK ? -1: 1; // since black pieces must move up and red must move down
            // the basic move; moving to a left or right diagonally empty square
            if((x2 == x1 - 1 || x2 == x1 + 1) && y2 == y1 + direct){
                // "moving" or changing the pieces
                board[x2][y2] = board[x1][y1];
                board[x1][y1] = OPEN;
                return true;
            }
            // the capture move
            else if(y2 >= y1 + direct * 2 || y2 <= y1 + direct * 2){ // it goes either up or down more than two squares
                String ans =  jumpCapt(x1, y1, x2, y2, direct, other, "");
                if(!ans.equals("")){ // if there is a valid path
                    for(int i = 1; i < ans.length(); i += 2){
                        // killing each captured piece in the path
                        board[Integer.parseInt(""+ans.charAt(i - 1))][Integer.parseInt(""+ans.charAt(i))] = OPEN;
                    }
                    // moving the initial piece to the destination
                    board[x2][y2] = board[x1][y1];
                    board[x1][y1] = OPEN;
                    return true;
                }
            }
        }
        return false;
    }

    /*
    This method is used to get the value of coordinates (x,y) on the checkers board
    If point (x, y) is off the board, it returns -1, else it returns the value at (x, y)
     */
    public int get(int x, int y){
        if(x<0 || x>7 || y<0 || y>7){
            return -1;
        }
        return board[x][y];
    }

    /*
    This method is used to count the number of the inputted pieces on the board.
    colour is the inputted piece colour; BLACK = 1 and RED = 2
    This method returns the count of the coloured piece
     */
    public int count(int colour){
        int countCol = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == colour) {
                    countCol++;
                }
            }
        }
        return countCol;
    }

    /*
    This method is used to display an ASCII version of the checkers board.
    R = Red pieces and B = Black pieces
     */
    public void display() {
        for(int i = 0; i < board.length; i++){
            System.out.println("+-+-+-+-+-+-+-+-+");
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == RED){ // this is transposed so the pieces are the top and bottom
                    System.out.print("|R");
                }
                else if(board[j][i] == BLACK){
                    System.out.print("|B");
                }
                else{
                    System.out.print("| ");
                }
                if(j == board.length - 1){
                    System.out.print("|\n");
                }
            }
        }
        System.out.println("+-+-+-+-+-+-+-+-+");
    }
}