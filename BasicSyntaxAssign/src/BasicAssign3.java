// BasicAssign3
// By: Harbin Kaur Dhillon
// Teacher: Mr.McKenzie
/* This program takes a coordinate for a point (x,y) along with the coordinates of a line (x1,y1,x2,y2) and outputs 
whether the point lies on the given line.*/

import java.awt.geom.Line2D; // Since I wanted to use the method ptLineDist from the class Line2D, I imported the package.
import java.util.*; // I imported the util package so that I could use Scanner to get inputs 

class BasicAssign3{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the coordinates of a point (x,y): ");
        String pointxy = keyboard.next(); // getting the coordinates of a point

        // I used substring to get only the number part from the String pointxy, i.e. excluding the parentheses and comma, and converted it to double to use ptLineDist
        double pointx = Double.parseDouble(pointxy.substring(1, pointxy.indexOf(",")));
        double pointy = Double.parseDouble(pointxy.substring(pointxy.indexOf(",") + 1, pointxy.length() - 1));

        System.out.println("Enter the coordinates of a line (x1,y1,x2,y2): ");
        String linePoints = keyboard.next(); // getting the coordinates of a line

        // I used substring to exclude the parentheses and split the coordinates which are attached by a comma
        String[] coords = linePoints.substring(1, linePoints.length() - 1).split(",");
        double[] lineCoords = new double[4]; // this has all the elements from the Array coords as doubles

        for(int i = 0; i < 4; i++){
            lineCoords[i] = Double.parseDouble(coords[i]); // type-casting the line's coordinates into doubles to use ptLineDist
        }

        // calling the ptLineDIst method from Line2D to check the distance the point is from the line; if the point is on the line, the method returns 0.0
        double isOnLine = Line2D.ptLineDist(lineCoords[0], lineCoords[1], lineCoords[2], lineCoords[3], pointx, pointy);
        if(isOnLine == 0.0){
            System.out.println(pointxy + " is on the line " + linePoints + ".");
        }
        else{
            System.out.println(pointxy + " is not on the line " + linePoints + ".");
        }
    }
}