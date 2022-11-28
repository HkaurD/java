class Hello1{
    static int y = 20;

    //method (function in a class)
    public static void main(String[] args){
        int x = 10;
        System.out.println("Hello World! " + y);
    }
}

//print("Hello World") - Python

/*
class Main
- Java is an Object-Oriented Programming language. This means that everything in Java is either a class or an object
  or part of those, even the program itself. The class must match the name you save it as. Classes start with a capital.
  The three classes in this program are Hello1, String and System.

public - In java we can control how other classes interact with our class. If it is public then other classes can access
         it. If it is private then it can not be accessed.

static - "It belongs to the class" (as opposed to belonging to an object). In a simple program, we are not making objects
         of our main class, so every method and every class-level variable must be static.

void - this is the return type of my method main.

main - this is the entry point of our method. main is a special name, it is where our program starts.

(String [args]) - This means when we run our program, we can pass in arguments to control how it works.

System.out.println - our basic print. Does not print multiple values, it only prints one.
If you want multiple values, use + to construct a large string.

System.out.print - stays on the same line.

Curly brackets are for "flow of control", so even if the code was on one line, it would run successfully though the indents
are important stylistically.
*/
