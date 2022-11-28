public class Main {
    public static void main(String[] args){
        Human mac = new Human();
        mac.name = "Mr. McKenzie";
        mac.age = 51;
        Human abh = new Human();
        abh.name = "Abhay";
        abh.age = 17;
        Human jon =  new Human();
        jon.name = "John";
        jon.age = 12;

        mac.hello();
        abh.hello();
        jon.hello();
    }
}

class Human{
    // fields (properties, variables)
    String name;
    int age;

    // Constructor - This is a special method that is called implicitly when the object is made.
    /*public Human(String name, int a){
        name = this.name; // used to resolve the name conflict
        age = a;
    }*/

    // methods
    void hello(){
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
}
