class String1 {
    public static void main(String[] args) {
        // Point p = new Point(10, 25);     standard notation
        String name = "Vincent Massey";     // Strings are special in Java

        char []pet = {'D', 'o', 'g'};
        String pets = new String(pet);      // constructer example
        System.out.println(pets);
        System.out.println(name.charAt(0));

        int x = 12;
        String ans = String.format("--%5d--", x);
        System.out.println(ans);

        /* String method
         *
         * charAt - get char at an index
         * substring - get a String in a range
         * length - gets the length of a string
         * equals  - check if two Strings have the same contents
         * toUpperCase - converts Strings to all upper case
         * toLowerCase - converts Strings to all lower case
         * equalsIgnoreCase - ignores whether Strings are equal regardless of cases (e.g. DOG vs dog)
         */
     
    /*for(int i = 0; i < name.length(); i++){
      System.out.println(name.charAt(i));
    }*/

        //substring(a, b) - from a to b (exclusive of b)
        //substring(a) - from a to the end
        System.out.println(name.substring(2, 5));
        System.out.println(name.substring(8));

        String n2 = "Vincent";
        n2 += " Massey";
        String n3 = "Vincent Massey";

        // Shallow equals
        System.out.println(name == n2);
        System.out.println(name == n3);

        // Deep equals
        System.out.println(name.equals(n2));
        System.out.println(name.equals(n3));

        //toUpperCase and toLowerCase
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());

        //equalsIgnoreCase
        System.out.println("dog".equalsIgnoreCase("DOG"));

    }
}