/* Filename: Slide.java 
 * Created by: Sabrina Lee cs8awaer 
 * Date: March 17, 2017 
 * 
 * I FINISHED THE CAPE EVALUATION FOR CSE 8A LOKSA (9:30AM) and I gave a good review :]
 * 
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
 * 
 * 
 *  * B1: slideshow.java represents the entire slideshow
 * slide array represents the slides within the slideshow
 * the probFlip double is the probability of it flipping 
 * (decimal value) that will be changed by the SEED
 * B2:creating the constructors that take in parameter or not
 * these are the default results of the array 
 * they are pretty much initializing
 * B3:the probFlip instance variable is being created as a setter
 * methodchangeProbFlip changes the value of the probFlip to
 * 1-the parameter that the user inputs
 * B4: methods that allow you to add slides into the slideshow
 * the method addslide lets the user input desired slide
 * changeSlide allows you to modify a specific slide in the
 * slideshow array that has already been passed in
 * B5:this method inputs the value that will determine the action
 * of the picture and sound of the specific slide
 * this method is mainly made of the if conditions that
 * will either flip the picture horizontally AND reverse the sound
 * or flip the picture vertically AND no change to the sound
 * B6: we are assigning the picture and sounds to specific slides and 
 * calling them with the methods that we creating.
 * after creating each slide we are adding them into one slideshow array
 * and playing the result at the end with the show method
 * 
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
    
    this.pic = new Picture(inPic);
    this.sound = new Sound(inSound);
    
  }
  
  
  
  ///METHODS/// 
  //conditions for inPic and inSound if the user input a null value
  //changePic and changeSound in addition 
  //allow you to change the picture and sound of the slide
  
  public void changePic(Picture inPic)
  {
    if(inPic == null)
      return;
    this.pic = new Picture(inPic);
  }
  
  public void changeSound(Sound inSound)
  {
    this.sound = new Sound(inSound);
  }
  
  
  //showdlie method takes in boolean inputs and modifies picture and sound
  //depending on those inputs that are determined within slideshow
  //the method can result in a reverse sound, no reverse, color filter
  //and shows them together (display picture and plays sound)
  public void showSlide(int filterToUse, boolean soundReverse)

  {
    if (this.pic == null || this.sound == null)
    {
      System.out.println("Error has occured");
      this.pic = null;
      this.sound = null;
      return;
    }   
    
    //is pictureFlipHorizontal is true, it will flip the picture horizontally
    //if random number =0 turn pic gray
    if( filterToUse == 0)
    {
      this.pic.grayscale();
    }
    // if random number =1 use myfilter
   else if (filterToUse == 1) 
    {
      this.pic.myFilter();
    }
   
    //if =2 use complement method to alter the picture
    else
    {
      this.pic.complement(); 
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







