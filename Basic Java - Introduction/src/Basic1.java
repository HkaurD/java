class Basic1{
    public static void main(String[] args){
        // primative variables - they hold an actual value.
        int x = 12;             // integers
        double money = 25.50;   // real numbers
        char lett = 'A';        // This is just the ASCII value (i.e. 65) - char is NOT a string

        // String is a class, so name is an object. All objects hold a reference to a spot in memory where the object is.
        String name = "Vincent Massey";     // Strings are immutable (can not change the object in place) to protect memory
        // and security reasons.
        name = "Dr." + name;
        System.out.println(name); // works!

        // Basic Math
        // +, -            As expected, expect when you try to add to a String, Java converts it to a String.
        // *               As expected, expect no String multiplication
        /* /               int / int -> int
         *                 double / int -> double
         *                 int / double -> double
         *                 double / double -> double
         */

        // Type casting - converting between primative types
        int y = 5;
        double ans = (double)x / y; // 2.4
        lett = (char)(lett + 1);
        System.out.println(lett);
        System.out.println('A' + 1);
    }
}