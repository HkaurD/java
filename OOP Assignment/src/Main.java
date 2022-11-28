public class Main {
    public static void main(String[] args){
        // Question One - class GameWord
        GameWord word = new GameWord("STAIN");
        System.out.println(word.reverse());
        System.out.println(word.anagram("LOHLE"));
        System.out.println(word.pointValue(0, 0, word.DOWN));
        System.out.println(word.permutations());
        System.out.println(word.toString());

        GameWord word2 = new GameWord("DOG");
        System.out.println(word2.reverse());
        System.out.println(word.anagram(word2));
        System.out.println(word2.pointValue(3, 6, word2.RIGHT));
        System.out.println(word2.permutations());
        System.out.println(word2.toString());

        // Question Two - class CheckersBoard
        CheckersBoard board = new CheckersBoard();

        board.move(6, 2, 5, 3);
        board.display();
        System.out.println("\n");
        board.move(5, 3, 4, 4);
        board.display();
        System.out.println("\n");
        board.move(5, 1, 6, 2);
        board.display();
        System.out.println("\n");
        board.move(5, 5, 5, 1);
        board.display();
        System.out.println("\n");
        board.move(6, 0, 4, 2);
        board.display();
        System.out.println("\n");

        System.out.println("RED: " + board.count(board.RED));
        System.out.println("BLACK: " + board.count(board.BLACK));
    }
}