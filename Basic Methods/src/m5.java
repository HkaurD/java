public class m5 {
    static int randint(int low, int high) { // this method generates a random number between two integers
        return (int) (Math.random() * (high - low + 1) + low); // I use this method to get a random ASCII value between 65 and 90
    }

    static void licensePlate(String[] words) {
        boolean valid = true; // initially the license plate is valid
        String plateWord = ""; // the random word on the license plate
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 4; i++) {
                plateWord = plateWord + (char) (randint(65, 90)); // A to Z have ASCII values of 65 to 90
            }
            for (String word : words) {
                if ((word.toUpperCase()).equals(plateWord)) { // if any word in the original array is in the plateWord, the license plate is not valid
                    valid = false;
                } else {
                    valid = true;
                }
            }
            if (valid) {
                System.out.println(plateWord + " " + randint(100, 999)); // the three digits are numbers between 100 and 999
            }
        }
    }

    public static void main(String[] args){
        String[] words = {"fail", "flub", "rand", "rane", "grad", "says", "drag", "byee"};
        licensePlate(words);
    }
}

