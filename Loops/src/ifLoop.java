// ifs and loops

class ifLoop {

    static int times2(int x) {
        return x * 2;
    }
    public static void main (String[] a) {
        int num = times2(45);



        // if
        int x = 25;
        if (x > 10) {
            System.out.println("X is big");
        }
        else if (x == 10) {
            System.out.println("X is 10");
        }
        else {
            System.out.println("X is small");
        }



        // while loop
        int n = 1;
        while (n < 100) {
            n *= 2;
            if (n > 50) {
                break; // ends the loop
            }
            if (n % 10 == 6) {
                continue; // continue to the next iteration of the loop
            }
            System.out.println(n);
        }



        // do ... while
        int nn; // must be out of the do..while loop to check in the while condition
        do { // runs atleast once; atleast one user input
            nn = n;
            n = n/2;
            System.out.println(n);
        }
        while (nn > 0);



        // for loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + i * 2 + " " + Math.pow(2, i));
        }
    }
}