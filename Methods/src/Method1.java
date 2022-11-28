public class Method1 {
    static void hello(){
        System.out.println("Hello");
    }
    // Method overloading
    // Two or more different methods with the same name, but different "parameter signatures"
    // - Type and/or number of parameters is different
    static void hello(String name){
        System.out.println("Hello " + name);
    }

    static void hello(int n){
        for(int i = 0; i < n; i++) {
            System.out.println("Hello ");
        }
    }

    static int add(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        hello();
        hello("Alex");
        hello(5);

        int x = add(10, 20);
    }
}
