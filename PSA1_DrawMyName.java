/*
 * File Name: DrawMyName.java
 * Created by:  Sabrina Lee cs8awaer [Lab A51] A91066880
 * Due Date:    January 17, 2017
 *
 */

public class DrawMyName
{
    // The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      
      World w = new World();
      Turtle turtleG = new Turtle(150,100,w); //Creates a turtle in w at (x,y) (150,100)     

     // Writing my name for the first time on java
      turtleG.turnLeft();
      turtleG.forward(50);
      turtleG.turnLeft();
      turtleG.forward(50);
      turtleG.turnLeft();
      turtleG.forward(50);
      turtleG.turnRight();
      turtleG.forward(50);
      turtleG.turnRight();
      turtleG.forward(50);
   
      //Making a new turtle for the A in my long name :[
      Turtle turtleB = new Turtle(175,200,w); //The w represents that I'm putting it in the new world I created
      turtleB.forward(100);
      turtleB.turnRight();
      turtleB.forward(50);
      turtleB.turnRight();
      turtleB.forward(100);
      turtleB.turn(180);
      turtleB.forward(50);
      turtleB.turnLeft();
      turtleB.forward(50);
      
      // New turtle for the letter B
      Turtle turtleP = new Turtle(250,100,w); //top left part of the B
      turtleP.turnRight();
      turtleP.forward(50);
      turtleP.turnRight();
      turtleP.forward(50);
      turtleP.turnRight();
      turtleP.forward(50);
      turtleP.turnLeft();
      turtleP.forward(50);
      turtleP.turnLeft();
      turtleP.forward(50);
      turtleP.turnLeft();
      turtleP.forward(50);
      turtleP.turnLeft();
      turtleP.forward(50);
      turtleP.turnRight();
      turtleP.forward(50);
      
      //New turtle for R, but trying a new method. I want to test out the pen up pen down method
      Turtle turtleGrey = new Turtle (325, 100,w);
      turtleGrey.turn(180);
      turtleGrey.forward(100);
      turtleGrey.turnLeft();
      turtleGrey.penUp();
      turtleGrey.moveTo(375,200);
      turtleGrey.penDown();
      turtleGrey.turn(-135);
      turtleGrey.forward(70);
      turtleGrey.turn(135);
      turtleGrey.forward(50);
      turtleGrey.turnLeft();
      turtleGrey.forward(50);
      turtleGrey.turnLeft();
      turtleGrey.forward(50);
      
      //Creating the "I" in simple terms
      Turtle Masa = new Turtle (400,100,w);
      Masa.turn(180);
      Masa.forward(100);
      
      //Almost done, need to draw the N and A. I want to move the light blue turtle and purple to finish off the code
      turtleB.penUp();
      turtleB.moveTo(425,100);
      turtleB.penDown();
      turtleB.turnLeft();
      turtleB.forward(100);
      turtleB.penUp();
      turtleB.moveTo(475,200);
      turtleB.penDown();
      turtleB.turn(153);
      turtleB.forward(113);
      turtleB.penUp();
      turtleB.moveTo(475,200);
      turtleB.penDown();
      turtleB.turn(27);
      turtleB.forward(100);
      
      //Time to finish the name with the A in purple!
      turtleP.penUp();
      turtleP.moveTo(500,200);
      turtleP.penDown();
      turtleP.forward(100);
      turtleP.turnRight();
      turtleP.forward(50);
      turtleP.turnRight();
      turtleP.forward(100);
      turtleP.turn(180);
      turtleP.forward(50);
      turtleP.turnLeft();
      turtleP.forward(50);
      
      
      
      
    }
}
