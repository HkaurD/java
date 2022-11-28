public class Main{
    public static void main(String[] args){
        MyRobot robot = new MyRobot(50, 20, -10);
    }
}

class MyRobot{
    private double x, y;
    private int heading; // all fields should be private to protect the data

    private void fixAngle(){
        // ((ensures the angle is between -360 and 360) + 360(to get rid of negatives)) % 360 (in case the angle is more than 360)
        heading = (heading % 360 + 360) % 360;
    }

    public MyRobot(int xx, int yy, int hh){
        x = xx;
        y = yy;
        heading = hh;
        fixAngle();
    }

    public void turn(int amount){
        heading += amount;
        fixAngle();
    }

    public void advance(double dist){
        x += Math.cos(Math.toRadians(heading)) * dist;
        y += Math.sin(Math.toRadians(heading)) * dist;
    }

    @Override // Decorator: Acts like a comment and tells the coder that this method overrides the built-in toString method
              // Also tells the ide that we "think" we are overriding the built-in toString; gives us an error if there's a mistake
    public String toString(){
        return String.format("x:%.1f y:%.1f heading: %d", x, y, heading);
    }
}
