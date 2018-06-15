/* Filename: Picture.java 
 * Created by: Sabrina Lee cs8awaer and Dennis Bui cs8awaaj
 * Date: February 21, 2017 
 * 
 * DESCRIPTION:
 * 
 * Part A: In part A we created several operations (methods) to alter the binary codes of the numbers that we test in
 * the MethodTester. Binary code is a series of 0's and 1's that are put together in order to create a summed number. 
 * We used shift operators (moving the binary code left and right) as well as addition to replace the numbers on
 * the very left and very right of the binary code for that number. In a sense we will be "clearing" either the most 
 * significant (left most numbers) or the least significant (right most numbers.) 
 * 
 * embedDigits2 will shift the binary code "messageVal" number of the times to the right which will
 * clear the least significant numbers by the value of "messageVal" and create a new binary number, we
 * then add back the messageVal to get the final number
 * 
 * embedDigitsN will shift the binary code "N" number of the times to the right which will
 * clear the least significant numbers by the value of "N" and create a new binary number, we
 * then add back the messageVal to get the final number
 * 
 * getLeastSignificant2 we will be taking the module of binary number that we want. the module is dividing
 * the main number by a specific value and returning the remainder value. Since we want the two least significant 
 * we set the specified value to 4 in order to get a number between 0 and 3 (which is the total of the least 2 
 * significant values.)
 * 
 * getLeastSignficantN  we will be taking the module of binary number that we want. the module is dividing
 * the main number by a specific value and returning the remainder value. Since we want the N least significant 
 * we set the specified value to 2^N in order to get the total of least significant N values (which 
 * is the total of the least N significant values)
 * 
 * In the method tester file, we tested all of the methods we had created by inputting specific values and returning
 * the expected. If it was correct it was indicated, if it was wrong or not what we expected, it returned the
 * message that it was wrong and gave the answer that it was suppose to return.
 * 
 * PART B: We used our methods to try it on affecting a picture. In the methods we took 2 different images and
 * want to "hide" one of them in the context of the other. To do this we will be altering the binary values of each
 * pixel in the pictures that we are accessing
 * 
 * hideSecretMessage2Bits we ran through the message that fits the if statement parameters. The parameters
 * depend on the size of the image of the context compared to the image size of the message. We took the
 * most significant values in binary from the message picture and want to take the difference value and place it
 * into the context picture with the new picture that we created. We create a hidden message in the target(context)
 * picture by taking the most significant values (using the method to get the left most values of the binary
 * values for the message picture) and add that value to the context picture.
 * We took all of the pixel values for the red blue and green values and set it to a new canvas.
 * 
 * For this method, we tested the outcome through PSA 6 by selecting the M&M photo and taking the cookie monster photo.
 * We want to take the cookie monsters most significant values for the red green and blue and input it in the 
 * M&M photos least significant values. We check if the method work by comparing the pixel value (concentration)
 * for each red green and blue in the final M&M photo by using the explore image.
 * 
 * In the recoverSecretMessage2Bits method we are taking the picture with the hidden message and subtracting the
 * origincal context picel and returning the most significant values to get the distorted, hidden message from the
 * picture with the message.
 * 
 * For hideSecretMessageNBits and recoverSecretMessageNBits, we are doing the same as the hide SecretMessage2Bits and
 * recoverSecretMessageNBits but we are taking the N most significant values of the message and hiding it in the
 * context photo. After hiding it in the context photo we are recovering those N most significant values of the 
 * color pixels and recovering them. We test these out in PSA 6.java
 * 
 * 
 * PART C: saving the hidden message we implimented the methods on.
 * we take the pictures we created my_picture_with_hidden_message and my_hidden_message.
 * this is saving the picture with the hidden message (modified in previous parts with the least 2 or N significant 
 * pixel values and saving the hidden message which is the modified picture that was hidden in the context
 * 
 */ 

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    
    return output;
    
  }
  
  /*
   * This method  preserve the 2 most significant (i.e. leftmost) bits in each 8-bit number
   * Example: The most significant 2 bits of 250 (11111010) are 11 in binary which is equal to 3 in decimal. 
   */
  public static int mostSignificant2( int num )
  {
    return num >> 6;
  }  
  
  
  /* 
   * This method  preserve the N most significant (i.e. leftmost) bits in each 8-bit number
   * Example: If N=3 ,the most significant 3 bits of 250 (11111010) are 111 in binary which is equal to 7 in decimal. 
   */
  public static int mostSignificantN( int num, int N )
  {
    return num >> (8-N);  
  }
  
  public static int shift2BitsTo8( int num )
  {
    return num << 6;
  }
  
  /* 
   * This method  converts num with N bits into 8 bits
   * Example: If if num is 2 and N is 3, it means num is 010 in binary. This method will convert it into 01000000,
   * which is eual to 64 in decimal.
   */
  public static int shiftNBitsTo8( int num, int N )
  {
    return num << (8-N);  // You must implement this
  }
  
  
  /*
   * This method creates a copy of picture passed in the parameter. It changes the red, blue and green components 
   * of each pixel in copied picture. It uses the method mostSignificant2 to convert the 8-bit values into 2 bit values
   *
   *  Hence if you call this method, it will give you a copy of the picture passed in the parameter. But the copied picture has only 2 bits of 
   * information per color. For example, if blue color value for  any pixel in the picture is 01000000 (64 in decimal), the correspoding value 
   * of red color in copied picuture would be just 00000001 (1 in decinal)
   *
   */
  public static Picture degradeColors2Bits(Picture sourcePicture) {
    Picture picCopy = new Picture( sourcePicture.getWidth(), sourcePicture.getHeight() );
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
        
        red = mostSignificant2( red );
        green = mostSignificant2( green );
        blue = mostSignificant2( blue );
        
        red = shift2BitsTo8( red);
        green = shift2BitsTo8( green);
        blue = shift2BitsTo8( blue);
        
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    return picCopy;
    
  }  
  
  /*
   This method creates a copy of the picture passed in the parameter. It changes the red, blue and green components 
   of each pixel in copied picture. It uses the method mostSignificantN to convert the 8-bit values into N bit values
   and then shift it back to 8 bit values.
   Hence if you call this method with the Picture as one of the parameters, it will give you a copy of the picture. 
   But the copied picture has only N bits of information per color.
   */
  public static Picture degradeColorsNBits(Picture sourcePicture,int N) {
    Picture picCopy = new Picture( sourcePicture.getWidth(), sourcePicture.getHeight() );
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
        
        red = mostSignificantN( red, N );
        green = mostSignificantN( green, N);
        blue = mostSignificantN( blue, N);
        
        red = shiftNBitsTo8( red, N );
        green = shiftNBitsTo8( green, N);
        blue = shiftNBitsTo8( blue, N);
        
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    return picCopy;
  } 
  
  
  /* hideSecretMessage2Bits we ran through the message that fits the if statement parameters. The parameters
 * depend on the size of the image of the context compared to the image size of the message. We took the
 * most significant values in binary from the message picture and want to take the difference value and place it
 * into the context picture with the new picture that we created. We create a hidden message in the target(context)
 * picture by taking the most significant values (using the method to get the left most values of the binary
 * values for the message picture) and add that value to the context picture.
 * We took all of the pixel values for the red blue and green values and set it to a new canvas.
 * 
 */
  
  public static Picture hideSecretMessage2Bits(Picture context, Picture message, int x, int y){
    
    Picture canvas = new Picture(context);
    /*if the canvas is bigger than the message in both vertical and horizontal dimensions, the message should be hidden
     * in the upper left corner of the copy of the canvas which is starting (x,y)*/
    if (canvas.getWidth() > message.getWidth() && canvas.getHeight() > message.getHeight()) {  
      
      for (int i=x; i < context.getWidth();  i++) {
        for (int j=y; j < context.getHeight(); j++) {
          Pixel canvasPixel = canvas.getPixel(i,j);
          Pixel messagePixel = message.getPixel(i,j);
          int redSource = canvasPixel.getRed();
          int greenSource = canvasPixel.getGreen();
          int blueSource = canvasPixel.getBlue();
          
          int targetRed = getMostSignificant2(messagePixel.getRed());
          int targetBlue = getMostSignificant2(messagePixel.getBlue());
          int targetGreen = getMostSignificant2(messagePixel.getGreen());
          System.out.println(targetRed);
          System.out.println(targetBlue);
          System.out.println(targetGreen);
          
          int canvasRed = embedDigits2(redSource, targetRed);
          int canvasBlue = embedDigits2(blueSource, targetBlue);
          int canvasGreen = embedDigits2(greenSource, targetGreen);
          
          canvasPixel.setRed(canvasRed);
          canvasPixel.setBlue(canvasBlue);
          canvasPixel.setGreen(canvasGreen);
          
          
        }  }
      
    }
    else 
    {
      /*if message is bigger than canvas both horizontally and vertically. it will be clipped
       * so the upper left segment of the message gets hidden in canvas and the rest is ignored */
      if (canvas.getWidth() < message.getWidth() && canvas.getHeight() < message.getHeight()) {  
        for (int i=x; i < canvas.getWidth();  i++) {
          for (int j=y; j < canvas.getHeight(); j++) {
            Pixel canvasPixel = canvas.getPixel(i,j);
            Pixel messagePixel = message.getPixel(i,j);
            int redSource = canvasPixel.getRed();
            int greenSource = canvasPixel.getGreen();
            int blueSource = canvasPixel.getBlue();
            
            int targetRed = getMostSignificant2(messagePixel.getRed());
            int targetBlue = getMostSignificant2(messagePixel.getBlue());
            int targetGreen = getMostSignificant2(messagePixel.getGreen());
            
            int canvasRed = embedDigits2(redSource, targetRed);
            int canvasBlue = embedDigits2(blueSource, targetBlue);
            int canvasGreen = embedDigits2(greenSource, targetGreen);
            
            canvasPixel.setRed(canvasRed);
            canvasPixel.setBlue(canvasBlue);
            canvasPixel.setGreen(canvasGreen);
            
            
          }
        }
      }
      
      
      else {
        
        /*if message is wider than the canvas but the canvas is taller than the message, only left side
         * of the message up to the width of the canvas will be hidden inside the top region of the canvas 
         up to the height of the message and the rest is ignored*/
        if (canvas.getWidth() < message.getWidth() && canvas.getHeight() > message.getHeight()) {  
          for (int i=x; i < message.getWidth();  i++) {
            for (int j=y; j < canvas.getHeight(); j++) {
              Pixel canvasPixel = canvas.getPixel(i,j);
              Pixel messagePixel = message.getPixel(i,j);
              int redSource = canvasPixel.getRed();
              int greenSource = canvasPixel.getGreen();
              int blueSource = canvasPixel.getBlue();
              
              int targetRed = getMostSignificant2(messagePixel.getRed());
              int targetBlue = getMostSignificant2(messagePixel.getBlue());
              int targetGreen = getMostSignificant2(messagePixel.getGreen());
              
              int canvasRed = embedDigits2(redSource, targetRed);
              int canvasBlue = embedDigits2(blueSource, targetBlue);
              int canvasGreen = embedDigits2(greenSource, targetGreen);
              
              canvasPixel.setRed(canvasRed);
              canvasPixel.setBlue(canvasBlue);
              canvasPixel.setGreen(canvasGreen);
            }
            
          }
          
        }
        
        
        /*if message is taller than the canvas but the canvas is wider than the message, only top side
         * of the message up to the height of the canvas will be hidden inside the left region of the canvas 
         up to the width of the message and the rest is ignored*/
        else {  
          for (int i=x; i < canvas.getWidth();  i++) {
            for (int j=y; j < message.getHeight(); j++) {
              Pixel canvasPixel = canvas.getPixel(i,j);
              Pixel messagePixel = message.getPixel(i,j);
              int redSource = canvasPixel.getRed();
              int greenSource = canvasPixel.getGreen();
              int blueSource = canvasPixel.getBlue();
              
              int targetRed = getMostSignificant2(messagePixel.getRed());
              int targetBlue = getMostSignificant2(messagePixel.getBlue());
              int targetGreen = getMostSignificant2(messagePixel.getGreen());
              
              int canvasRed = embedDigits2(redSource, targetRed);
              int canvasBlue = embedDigits2(blueSource, targetBlue);
              int canvasGreen = embedDigits2(greenSource, targetGreen);
              
              canvasPixel.setRed(canvasRed);
              canvasPixel.setBlue(canvasBlue);
              canvasPixel.setGreen(canvasGreen);
              
            }
            
          }
        }
      }
    }
    
    return canvas;
  }
  
  
  
  
  //Implement this method
  public static Picture recoverSecretMessage2Bits(Picture picWithMessage, int x, int y){
    
    Picture secretMessage = new Picture(picWithMessage);
    
    for (int i=x; i < picWithMessage.getWidth();  i++) {
      for (int j=y; j < picWithMessage.getHeight(); j++) {
        

        
        Pixel secretMessagePixel = secretMessage.getPixel(i,j);
        Pixel secretPix = picWithMessage.getPixel(i,j);
        
        int targetRed = secretPix.getRed();
        int targetBlue = secretPix.getBlue();
        int targetGreen = secretPix.getGreen();

        int messageRed = getLeastSignificant2(targetRed);
        int messageBlue = getLeastSignificant2(targetBlue);
        int messageGreen = getLeastSignificant2(targetGreen);
       
        messageRed = messageRed << 6;
        messageBlue = messageBlue << 6;
        messageGreen = messageGreen << 6;
        
        secretMessagePixel.setRed (messageRed);
        secretMessagePixel.setBlue (messageBlue);
        secretMessagePixel.setGreen (messageGreen);
        
        
      }
    }
    return secretMessage;
  }
  
  
  /*For hideSecretMessageNBits and recover SecretMessageNBits, we are doing the same as the hide SecretMessage2Bits and
   *recoverSecretMessageNBits but we are taking the N most significant values of the message and hiding it in the
   * context photo. After hiding it in the context photo we are recovering those N most significant values of the 
   * color pixels and recovering them. We test these out in PSA 6.java */
  
  public static Picture hideSecretMessageNBits(Picture context, Picture message, int N, int x, int y){ 
    
    Picture canvas = new Picture(context); 
    /*if the canvas is bigger than the message in both vertical and horizontal dimensions, the message should be hidden in the upper left 
     corner of the copy of the canvas which is starting (x,y)*/ 
    if (canvas.getWidth() > message.getWidth() && canvas.getHeight() > message.getHeight()) {   
      
      for (int i=x; i < context.getWidth();  i++) { 
        for (int j=y; j < context.getHeight(); j++) { 
          Pixel canvasPixel = canvas.getPixel(i,j); 
          Pixel messagePixel = message.getPixel(i,j); 
          int redSource = canvasPixel.getRed(); 
          int greenSource = canvasPixel.getGreen(); 
          int blueSource = canvasPixel.getBlue(); 
          
          int targetRed = getMostSignificantN(messagePixel.getRed(),N); 
          int targetBlue = getMostSignificantN(messagePixel.getBlue(),N); 
          int targetGreen = getMostSignificantN(messagePixel.getGreen(),N); 
          
          int canvasRed = embedDigitsN(redSource, targetRed, N); 
          int canvasBlue = embedDigitsN(blueSource, targetBlue, N); 
          int canvasGreen = embedDigitsN(greenSource, targetGreen, N); 
          
          canvasPixel.setRed(canvasRed); 
          canvasPixel.setBlue(canvasBlue); 
          canvasPixel.setGreen(canvasGreen); 
          
          
        }  } 
      
    } 
    else  
    { 
      /*if message is bigger than canvas both horizontally and vertically. it will be clipped 
       * so the upper left segment of the message gets hidden in canvas and the rest is ignored */ 
      if (canvas.getWidth() < message.getWidth() && canvas.getHeight() < message.getHeight()) {   
        for (int i=x; i < canvas.getWidth();  i++) { 
          for (int j=y; j < canvas.getHeight(); j++) { 
            Pixel canvasPixel = canvas.getPixel(i,j); 
            Pixel messagePixel = message.getPixel(i,j); 
            int redSource = canvasPixel.getRed(); 
            int greenSource = canvasPixel.getGreen(); 
            int blueSource = canvasPixel.getBlue(); 
            
            int targetRed = getMostSignificantN(messagePixel.getRed(), N); 
            int targetBlue = getMostSignificantN(messagePixel.getBlue(), N); 
            int targetGreen = getMostSignificantN(messagePixel.getGreen(), N); 
            
            int canvasRed = embedDigitsN(redSource, targetRed, N); 
            int canvasBlue = embedDigitsN(blueSource, targetBlue, N); 
            int canvasGreen = embedDigitsN(greenSource, targetGreen, N); 
            
            canvasPixel.setRed(canvasRed); 
            canvasPixel.setBlue(canvasBlue); 
            canvasPixel.setGreen(canvasGreen); 
            
            
          } 
        } 
      } 
      
      
      else { 
        
        /*if message is wider than the canvas but the canvas is taller than the message, only left side 
         * of the message up to the width of the canvas will be hidden inside the top region of the canvas  
         up to the height of the message and the rest is ignored*/ 
        if (canvas.getWidth() < message.getWidth() && canvas.getHeight() > message.getHeight()) {   
          for (int i=x; i < message.getWidth();  i++) { 
            for (int j=y; j < canvas.getHeight(); j++) { 
              Pixel canvasPixel = canvas.getPixel(i,j); 
              Pixel messagePixel = message.getPixel(i,j); 
              int redSource = canvasPixel.getRed(); 
              int greenSource = canvasPixel.getGreen(); 
              int blueSource = canvasPixel.getBlue(); 
              
              int targetRed = getMostSignificantN(messagePixel.getRed(), N); 
              int targetBlue = getMostSignificantN(messagePixel.getBlue(), N); 
              int targetGreen = getMostSignificantN(messagePixel.getGreen(), N); 
              
              int canvasRed = embedDigitsN(redSource, targetRed, N); 
              int canvasBlue = embedDigitsN(blueSource, targetBlue, N); 
              int canvasGreen = embedDigitsN(greenSource, targetGreen, N); 
              
              canvasPixel.setRed(canvasRed); 
              canvasPixel.setBlue(canvasBlue); 
              canvasPixel.setGreen(canvasGreen); 
            } 
            
          } 
          
        } 
        
        
        /*if message is taller than the canvas but the canvas is wider than the message, only top side 
         * of the message up to the height of the canvas will be hidden inside the left region of the canvas  
         up to the width of the message and the rest is ignored*/ 
        else {   
          for (int i=x; i < canvas.getWidth();  i++) { 
            for (int j=y; j < message.getHeight(); j++) { 
              Pixel canvasPixel = canvas.getPixel(i,j); 
              Pixel messagePixel = message.getPixel(i,j); 
              int redSource = canvasPixel.getRed(); 
              int greenSource = canvasPixel.getGreen(); 
              int blueSource = canvasPixel.getBlue(); 
              
              int targetRed = getMostSignificantN(messagePixel.getRed(), N); 
              int targetBlue = getMostSignificantN(messagePixel.getBlue(), N); 
              int targetGreen = getMostSignificantN(messagePixel.getGreen(), N); 
              
              int canvasRed = embedDigitsN(redSource, targetRed, N); 
              int canvasBlue = embedDigitsN(blueSource, targetBlue, N); 
              int canvasGreen = embedDigitsN(greenSource, targetGreen, N); 
              
              canvasPixel.setRed(canvasRed); 
              canvasPixel.setBlue(canvasBlue); 
              canvasPixel.setGreen(canvasGreen); 
              
            } 
            
          } 
        } 
      } 
    } 
    
    return canvas; 
  } 
  
  
   public static Picture recoverSecretMessageNBits(Picture picWithMessage, int N, int x, int y){
    
    Picture secretMessage = new Picture(picWithMessage);
    
    for (int i=x; i < picWithMessage.getWidth();  i++) {
      for (int j=y; j < picWithMessage.getHeight(); j++) {
        

        
        Pixel secretMessagePixel = secretMessage.getPixel(i,j);
        Pixel secretPix = picWithMessage.getPixel(i,j);
        
        int targetRed = secretPix.getRed();
        int targetBlue = secretPix.getBlue();
        int targetGreen = secretPix.getGreen();

       /* int messageRed = getLeastSignificantN(targetRed, N);
        int messageBlue = getLeastSignificantN(targetBlue, N);
        int messageGreen = getLeastSignificantN(targetGreen, N);
        

        secretMessagePixel.setRed (messageRed);
        secretMessagePixel.setBlue (messageBlue);
        secretMessagePixel.setGreen (messageGreen);
        */
        
      }
    }
    return secretMessage;
  }
  
  
  
  //Implement this method
  /* embedDigits2 will shift the binary code "messageVal" number of the times to the right which will
 * clear the least significant numbers by the value of "messageVal" and create a new binary number, we
 * then add back the messageVal to get the final number*/
  //This method removes the 2 least significant values by shifting them off the 8 bit binary and replaces it with messageVal
  public static int embedDigits2( int contextVal, int messageVal ){
    
    int newCode;
    newCode = contextVal >> messageVal;
    newCode = newCode << messageVal;
    return newCode + messageVal;
  }
  
  //Implement this method
  //replacing the messageVal for an interger between 1 and 8. It will shift the binary bits to the right by N and back to the left by N
  //adding the messageVal into the new binary of contextVal without the 2 least significant values
  public static int embedDigitsN( int contextVal, int messageVal, int N ){
    
    int newCode;
    newCode = contextVal >> N;
    //if ( 0 < N && N <= 8);
    //0 < messageVal && messageVal <= 2N-1);
    newCode = newCode << N;
    return newCode + messageVal;
  }
  
  //Implement this method
  /*finding the least significant values in the num input by taking the difference 
   between num and the num without the least significant values. We left our initial code because the thought process was the same. 
   The results come out to be correct in both methods*/
  public static int getLeastSignificant2( int num ){
    
    int newCode;
     int secondShift;
     newCode = num >> 2;
     secondShift = newCode << 2;
   // num = num % 4; 
    return secondShift;
  }
  
  public static int getMostSignificant2 (int num) {
    num = num >> 6;
    return num;
    
  }
  
  public static int getMostSignificantN (int num, int N) {
    num = num >> N;
    return num;
    
  }
  
  //Implement this method
  public static int getLeastSignificantN( int num, int N ){
    
    /* int newCode;
     int secondShift;
     if ( 0 < N && N <= 8);
     newCode = num >> N;
     secondShift = newCode << N;*/
    int expo = (int) Math.pow (2,N);
    num = num % expo;
    return num;
  }
  
}