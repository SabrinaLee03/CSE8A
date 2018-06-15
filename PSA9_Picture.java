/* Filename: Picture.java 
 * Created by: Sabrina Lee, cs8awaer
 * Date: March 17, 2017
 */

/*--------PROGRAM DESCRIPTION----------
 In this class, there are programs that modify the colors of a picture by taking the individual color squares within
 the image and changing the color reference. The subtractColor method takes the maximum value of the color squares and
 subtracts the original image color and reduces the color in the entire image.
 The first program, complement, takes the color squares in the image and subtracts the color value. 
 The second program, grayscale, takes the average value of the 
 color squares and divides it by the total number of colors, neutralizing the value and changing the image to gray. 
 The third program, myfilter, takes the color square within a portion of the picture and 
 subtracts the value of that color with another in the same portion in order to change the image
 to the color most present before the modification.
 
 In PSA 3A, we were testing the program of subtractColor and opened the image with the reduction in the color scheme.
 
 In PSA 3B, we were testing the programs of complement, grayscale, and myfilter. Each method took on one third of the
 image and we were able to split the picture up into three segments. We determined the first third of the color squares
 and applied the complement program. The second third of the image takes on the grayscale program. Lastly, the myfilter
 program changed the last third of the picture. We were able to apply the programs to specific areas in the picture
 by referencing the color squares and splitting into 3 parts.
 
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
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
  
  /*
   * Subtract the given values from the appropriate colors.
   * Input: rSub - the amount that should be subtracted from pixel’s original red 
   *    gSub - the amount that should be subtracted from pixel’s original green 
   *    bSub - the amount that should be subtracted from pixel’s original blue 
   * Returns: nothing
   */
  public void subtractColor(int rSub, int gSub, int bSub)
  {
    Pixel [ ] pixelArray = this.getPixels();
    for (int i = 0; i < pixelArray.length; i++)
    {
      pixelArray[i].setRed(pixelArray[i].getRed() - rSub);
      pixelArray[i].setGreen(pixelArray[i].getGreen() - gSub);
      pixelArray[i].setBlue(pixelArray[i].getBlue() - bSub);
      
      if (pixelArray[i].getRed() < 0){
        pixelArray[i].setRed(0);
      }
      if (pixelArray[i].getRed() >255){
        pixelArray[i].setRed(255);
      }
      if (pixelArray[i].getGreen() < 0){
        pixelArray[i].setGreen(0);
      }
      if (pixelArray[i].getGreen() >255){
        pixelArray[i].setGreen(255);
      }
      if (pixelArray[i].getBlue() >0){
        pixelArray[i].setBlue(0);
      }
      if (pixelArray[i].getBlue() >255){
        pixelArray[i].setBlue(255);
      }
    }
  }
  
  
  /**
   * Create the complement of each pixel between the provided indices
   * Input: start - the index of the first pixel to be modified (inclusive)
   *        end - the index of the last pixel to be modified (inclusive)
   * Returns: nothing
   */
  public void complement()
  {
    
    Pixel [] pixelArray = this.getPixels();
    Pixel pixel = null;
    int filter = 0;
    
    //loop to go through the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //grab the current pixel value
      pixel = pixelArray [i];
      pixel.setRed(255 - pixel.getRed());
      pixel.setGreen(255 - pixel.getGreen());
      pixel.setBlue(255 - pixel.getBlue());
    }
  }
  
  
  /*
   * Create the gray equivalent of each pixel between the provided indices
   * Input: start - the index of the first pixel to be modified (inclusive)
   *        end - the index of the last pixel to be modified (inclusive)
   * Returns: nothing
   */
  public void grayscale()
  {
    
    Pixel [] pixelArray = this.getPixels();
    Pixel pixel = null;
    int filter = 0;
    
    //loop to go through the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //grab the current pixel value
      pixel = pixelArray [i];
      
//grabbing the red, green, and blue values in the original pic
      int r =  pixel.getRed();
      int g = pixel.getGreen();
      int b = pixel.getBlue();
      //averaging it out
      filter = ((r+g+b)/3);
      
      //setting the pixels with the new avg integer
      pixel.setColor (new Color(filter,filter,filter));
    }
  }
  
  /**
   * Apply myFilter to each pixel between and including the provided indices
   * Takes the value of a color at that index and subtracts it from another color of the same index
   * and sets it back to the first referenced color. This repeats throughout the loop.
   * Input: start - the index of the first pixel to be modified (inclusive)
   *        end - the index of the last pixel to be modified (inclusive)
   * Returns: nothing
   */
  
  public void myFilter()
  {
    Pixel [] pixelArray = this.getPixels();
    Pixel pixel = null;
    int filter = 0;
    
    //loop to go through the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //grab the current pixel value
      pixel = pixelArray [i];
  
      pixel.setRed(pixel.getRed() - (pixel.getBlue()*2));
      pixel.setGreen(pixel.getGreen() - (pixel.getRed()*2));
      pixel.setBlue(pixel.getBlue() - (pixel.getGreen()*2));

    }
  }
  
  
  
  //LOOK UP ANOTHER FILTER TO USE? MAKE IT IUNIQUE, DO NOT FLIP OR MIRROR
  //JUST ADJUST THE COLOR
  
  
  
  
  
  
}// this } is the end of class Picture, put all new methods before this

