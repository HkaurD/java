public class Logo {

    public static void main (String[] args)
    {
        Turtle t = new Turtle();
        t.start();  // wait for the Turtle to be ready to draw stuff

	/*
		THIS IS WHERE YOU RUN YOUR LOGO-LIKE CODE
		e.g.*/
        t.square(40);
        t.penUp();
        t.turn(60);
        t.forward(90);
        t.penDown();
        t.square(100);
        t.penUp();
        t.forward(-190);
        t.turn(140);

        t.penDown();
        t.rectangle(150, 125);

        t.penUp();
        t.turn(-40);
        t.forward(-30);
        t.penDown();
        t.dashedLine(102);
        t.star(202);
    }
}