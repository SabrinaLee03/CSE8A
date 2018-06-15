/* Filename: Picture.java 
 * Created by: Sabrina Lee (cs8awaer) and Donald Truong (cs8awafv)
 * Date: February 14, 2017
 */

/*----------- Program Description: ------------
 * In this Problem Set we made two methods to modify the picture. The first method "chromakeyBackgroundChange" allows us
 * to change the image of a green screen. We began by running a nest for loop on the myselfSource image to find where the
 * green pixels are located on that image. We then placed the pixels (image of myself) onto the background image that we
 * allocated as pic1. This created a final copy of the image where I was placed in a different background, replacing the 
 * green screen behind me.
 * 
 * The second method "chromakeyShirtChange" allows us to grab the pixels from a separate image and place it on top of the
 * shirt that I was wearing. We put a nested for loop onto the parameters around the shirt to find the colors of the old
 * shirt and replace it with the separate image, changing the image of the shirt in the picture.
 * 
 * For PSA 5 we run the methods we created onto the three separate images and created copies of the different steps that we took.
 * First we show a picture of the original image, then the picture with a background change, lastly a modified shirt with the
 * the background change.
 *
 *
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
  /**
   * The first method "chromakeyBackgroundChange" allows us
 * to change the image of a green screen. We began by running a nest for loop on the myselfSource image to find where the
 * green pixels are located on that image. We then placed the pixels (image of myself) onto the background image that we
 * allocated as pic1. This created a final copy of the image where I was placed in a different background, replacing the 
 * green screen behind me.
   */
  public Picture chromakeyBackgroundChange(Picture background, Color replaceColor)
  {
    //initialize the picture and pixels we will be using to take and replace the allocated colors
    Picture mainImage = new Picture(this);
    Pixel myselfSourceImage = null;
    Pixel myBackgroundSourceImage = null;
    
    //creating a loop through the pixels on the original image to grab the green screen
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
      //getting pixels in the sourceImage
      myselfSourceImage = mainImage.getPixel(x,y);
      
      //making the value of the green pixels greater than the others in the source image
      //then setting the myBackgroundSource Image to those green pixels in the myselfSource Image
      
      if (myselfSourceImage.colorDistance(replaceColor) < 200)
      {
        myBackgroundSourceImage = background.getPixel(x,y);
        myselfSourceImage.setColor(myBackgroundSourceImage.getColor());
              }                                                
       }
    }
    //here we are returning the new image that we created
      return mainImage;  
    }
  
  /**
 *The second method "chromakeyShirtChange" allows us to grab the pixels from a separate image and place it on top of the
 * shirt that I was wearing. We put a nested for loop onto the parameters around the shirt to find the colors of the old
 * shirt and replace it with the separate image, changing the image of the shirt in the picture.
   */
  public Picture chromakeyShirtChange(Picture shirt, Picture original, Color oldShirtColor, int startX, int startY, int width, int height)
   {
    //initialize the pictures we will be grabbing and pixels
    Picture finalPic = new Picture(this);
    Picture mainImage = new Picture(original);
    Pixel myselfSourceImage = null;
    Pixel myShirtSourceImage = null;
    Pixel modifiedBackgroundPic = null;
    
  //running the for loop on the shirt parameters
    for (int sX = 0, x = startX ; sX <= width; sX++, x++)
    {
      for (int sY = 0, y = startY; sY <= height; sY++, y++)
      {
       { //this is setting the coordinates onto the original picture of me and getting the pixels of my shirt
         //setting the final picture to the modified background picture with the shirt change
         myselfSourceImage = mainImage.getPixel (x,y);
         myShirtSourceImage = shirt.getPixel(sX,sY);
         modifiedBackgroundPic = finalPic.getPixel(x,y);
         if (myselfSourceImage.colorDistance (oldShirtColor) < 190)
         {
           //setting the shirt change with the modified background picture
           modifiedBackgroundPic.setColor(myShirtSourceImage.getColor()); 
   }
         
     }
      }
    }
    //returning the final picture
    return finalPic;
  }
   } // this } is the end of class Picture, put all new methods before this
 
