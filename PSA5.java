/* Filename: PSA5.java 
* Created by: Sabrina Lee (cs8awaer) and Donald Truong (cs8awafv)
* Date: February 14, 2017 
*/ 

import java.awt.Color;

public class PSA5
{ 
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
     
 //creating a string file to the pictures that we want to access through pic0 pic1 and pic2
      //initializing the colors of light gray which is the shirt and green which is the green screan
   String fileName = "pic0.jpg";
   String fileName1 = "pic1.jpg";
   String fileName2 = "pic2.jpg";
   Color lightGray = Color.lightGray;
   Color green = Color.green;
   
  
   //showing a copy of the originial picture
   Picture picture0 = new Picture(fileName);
   picture0.show();
  
//creating a copy of the new image after running our method of chromakeyBackgroundChange
   Picture copy1 = new Picture (fileName1);
   Picture newPic = picture0.chromakeyBackgroundChange(copy1,green);
   newPic.show();
  
//creating a copy of the new image after running our method chromakeyShirtChange
   Picture copy2 = new Picture(fileName2);
   Picture finalPic = newPic.chromakeyShirtChange(copy2, picture0, lightGray, 520, 620, 740, 1000);
   finalPic.show();
   
  
    
    } 
}
