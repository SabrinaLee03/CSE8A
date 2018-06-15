/* Filename: PSA7A.java
 * Created by: Sabrina Lee (cs8awaer) and Donald Truong (cs8awafv)
 * Date: February 28, 2017
 */ 
public class PSA7A
{
//The line below is magic, you don't have to understand it (yet)
  public static void main (String[] args)
  {
    
    /*PSA7A tests the concatenate method after choosing the three sound waves
     * it runs the method on those sounds and creates the new sound file
     */
    
//picking the calling object (the original soundclip) the sound clipi that we are modifying
    Sound silent = new Sound(FileChooser.pickAFile()); 
    
//picking the first sound file
    Sound sound1 = new Sound(FileChooser.pickAFile());
    
// picking the second sound file
    Sound sound2 = new Sound(FileChooser.pickAFile());
    
// playing the sound1 file chosen for the beginning portion
    sound1.blockingPlay();
    
//playing the second sound file for the second half of the final sound
    sound2.blockingPlay();
    
    
//getting the details of the resulting sound wave and playing it with blocking play 
//a new sound that was created with the modified silent wave
//running the concatenate method onto the silent sound and creating a switchpoint
    silent.concatenateSound(sound1, sound2, sound1.getLength());
    
    silent.explore();
    silent.blockingPlay();
    
    
  }
}
