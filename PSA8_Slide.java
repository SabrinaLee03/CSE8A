/* Filename: Slide.java 
 * Created by: Sabrina Lee cs8awaer and Dennis Bui cs8awaaj
 * Date: March 14, 2017 
 * 
 * Slide.java: we initialized the slide objects to be used in slideshow.java
 * A1: We created the instance variables picture and sound that represent the
 * picture and sound within the slides that are being shown
 * A2: constructors slide with and without the parameters that represent which
 * ones will be displayed as a default (inPic and inSound) to be modified in the
 * later methods
 * A3/ A4: creating the mutator methods that take the parameters being passed in through
 * the constructor. in this context we are modifying picture and sound. there
 * is an additional method that displays the image and sound insync
 * using boolean inputs that will be determined from slideshow.java
 */ 


//creating color objects
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;


public class Slide extends SimplePicture
{
  //instance variables, we made them public so we dont need getter or setters
  public Picture pic;
  public Sound sound;
  
  ///CONSTRUCTORS///
  
  //setting the pic and sound parameters to null
  public Slide()
  {
    this.pic = null;
    this.sound = null;
  }
  
  /*the picture inPic will show when the slide is shown  and 
   * play inSound while in Pic is being displayed*/ 
  public Slide(Picture inPic, Sound inSound)
  { 
    
    
    if( inPic == null || inSound == null)
      return;
    
    this.pic = inPic;
    this.sound = inSound;
    
    /*
     this.pic = new Picture(inPic.length);
     for (int i=0; i < inPic.length; i++)
     { 
     pic(i) = inPic(i);
     }
     
     this.sound = new Sound (inSound.length);
     for (int i = 0; i < inSound.length; i++)
     {
     sound(i) = inSound(i); 
     }
     */
  }
  
  
  
  ///METHODS/// 
  //conditions for inPic and inSound if the user input a null value
  //changePic and changeSound in addition 
  //allow you to change the picture and sound of the slide
  
  public void changePic(Picture inPic)
  {
    if(inPic == null)
      return;
    this.pic = inPic;
  }
  
  public void changeSound(Sound inSound)
  {
    this.sound = inSound;
  }
  
  
  //showdlie method takes in boolean inputs and modifies picture and sound
  //depending on those inputs that are determined within slideshow
  //the method can result in a reverse sound, no reverse, flip horizontal
  //flip vertical and shows them together (display picture and plays sound)
  public void showSlide(boolean pictureFlipHorizontal, boolean soundReverse)
  {
    if (this.pic == null || this.sound == null)
    {
      System.out.println("Error has occured");
      this.pic = null;
      this.sound = null;
      return;
      
    }   
    
    //is pictureFlipHorizontal is true, it will flip the picture horizontally
    if( pictureFlipHorizontal == true)
    {
      this.pic.flipHorizontal();
    }
    
    //if it is false it will flip the picture vertically
    else
    {
      this.pic.flipVertical(); 
    } 
    
    //reversing the sound if boolean comes to be true
    //returns the original if false
    if( soundReverse == true)
    {
      this.sound = this.sound.reverseSound();
      
    }
    
    
    //plays the slide with the sound
    { 
      this.pic.show();
      this.sound.blockingPlay();
      this.pic.hide();
    }
    return;
  }
}







