/* Filename: Picture.java 
* Created by: Sunny Sun (Cs8awjan) and Sabrina Lee (Cs8awaer)
* Date: February 7, 2017
* 
* Description: 
* In Part A:
* We created three filters through making different three different methods
* The first method flips the picture horizontally, we cut the picture in half and copied the
* pixels from the left side of the image and putting them to the side. We then place the right side
* image and paste it on the left side of the whole picture. We then put the pixels that we put on the 
* side and pasted them on the right side.
* 
* The second filter is flipping the pictuer vertically. In this method we cut the picture in half
* (along the horizontal access) and took the pixels from the top half and set them aside. Then we 
* set the bottom half image to the top half of the picture. Then placed the top half pixels that 
* we set to the side and set to the bottom half.
* 
* The third filter is a grayscale image where we take the entire picture and all of the colors within
* the picture and scale it down. We lower the constrast in the color pixels and it pans the entire
* image to a gray picture.
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
* want the for loops to begin and end. These rectangles created run the method and either flips the small rectangle/ square
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
  
  /**
   * Horizontal flip method
   * In this method, I've given you the basic structure of how things will look.  There are a few incomplete assignments inside of the method.  It is your job to figure out how to complete those assignments!
   * This method works almost like the horizontal mirroring method you saw in your text book (pg 135), but instead of mirroring on the middle of the image, we want to flip it all the way.
   * Hint: Why do we need tempColor in this case?  I encourage you to reflect on this question if you find your method not working the way it should!**/
  
  //this method flips the picture horizontally (along an invisible vertical line in the middle of the picture)
  public void flipHorizontal()
  {
    Color tempColor;   
   
    // creating a new picture reference with the pixels referenced and initializing the references for rightPixels and leftPixels
    Pixel tempPixel = new Pixel(new Picture(),0,0);
    Pixel rightPixel;
    Pixel leftPixel;
    
    //these intergers will determine to get half of the picture refrenced along with the positioning of our for loops 
    int limit1 = this.getWidth()/2;
    int limit2 = this.getHeight();
    
    //this nested for loop allows us the access the pixels within the dimensions that we want fully
    for(int i = 0; i < limit1; i++)
    {
      for(int j = 0; j < limit2; j++)
      {
    
    // here we are flipping the picture by putting the pixels from the left side into a side reference, replacing the left 
   //with the right side of pixels and placing the pixels we put to the side onto the right side
    
        leftPixel = getPixel(i,j);
        rightPixel = getPixel(getWidth()-1-i,j);
        
        tempPixel.setColor(leftPixel.getColor());
        leftPixel.setColor(rightPixel.getColor());
        rightPixel.setColor(tempPixel.getColor());
        
      }
    }
     
  }
  
  
  
  //this method flips the image upside down along an invisible horizontal line in the middle of the picture
  public void flipVertical()
  {
    
     
    // creating a new picture reference with the pixels referenced and initializing the references for rightPixels and leftPixels
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
        
        //same method as the horizontal flip except a different starting point and switching the top and bottom
        topPixel = getPixel(i,j);
        bottomPixel = getPixel(i,getHeight()-1-j);
        
        tempPixel.setColor(topPixel.getColor());
        topPixel.setColor(bottomPixel.getColor());
        bottomPixel.setColor(tempPixel.getColor());
        
      }
    } 
  }
  
  
  //method turns the image gray by lowering the value of each color
  public void grayscale()
  {
    
     Pixel[] pixelArray = this.getPixels(); //inititalize array and get the pixel of this array
    
     int color = 0;//initializing variable
             
    for (Pixel image : pixelArray) {  
    color = (int) ((image.getRed() + image.getGreen() + image.getBlue()) / 3); // compute the intensity of the pixel (average value) 
    image.setColor(new Color(color,color,color)); // set the pixel color to the new color  
       
      }
    } 
  
  
 //creating the picture collage of our three methods
  public void collage(Picture [] pictures)
   {
   Pixel blankPic;
   Pixel collage;
   for (int i = 0; i < pictures.length; i++) { //loops three times. once for each picture
    
     for (int y = 0; y < pictures[i].getHeight(); y++){ //getting the height of all three pictures together
       
       for (int x = 0; x < pictures[i].getWidth(); x++){
           blankPic = this.getPixel(x+pictures[i].getWidth()*i,y); //putting the three pictures onto one big canvas
           collage = pictures[i].getPixel(x,y);
           blankPic.setColor(collage.getColor());
       }   
      }
     }
    }
  
  //flipping a rectangle within the picture along a horizontal line in the middle of the rectangle we want to flip
    public void flipVerticalRectangle(int x, int y, int width, int height)
    {
    
        Color tempColor;   
   
      // creating a new picture reference with the pixels referenced and initializing the references for rightPixels and leftPixels
        Pixel tempPixel = new Pixel(new Picture(),0,0);
        Pixel rightPixel;
        Pixel leftPixel;
    
        //to get a specified small rectangle within the picture, using for loops and references to the int width and height that are determined by the desired action
     for(int pX=x; pX < (x + width); pX++)
      {
       
     for(int pY=y+1; pY > (y - (height/2)); pY--)
      {
       //creating the left and right pixel reference to the specified coordinates within a picture
        leftPixel = getPixel(pX,pY);
        rightPixel = getPixel(pX,(2*y - height - pY));
       
       //same as the big vertical and horizontal flip in switching and replacing the color references among each side
        tempPixel.setColor(leftPixel.getColor());
        leftPixel.setColor(rightPixel.getColor());
        rightPixel.setColor(tempPixel.getColor());
        
      }
     }    
    }      
      
      
   
    //flipping a small rectangle within the picture along vertical line in the middle
    public void flipHorizontalRectangle(int x, int y, int width, int height)
     {
        Color tempColor;   
   
   
    //the tempcolor is being created to make get the pictures for the temporary color storage
        Pixel tempPixel = new Pixel(new Picture(),0,0);
        Pixel rightPixel;
        Pixel leftPixel;
    
   //to get a specified small rectangle within the picture, using for loops and references to the int width and height that are determined by the desired action      
     for(int pX=x+1; pX < (x+ (width/2)); pX++)
      {
       
     for(int pY=y; pY > (y - height) + 1; pY--)
      {
        
        leftPixel = getPixel(pX,pY);
        rightPixel = getPixel((2*x) + width - pX,pY);
       
       //same as the other switching color methods in the last methods by taking the colors of the original side to the side, setting 
        //the other side picture the original side and placing the ones put aside into the new reference
        tempPixel.setColor(leftPixel.getColor());
        leftPixel.setColor(rightPixel.getColor());
        rightPixel.setColor(tempPixel.getColor());
        
      }
    }
     
    }  
     
     
     
     
     }
     

   
    
 