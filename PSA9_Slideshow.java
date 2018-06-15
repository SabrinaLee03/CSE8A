/* Filename: Slideshow.java 
 * Created by: Sabrina Lee cs8awaer 
 * Date: March 17, 2017 
 *
 * B1: slideshow.java represents the entire slideshow
 * slide array represents the slides within the slideshow
 * will be changed by the SEED
 * B2:creating the constructors that take in parameter or not
 * these are the default results of the array 
 * they are pretty much initializing
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
  
  
  
  //ASK LATER TO TAKE INTO ACCOUNT OF THE COMMENTS REGARDING SIZE/FLIPPING PROB
  
  ///CONSTRUCTOR///
  
  //constructor for the slideshow default
  public Slideshow()
  {
    this.slides = new Slide[0]; 

    
  }
  
  
///METHOD///  
  
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
    //creating a seed for the reverse sound and filter number
    Random randoProb = new Random (400);
    Boolean flip;
    Random number = new Random (400);
    int filterNum;
    
    //gets the index of the slideShowarray to assign a random
    //probability value that is generated from the SEED
    //going through each slide in the array and assigning the filter
    //number as well as the probability of reversing the sound
    for (int index=0; index < slideshowArray.length; index++)
    {
      
      double randomNum = randoProb.nextDouble();
      int newNumber = number.nextInt(2)+1;
      
      
//IF statement conditions to determine which filter to use on the slide
      //depending on the random number generated between 0 and 3
      //will determine which filter will be used on in each slide
      //setting to 1 if randonum =1
      if(newNumber == 1)
      {
        filterNum = 1;
      }
      //setting to 2 if randonum =2
      else if (newNumber == 2)
      {
        filterNum = 2;
      }
      //setting to 3 if randonum =3
      else
      {
        filterNum = 3;
      }
      //probability of the boolean for the reverse sound
      if (randomNum < 0.5)
      {
        flip = true;
      }
      
      else 
      {
        flip = false;
      }
      
      
      //assigns the true or false after going through the
      //random number generated and assigns it to the showSlide method
      //the slide will display the image horizontally modified
      // and reversed or vertically modified and sound nonreversed
      //using the random number generated and stored in SEED
      //to determine whether or not the sound is reversed
      this.slides[index].showSlide(filterNum, flip);
      
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
    Picture pic5 = new Picture ("pic5.jpg");
    Sound sound5 = new Sound ("sound5.wav");
    
    
    //creating the slides by calling the picture and sound
    //objects that we assigned above
    Slide slide1 = new Slide(pic1, sound1);
    Slide slide2 = new Slide(pic2, sound2);
    Slide slide3 = new Slide(pic3, sound3);
    Slide slide4 = new Slide(pic4, sound4);
    Slide slide5 = new Slide(pic5, sound5);
    
    //creating the slideshow
    Slideshow slideshow = new Slideshow();
    
    
    //adding the slides that we created onto the slideshow array
    slideshow.addSlide(slide1);
    slideshow.addSlide(slide2);
    slideshow.addSlide(slide3);
    slideshow.addSlide(slide4);
    slideshow.addSlide(slide5);
    
    //calling the show method to show the resulting slideshow
    slideshow.show();
    
  }
  
  
}






