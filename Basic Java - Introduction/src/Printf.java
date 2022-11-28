class Printf {
    public static void main(String[] args) {
        int x = 12;
        double a = 3.141592;
        String school = "Massey";

        System.out.printf("Hello %s %.2f\n", school, a);

        for(int i = 0; i < 10; i++) {
            System.out.printf("%3d %5d %7d\n", i, i*i, (int)Math.pow(2, i));
        }
    }
}