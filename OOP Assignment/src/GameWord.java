// GameWord (class)
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This class is used in a game of Scrabble. This does not allow the user to play the full game though it includes code
// that would be used in the whole game.
import java.util.*;

class GameWord{
    private String contents; // this variable stores the word inputted by the user when using this class
    // these variables represent whether the contents is placed to the right or down on the Scrabble board
    public static final int RIGHT = 1;
    public static final int DOWN = 2;

    // what to multiply each letter value of contents by
    private static final int gridLettScore[][] =
                        {{1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1},
                        {2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1},
                        {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1},
                        {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
                        {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1},
                        {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2},
                        {1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1}};

    // what to multiply each word value of contents by
    private static final int gridWordScore[][] =
                    {{3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3},
                    {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1},
                    {1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1},
                    {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
                    {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {3, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
                    {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
                    {1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1},
                    {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1},
                    {3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3}};

    // used to find the point for each letter in contents
    private static final String point1 = "EAIONRTLSU";
    private static final String point2 = "DG";
    private static final String point3 = "BCMP";
    private static final String point4 = "FHVWY";
    private static final String point5 = "K";
    private static final String point8 = "JX";
    private static final String point10 = "QZ";

    // GameWord constructor - takes in the word from the user
    public GameWord(String content){
        contents = content.toUpperCase();
    }

    // This method is used to reverse, or return contents backwards. A string with contents reversed is returned.
    public String reverse(){
        String reverseStr = "";
        for(int i = 0; i < contents.length(); i++){
            reverseStr += ""+contents.charAt(contents.length() - i - 1); // looping through contents and adding its letters from the end to the start
        }
        return reverseStr;
    }

    /*
    This method is used to check if another inputted word and contents are equal if their letters are rearranged.
    otherWord is an inputted String that is compared to contents.
    If contents and otherWord can be re-written to be the same String, this method returns true or else it returns false.
     */
    public boolean anagram(String otherWord){
        char[] otherWordLetts = otherWord.toUpperCase().toCharArray();
        char[] contentsLetts = contents.toCharArray();
        // both the letters from contents and otherWord are sorted so that they can be compared
        Arrays.sort(otherWordLetts);
        Arrays.sort(contentsLetts);
        if(Arrays.equals(contentsLetts, otherWordLetts)){
            return true;
        }
        return false;
    }

    /*
    This overloads the above anagram method so that it also takes in a GameWord to compare to contents.
    otherWord is an inputted GameWord.
     */
    public boolean anagram(GameWord otherWord){
        String word2 = otherWord.toString();
        return anagram(word2); // An inputted GameWord converted to String can be compared to contents using the first anagram method.
    }

    /*
    This method is used to find the number of points contents is worth in Scrabble.
    x and y are the coordinates of the first letter of contents on the Scrabble board.
    dir takes in the direction that contents is placed in on the board. From the initialized constants, RIGHT and DOWN are 1 and 2 respectively.
    This method returns the total point value of contents.
     */
    public int pointValue(int x, int y, int dir){
        int[] lettPts = new int[contents.length()]; // each index in this array corresponds to a letter in contents; used to evaluate letter scores.
        int point = 0;
        int pointTimesWord = 1;

        for(int i = 0; i < contents.length(); i++){
            // setting the indexes corresponding to each letter in word to their base value
            if(point1.contains(""+contents.charAt(i))){
                lettPts[i] += 1;
            }
            else if(point2.contains(""+contents.charAt(i))){
                lettPts[i] += 2;
            }
            else if(point3.contains(""+contents.charAt(i))){
                lettPts[i] += 3;
            }
            else if(point4.contains(""+contents.charAt(i))){
                lettPts[i] += 4;
            }
            else if(point5.contains(""+contents.charAt(i))){
                lettPts[i] += 5;
            }
            else if(point8.contains(""+contents.charAt(i))){
                lettPts[i] += 8;
            }
            else if(point10.contains(""+contents.charAt(i))){
                lettPts[i] += 10;
            }
            if(dir == RIGHT){
                lettPts[i] *= gridLettScore[x + i][y]; // multiplying each letter score from the Scrabble board
                pointTimesWord *= gridWordScore[x + i][y];// multiplying each word score from the Scrabble board
            }
            else if(dir == DOWN){
                lettPts[i] *= gridLettScore[x][y + i];
                pointTimesWord *= gridWordScore[x][y + i];
            }
        }
        for(int pt : lettPts){
            point += pt;
        }
        return point * pointTimesWord; // returning the sum of all the letter points times the total word score
    }

    /*
    This method is used to find all the permutations or arrangements of contents.
    When permutations is called, it calls the recursive function perms() to find all possible arrangements
    permutations() returns an ArrayList with all the variations
     */
    public ArrayList<String> permutations(){
        ArrayList<String> permuteList = new ArrayList<>();
        perms("", contents, permuteList);
        return permuteList; // when perms() is done, the answer is returned from this initial method
    }
    /*
    ans represents an empty String that is used in the build-up of each permutation of contents
    left takes in contents and removes each letter already added to and and permuteList is the ArrayList will all arrangements
    */
    private void perms(String ans, String left, ArrayList<String> permuteList){
        if(left.length() == 0){ // base case -> each letter from contents is added to ans and an arrangement is found
            if(!permuteList.contains(ans)) { // to avoid repeats involving multiple letters
                permuteList.add(ans);
            }
        }
        else{
            for(int i = 0; i < left.length(); i++){
                String newAns = ans + left.charAt(i);
                String newLeft = left.substring(0, i) + left.substring(i + 1); // newLeft removes the letter added to newAns
                perms(newAns, newLeft, permuteList);
            }
        }
    }
    // This method is used to return the contents.
    @Override
    public String toString(){
        return contents;
    }
}