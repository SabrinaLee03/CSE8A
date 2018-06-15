/* Filename: Slideshow.java 
 * Created by: Sabrina Lee cs8awaer and Dennis Bui cs8awaaj
 * Date: March 14, 2017 
 * 
 * B1: slideshow.java represents the entire slideshow
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



import java.util.Random;



public class Slideshow
{
  //array of slides
  private Slide [] slides;
  //probability flipping making it an integer
  private double probFlip;
  
  
  //ASK LATER TO TAKE INTO ACCOUNT OF THE COMMENTS REGARDING SIZE/FLIPPING PROB
  
  ///CONSTRUCTOR///
  
  //constructor for the slideshow default
  public Slideshow()
  {
    this.slides = new Slide[0]; 
    this.probFlip = 0.5;
    //use addslide method. intialize probFlip to .5
    
  }
  //constructor with a parameter that creates the probFlip
  public Slideshow(double inProb)
  {
    this.slides = new Slide[0]; 
    this.probFlip = 1 - inProb;
    //takes an input parameter for probFlip 
    
  }
  
///METHOD///  
  
//setter method for probFlip
//change value of probFlip to inProb
//input some check to make sure the parameter is in range 
  //if not in range it will print an error message
  public void changeProbFlip (double inProb)
  {
    if (inProb > 1 || inProb < 0)
    {
      System.out.println ("Inappropriate value for probFlip, 0 to 1 please");
      return;
    }
    
    this.probFlip = inProb;
  }
  
  
  //this method adds slides through the user input
  //it goes through the slide length and adds the inSlide
  public void addSlide (Slide inSlide)
  {
    Slide [] addingSlide = new Slide[this.slides.length + 1];
    
    for (int index = 0; index < this.slides.length; index++)
    {
      addingSlide[index] = this.slides[index];
    }
    
    addingSlide[addingSlide.length - 1] = inSlide;
    this.slides = addingSlide;
  }
  
  
  //the changeSlide method checks through the condition
  //if it is not in range, it prints an error message
  public void changeSlide(Slide inslide, int slideToChange)
  {
    if (slideToChange < 0 || slideToChange >= this.slides.length)
    {
      System.out.println ("Innapropriate value for slideToChange, within slide array please");
      return;
    }
    //gets the slideshow array and takes the inslide
    Slide [] slideArray = new Slide [this.slides.length];
    slideArray[slideToChange] = inslide; 
  }
  
  
  
  //the show method puts it all together with the probabilities
  public void show()
  {
    //if the slides are null prints error message
    if (this.slides == null)
    {
      System.out.println ("Error! The slideshow is empty!");
      return;
    } 
    //creates a slideshow array with the given slides
    Slide [] slideshowArray = this.slides;
    //prints an error message if the length is negative or 0
    if (slideshowArray.length <= 0)
    {
      System.out.println ("Error! The slideshow is empty!");
      return;
    }
    //Random probability Seed
    Random randoProb = new Random (400);
    Boolean flip, pilf;
    
    //gets the index of the slideShowarray to assign a random
    //probability value that is generated from the SEED
    for (int index=0; index < slideshowArray.length; index++)
    {
      double randomNum = randoProb.nextDouble();
      double randomNum2 = randoProb.nextDouble();
      
      
//IF statement conditions to determine whether to flip or not
      //if the randomNum generate < the given probFlip
      //it flips the picture horizontally, if greater
      //than the probFlip it will flip the picture vertically
      
      if(randomNum < this.probFlip)
      {
        flip = true;
      }
      
      else
      {
        flip = false;
      }
      
      
      //if the randomNum2 that is generated < the given
      //probFlip, it will reverse the sound, if not
      //it will not change the sound for that slide
      if(randomNum2 < this.probFlip)
      {
        pilf = true;
      }
      
      else
      {
        pilf = false;
      }
      
      //assigns the true or false after going through the
      //random number generated and assigns it to the showSlide method
      this.slides[index].showSlide(flip, pilf);
      
    }
    
  }
  
  //the main 
  public static void main (String[] args) 
  {
    //assigning the pictures and sounds to the files that are
    //named the following so we can call it in the method
    //not using fileChooser
    Picture pic1 = new Picture ("pic1.jpg");
    Sound sound1 = new Sound ("sound1.wav");
    Picture pic2 = new Picture ("pic2.jpg");
    Sound sound2 = new Sound ("sound2.wav");
    Picture pic3 = new Picture ("pic3.jpg");
    Sound sound3 = new Sound ("sound3.wav");
    Picture pic4 = new Picture ("pic4.jpg");
    Sound sound4 = new Sound ("sound4.wav");
    
    
    //creating the slides by calling the picture and sound
    //objects that we assigned above
    Slide slide1 = new Slide(pic1, sound1);
    Slide slide2 = new Slide(pic2, sound2);
    Slide slide3 = new Slide(pic3, sound3);
    Slide slide4 = new Slide(pic4, sound4);
    
    //creating the slideshow and giving the probFlip a value
    Slideshow slideshow = new Slideshow();
    slideshow.changeProbFlip (0.6);
    
    //adding the slides that we created onto the slideshow array
    slideshow.addSlide(slide1);
    slideshow.addSlide(slide2);
    slideshow.addSlide(slide3);
    slideshow.addSlide(slide4);
    
    //calling the show method to show the resulting slideshow
    slideshow.show();
    
  }
  
  
}






