/* Filename: Picture.java 
 * Created by: Sabrina Lee cs8awaer and Dennis Bui cs8awaaj
 * Date: March 14, 2017 
 * 
 * Picture.java has the flip horizontal and verticle methods that are being called on by
 * slide.java to modify the picture object in the individual slides within the slideshow
 * these methods were used from previous PSAs with slight modifications
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
  
  //horizontal flip method that flips along a vertical axis
  public void flipHorizontal()
  {
    Color tempColor;   
    
    // creating a new picture reference with the pixels referenced and 
    //initializing the references for rightPixels and leftPixels
    Pixel tempPixel = new Pixel(new Picture(),0,0);
    Pixel rightPixel;
    Pixel leftPixel;
    
    //these intergers will determine to get half of the picture refrenced 
    //along with the positioning of our for loops 
    int limit1 = this.getWidth()/2;
    int limit2 = this.getHeight();
    
    //this nested for loop allows us the access the pixels within the dimensions that we want fully
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      {
        
        // here we are flipping the picture by putting the pixels from the left side into 
        //a side reference, replacing the left 
        //with the right side of pixels and placing the pixels we put to the side onto the right side
        
        leftPixel = getPixel(i,j);
        rightPixel = getPixel(getWidth()-1-i,j);
        
        tempPixel.setColor(leftPixel.getColor());
        leftPixel.setColor(rightPixel.getColor());
        rightPixel.setColor(tempPixel.getColor());
        
      }
    }
    
  }
  
  //vertical flip method that flips the picture along the horizontal axis
  public void flipVertical()
  {
    
    
    // creating a new picture reference with the pixels referenced and initializing 
    //the references for rightPixels and leftPixels
    Pixel tempPixel = new Pixel(new Picture(),0,0);
    Pixel bottomPixel;
    Pixel topPixel;
    
    // getting half the picture 
    int limit1 = this.getWidth();
    int limit2 = this.getHeight()/2;
    
    
    //nested for loop to access all of the pictures withint the desired area
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      {
        
        //same method as the horizontal flip except a different starting point and 
        //switching the top and bottom
        topPixel = getPixel(i,j);
        bottomPixel = getPixel(i,getHeight()-1-j);
        
        tempPixel.setColor(topPixel.getColor());
        topPixel.setColor(bottomPixel.getColor());
        bottomPixel.setColor(tempPixel.getColor());
        
      }
    } 
  }
  
  
  
  
  
  
  
}




