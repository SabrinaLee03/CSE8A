/* Filename: PSA4B.java 
* Created by: Sunny Sun (Cs8awjan) and Sabrina Lee (Cs8awaer)
* Date: February 7, 2017
* 
* In PSA 4B we tested the two methods that we created by calling on the images and giving coordinates to where we
* want the for loops to begin and end. These rectangles created run the method and either flips the small rectangle/ square
* along a vertical or horizontal line.
*/ 

public class PSA4B {
 public static void main(String [] args)
 {
   //Choose a picture file
   //created a picture source action so we can choose the image
   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);
   sourcePicture.show();
   
   //Copy your Picture objects
   //created copies of the new pictures that are being created after the methods that are being run
   Picture copy1 = new Picture (sourcePicture);
   Picture copy2 = new Picture (sourcePicture);
   
   
   //flipping a small rectangle within the large picture along a vertical line
   copy1.flipHorizontalRectangle(250,250, 50, 50);
   copy1.show();
   
   //flipping a small rectangle within the large picture along a horizontal line
   copy2.flipVerticalRectangle(250,250, 50, 50);
   copy2.show();
   
   
   
 }  
  
}