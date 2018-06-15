/* Filename: Picture.java 
 * Created by: Sabrina Lee (cs8awaer) and Donald Truong (cs8awafv)
 * Date: February 28, 2017
 * 
 * This picture file, we are creating a method to flip a square given the x,y,and size provided by the user.
 * in the picture tester it provides the user a place to input the x and y values and the scanner 
 * uses those as the parameter in the method we created here in picture. 
 * We had to take into account for the conditions to make sure if it is outside of the bounds
 * of the picture we are trying to modify, we have to start the looping method wherever the closest bound is
 * and from there the size creates the area we are trying to flip within the picture. 
 * 
 * COPY PICTURE.JAVA FILE FROM PSA4
 * 
 * In Part B: 
 * We created 2 methods that flip a small portion of a picture within the larger picture either along
 * an invisible horizontal or vertical line within the refrenced rectangle or square that have the given
 * coordinates of the starting position when calling on the method
 * 
 * In PSA 4A we tested the three methods and created a collage method by mixing the three
 * image pictures and taking the added on little colors into one whole array. We then 
 * split it into three sections and combined the three images into one large picture by copy
 * and pasting what we created in the three methods into one large canvas.
 * 
 * In PSA 4B we tested the two methods that we created by calling on the images and giving coordinates to where we
 * want the for loops to begin and end. These rectangles created run the method and either flips the small
 * rectangle/ square
 * along a vertical or horizontal line.
 * 
 */



import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 

// resolves problem with java.awt.List and java.util.List

public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  //flipping a small square within the picture along vertical line in the middle
  //this is from the psa 4 and modified to fit the parameters that are inputted by the user
  public Picture flipHorizontalSquare(int x, int y, int size)
  {
    Picture finalPic = new Picture(this);
    Color tempColor;  
    //the tempcolor is being created to make get the pictures for the temporary color storage
    Pixel rightPixel;
    Pixel leftPixel;
    
    
    //if user inputs x value that is negative it set it to 0
    if (x < 0)
    { 
      x = 0;
    }
    //user inputs x value greater than the width of the picture, it sets it to the width
    //if width is outside it doesnt affect the picture either way
    else if (x > this.getWidth())
    {
      x = this.getWidth();
    }
    //if y is negative, it sets the y value to 0
    if (y < 0) 
    {
      y = 0;
    }
    //if y is greater than the picture height it sets it to the picture height
    else if (y > this.getHeight())
    {
      y = this.getHeight();  
    }
    
    
    
    //to get a specified small rectangle within the picture, using for loops and references to the int
    //width and height that are determined by the desired action  
    //these are creting integers for the value of the picture size that the for loop is
    //running through after going through the conditions
    int endPointX = x + size; 
    int endPointY = y - size;
    int midPoint = x + size/2;
    
    //these are conditions that control for the endpoint value of the picture after adding the size
    if ((endPointY) < 0)
    {
      endPointY = 0; 
    }
    
    if ((endPointX) > this.getWidth())
    {
      endPointX = this.getWidth();
    }
    
    
    
    
    //runing the nested for loop to the picture that accomodates to the parameters
    //the user inputs
    
    
    //nested for loops that run through the left half of the indicated picture that the user wants 
    for(int pX = x, k = 0; pX < midPoint; pX++, k++)
    {
      
      for(int pY = y; pY >= endPointY; pY--)
      {
        
        
        //this sets the left pixel colors into a temporary storage space
        //sets the right pixels to those in the final picture 
        leftPixel = finalPic.getPixel(pX,pY);
        rightPixel = finalPic.getPixel(endPointX - k, pY);
        tempColor = leftPixel.getColor();
        
        /*same as the other switching color methods in the last methods by taking the colors of the original 
         side to the side, setting 
         the other side picture the original side and placing the ones put aside into the new reference 
         */
        
        //this finishes the job by switching the left and right sides of the image inside
        //the small square indicated by the user
        leftPixel.setColor(rightPixel.getColor());
        rightPixel.setColor(tempColor);
        
      }
    }
    return finalPic;
  }  
  
  
  
}




