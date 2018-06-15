/* Filename: PSA7PictureTester.java 
 * Created by: Sabrina Lee (cs8awaer) and Donald Truong (cs8awafv)
 * Date: February 28, 2017
 */ 
import java.util.Scanner;  // Do not remove this line

public class PSA7PictureTester
{
  /* Choose a new picture through pickAFile and it displays the image. we then initialize the x,y, and size to make
   * the boundaries of the width and height. once the boundaries are placed, it prints the width and the height 
   in text. we then create a new object "scanner" that uses the system input. the scanner is used to scan the user
   input which allows the user determine values through different reader. This will take the values that
   we put in as parameters and print them as text to notify the user*/
  public static void main( String[] args )
  {
    
    Picture pic = new Picture( FileChooser.pickAFile() );
    pic.show();
    
    int x, y, size;
    int width = pic.getWidth();
    int height = pic.getHeight();
    
    System.out.println( "Picture loaded with width=" + width +
                       " and height=" + height );
    
    Scanner reader = new Scanner( System.in );
    
    //Here's an example of reading integer input from the user.
    System.out.print("Please enter the x, y coordinates of lower left corner ");
    System.out.println( "of the box to flip horizontally, x first:" );
    x = reader.nextInt();
    y = reader.nextInt();
    System.out.println( "Enter the size of the box to flip:" );
    size = reader.nextInt();
    
    Picture copy1 = new Picture (pic); //flipping the picture and creating a copy of the image
    Picture copy2 = copy1.flipHorizontalSquare(x, y, size);
    copy2.show();
    
    System.out.println( "You entered x=" + x + " y=" + y + " size=" + size );
    
    
    
  }
  
}



