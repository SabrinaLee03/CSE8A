import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 * <p>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 *         <p>
 *         <p>
 *         Filename: Turtle.java
 *         Created by: Sabrina Lee cs8awaer and Donald Truong cs8awafv
 *         Date:24 January 2017
 * COMMENTS:
 * In Turtle.java we created 3 methods (takeStep, countSteps, and rwPosition). The takeStep method is a way of making our turtle move a 
 * certain direction to the left or the right. The rwPosition method tells our turtle to move randomly in different directions like a 
 * zig zag motion. The countStep method gives the total number of steps the turtle can make. 
 * In RandomTurtleTester.java, it makes a picture of the use of all three methods that we made in Turtle.java.
 * In RandomTurtleTester2.java, we tested whether the turtle has a higher chance of moving to the right or to the left.
 * 
 */

public class Turtle extends SimpleTurtle {
  ////////////////// constructors ///////////////////////
  
  /**
   * Constructor that takes the x and y and a picture to
   * draw on
   *
   * @param x       the starting x position
   * @param y       the starting y position
   * @param picture the picture to draw on
   */
  public Turtle(int x, int y, Picture picture) {
    // let the parent constructor handle it
    super(x, y, picture);
  }
  
  /**
   * Constructor that takes the x and y and a model
   * display to draw it on
   *
   * @param x              the starting x position
   * @param y              the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle(int x, int y,
                ModelDisplay modelDisplayer) {
    // let the parent constructor handle it
    super(x, y, modelDisplayer);
  }
  
  /**
   * Constructor that takes the model display
   *
   * @param modelDisplay the thing that displays the model
   */
  public Turtle(ModelDisplay modelDisplay) {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   *
   * @param p the picture to draw on
   */
  public Turtle(Picture p) {
    // let the parent constructor handle it
    super(p);
  }
  
  /////////////////// methods ///////////////////////
  
  /**
   * Return whether or not the turtle should take a step to the left (-1)
   * or the right (+1)
   * Input: probabilityToLeft, the probability the tutle moving left. Should between 0-1.
   * Returns: -1 to represent a step to the left, 1 to represent a
   * step to the right.
   */
  public int getRandomStep(double probabilityToLeft) {
    Random numGenerator = new Random();
    // Choose either 0 or 1 (note that next int is NON inclusive 
    // of its argument).
    double choice = numGenerator.nextDouble();
    if (choice < probabilityToLeft) {
      return -1;
    } else {
      return 1;
    }
  }
  
  public static void main(String[] args) {
    World earth = new World();
    Turtle t1 = new Turtle(earth);
    
  }
  
  
  public void takeStep(int direction) {
    this.turn(45*direction);
    this.forward(50);
    this.turn(90*-direction);
    this.forward(50);
    this.turn(45*direction);
  }
  
  public int rwPosition (int nSteps) {
    int x = 0;
    int totalx = 0;
    for (int i=0; i< nSteps; i++);
    x = this.getRandomStep(0.5);
    this.takeStep(x);
    totalx = x + totalx;
    return totalx;
    
  }
  
  public int countSteps(int maxDisplacement) {
    int i = 0;
    int rando = 0;
    int totalrando = 0;
    while(Math.abs(i) < maxDisplacement){
      rando = this.getRandomStep(0.5);
      this.takeStep(rando);
      i = i + rando;
      rando = Math.abs(rando);
      totalrando = totalrando + rando;
    }
    return totalrando;
  }
  
  public int rwPositionPlain (int nSteps) {
    int x = 0;
    int totalx = 0;
    for (int i=0; i< nSteps; i++){
      x = this.getRandomStep(0.8);
      totalx = x + totalx;
    }
        return totalx;
      
    }
    
}// this } is the end of class Turtle, put all new methods before this
