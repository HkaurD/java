import java.util.*; // java.util.Scanner can also be done to just import Scanner
// * imports the whole util package

class Basic2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        /* nextInt() -> int
         * nextDouble() -> double
         * next() -> String token
         * nextLine() -> String line
         *
         * this is only a test
         */

        System.out.println("How old are you?");
        int age; //You only ever declare your variable once within the same scope
        // option 2 - Integer.parseInt(keyboard.nextLine());
        age = keyboard.nextInt();
        if(keyboard.hasNextInt()){
            System.out.println("yay");
        }

        System.out.println("In 5 years, you will be " + (age + 5));
        //System.out.println("Enter 3 words: ");
        // To fix token-based / line-based problem
        // 1. add a dummy nextLine() to "eat" the extra newline character
        // 2. Use nextLine() to get the token and convert

        keyboard.nextLine(); // option 1
        keyboard.nextLine();

        String word = keyboard.nextLine();
        System.out.println(word);

        //String word1 = keyboard.next();
        //String word2 = keyboard.next();
        //String word3 = keyboard.next();
        //System.out.println(word1 + " " + word2 + " " + word3); //can put all words on the same input line
    }
}
