/* Filename: PSA6.java 
 * Created by: Sabrina Lee cs8awaer and Dennis Bui cs8awaaj
 * Date: February 21, 2017 
 * 
 * Tested the methods through PSA 6 by selecting the M&M photo and taking the cookie monster photo.
 * We want to take the cookie monsters most significant values for the red green and blue and input it in the 
 * M&M photos least significant values. We check if the method work by comparing the pixel value (concentration)
 * for each red green and blue in the final M&M photo by using the explore image.
 * 
 * For hideSecretMessageNBits and recoverSecretMessageNBits, we are doing the same as the hide SecretMessage2Bits and
 * recoverSecretMessageNBits but we are taking the N most significant values of the message and hiding it in the
 * context photo. After hiding it in the context photo we are recovering those N most significant values of the 
 * color pixels and recovering them. We test these out in PSA 6.java
 * 
 * 
 */ 
public class PSA6 extends Picture
{ 
//The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args) 
  { 
    
    String contextPic = FileChooser.pickAFile();
    Picture context = new Picture(contextPic);
    context.explore();
    String messagePic = FileChooser.pickAFile();
    Picture message = new Picture(messagePic);
    message.show();
    Picture myPicWithMessage= Picture.hideSecretMessage2Bits( context, message, 0, 0);
    myPicWithMessage.explore(); 
    
    
   /* String recoverPic = FileChooser.pickAFile(); */
    Picture recoverPicture = context.recoverSecretMessage2Bits(myPicWithMessage, 100, 100);
    recoverPicture.show();
    

Picture contextWithMsg = Picture.hideSecretMessage2Bits(context,message, 0, 0);

contextWithMsg.write(System.getProperty("user.home")+"/my_picture_with_hidden_message.bmp");

Picture msg = Picture.recoverSecretMessage2Bits(myPicWithMessage, 0, 0);

msg.write(System.getProperty("user.home")+"/my_hidden_message.bmp");
    
  } 
}


