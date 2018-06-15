/* Filename: PSA4A.java 
* Created by: Sunny Sun (Cs8awjan) and Sabrina Lee (Cs8awaer)
* Date: February 7, 2017
* 
* 
* In PSA 4A we tested the three methods and created a collage method by mixing the three
* image pictures and taking the added on little colors into one whole array. We then 
* split it into three sections and combined the three images into one large picture by copy
* and pasting what we created in the three methods into one large canvas.
* 
*/ 

/*I've given you a basic skeleton of how your code is going to look so you can get a basic idea of the workflow here*/
public class PSA4A {
 public static void main(String [] args)
 {
   //Choose a picture file
   //this will allow us to choose a picture file on our own
   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);
   sourcePicture.show();
   
   Picture copy1 = new Picture (sourcePicture); //flipping the picture and creating a copy of the image
   copy1.flipHorizontal();
   copy1.show();
   
   Picture copy2 = new Picture (sourcePicture); //flipping the picture and creating a copy of the image
   copy2.flipVertical();
   copy2.show();
   
   Picture copy3 = new Picture (sourcePicture); //turning the picture gray and creating a copy
   copy3.grayscale();
   copy3.show();
   
   Picture [] pictures = {copy1, copy2, copy3}; //taking all 3 copies that were created and pasting them onto a larger blank canvas with the same dimensions when added
   Picture blankPic = new Picture(sourcePicture.getWidth() * 3, sourcePicture.getHeight());
   blankPic.collage(pictures);
   blankPic.show();
   
 
  
 }
 
}