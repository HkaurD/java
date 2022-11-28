import java.util.*;

public class Poker{
    public static void main(String[] args) {
        Deck deck = new Deck();
        for(int i=1; i<=10; i++){
            ArrayList<Card>player = deck.deal(3);
            ArrayList<Card>computer = deck.deal(3);

            System.out.println("\nGame "+i+":");
            System.out.println("------------");
            System.out.println("Player has: " + player);
            showHand(player);
            System.out.println("Computer has: " + computer);
            showHand(computer);

            if(evaluateHand(computer) > evaluateHand(player)){
                System.out.println("Computer Wins!");
            }
            else if(evaluateHand(player) > evaluateHand(computer)){
                System.out.println("Player Wins!");
            }
            else{
                System.out.println("Its a tie.");
            }
        }
    }

    public static boolean pair(ArrayList<Card>hand){
        return hand.get(0).getVal() == hand.get(1).getVal()  || hand.get(1).getVal() == hand.get(2).getVal() || hand.get(0).getVal() == hand.get(2).getVal();
    }

    public static boolean flush(ArrayList<Card>hand){
        return hand.get(0).getSuit() == hand.get(1).getSuit()  && hand.get(1).getSuit() == hand.get(2).getSuit();
    }

    public static boolean straight(ArrayList<Card>hand){
        boolean valid = false;
        if(hand.get(0).getSuit() != hand.get(1).getSuit()  && hand.get(1).getSuit() != hand.get(2).getSuit() && hand.get(0).getSuit() != hand.get(2).getSuit()){
            int[] numVals = new int[3];
            for(int i = 0; i < 3; i++){
                numVals[i] = hand.get(i).getVal();
            }
            Arrays.sort(numVals);
            if(numVals[1] - numVals[0] == 1 && numVals[2] - numVals[1] == 1){
                valid = true;
            }
        }
        return valid;
    }

    public static boolean straightFlush(ArrayList<Card>hand){
        boolean valid2 = false;
        if(hand.get(0).getSuit() == hand.get(1).getSuit()  && hand.get(1).getSuit() == hand.get(2).getSuit()){
            int[] numVals = new int[3];
            for(int i = 0; i < 3; i++){
                numVals[i] = hand.get(i).getVal();
            }
            Arrays.sort(numVals);
            if(numVals[1] - numVals[0] == 1 && numVals[2] - numVals[1] == 1){
                valid2 = true;
            }
        }
        return valid2;
    }

    public static boolean threeKind(ArrayList<Card>hand){
        return hand.get(0).getVal() == hand.get(1).getVal()  && hand.get(1).getVal() == hand.get(2).getVal();
    }

    public static void showHand(ArrayList<Card>hand){
        String []hands={"High Card","Pair","Flush","Straight","Three of a kind","Straight Flush"};
        System.out.println(hands[evaluateHand(hand)]);
    }

    public static int evaluateHand(ArrayList<Card>hand){
        if(straightFlush(hand)){
            return 5;
        }
        else if(threeKind(hand)){
            return 4;
        }
        else if(straight(hand)){
            return 3;
        }
        else if(flush(hand)){
            return 2;
        }
        else if(pair(hand)){
            return 1;
        }
        else{
            return 0;
        }
    }
}

class Deck{
    private ArrayList<Card>cards;

    public Deck(){
        init();
    }

    public void init(){
        cards = new ArrayList<Card>();
        for(int i = 0; i<52; i++){
            cards.add(new Card(i));
        }
        Collections.shuffle(cards);
    }

    public ArrayList<Card>deal(int n){
        if(n>cards.size()){
            init();
        }
        ArrayList<Card>ans = new ArrayList<Card>(cards.subList(0,n));
        cards.removeAll(ans);
        return ans;
    }
}

class Card{
    private int val, suit;
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card(int n){
        val = n%13+1;
        suit = n/13;
    }

    public int getVal(){
        return val;
    }
    public int getSuit(){
        return suit;
    }

    public String toString(){
        if(val == 1){
            return "Ace of " + suits[suit];
        }
        else if(val == 11){
            return "Jack of " + suits[suit];
        }
        else if(val == 12){
            return "Queen of " + suits[suit];
        }
        else if(val == 13){
            return "King of " + suits[suit];
        }
        else{
            return String.valueOf(val) + " of " + suits[suit];
        }
    }
}