public class Main2 {
    public static void main(String[] args){
        Human2 mac = new Human2("Mr. McKenzie", 51);
        Human2 abh = new Human2("Abhay", 17);
        Human2 jon =  new Human2("John", 12);

        mac.hello();
        abh.hello();
        jon.hello();
        jon.hello(abh);
    }
}

class Human2{
    // fields (properties, variables)
    // All field should be private by default
    // Make them public for very simple classes
    private String name;
    private int age;

    // Constructor - This is a special method that is called implicitly when the object is made.
    public Human2(String name, int a){
        this.name = name; // used to resolve the name conflict
        age = a;
    }

    // methods
    // all methods should be public by default
    // If other programmers should not call the method, make it private (e.g. a method that does a task for another method -> utility method)
    public void hello(){
        if(age < 13){
            System.out.println("'sup");
        }
        else if(age < 18){
            System.out.println("Good Afternoon.");
        }
        else{
            System.out.println("What's a square, Homie?");
        }
    }

    public void hello(Human2 friend){
        System.out.println("Hi " + friend.name);
    }
}

