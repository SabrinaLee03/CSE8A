/* Filename: TESTER.java 
 * Created by: Sabrina Lee cs8awaer and Dennis Bui cs8awaaj
 * Date: March 14, 2017 
 */ 

public class TESTER extends Picture
{ 
//The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args) 
  { 
    
    
    String contextPic = FileChooser.pickAFile();
    Picture context = new Picture(contextPic);
    //context.explore();
    
    Sound sound1 = new Sound(FileChooser.pickAFile());
    //sound1.blockingPlay();
    
    
    //Picture nullp = new Picture();
    //Slide newSlide = new Slide(null, null);
    
    Slide test = new Slide(context, sound1);
    
        
    
    //error test
    //newSlide.showSlide(false, false);
    
    test.showSlide(true, true);
    
  } 
}




