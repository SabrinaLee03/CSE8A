/* Filename: PSA3A.java 
 * Created by: Donald Truong, cs8awafv and Sabrina Lee, cs8awaer
 * Date: January 25, 2017
 */ 
public class PSA3A
{
  //The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args) 
  { 
    Picture pic = new Picture(FileChooser.pickAFile());
    Picture copy = new Picture (pic);   
    pic.subtractColor(20,50,100);
    pic.show();
  } 
}

