/* Filename: Slide.java 
 * Created by: Sabrina Lee cs8awaer and Dennis Bui cs8awaaj
 * Date: March 14, 2017 
 * 
 * This is copied from a previous PSA
 * We are using the reverseSound method that was previously created
 * We will be using this to modify the sound in the individual slides
 * depending on if the probability fits the conditions in slideShow.java
 * 
 */ 

/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound
{
  
  /////////////// consructors ////////////////////////////////////
  
  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }
  
  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }
  
  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }
  
  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }
  
  ////////////////// methods ////////////////////////////////////
  
  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();
    
    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;
    
    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();
    
    return output;
  }
  
  /**
   *
   */
  public void concatenateSound (Sound firstSound, Sound secondSound, int switchPoint)
  {
    /* here we are grabbing the sound arrays of the three files that we want to use
     * in altering and creating the final sound. because this method is void
     * it does not return anything new. it just returns a modified
     * version of the sound that we are changing
     */
    SoundSample [] original = this.getSamples();
    SoundSample [] array1 = firstSound.getSamples();
    SoundSample [] array2 = secondSound.getSamples();
    
    /*wherever the sound1 file that we will be choosing is before the switchpoint
     *we will be grabbing the array from there and altering the silent sound
     *after the silent sound has been altered, then we need to find the starting point
     * of the second sound on the silent sound, which is what we will be returning in the end
     */
    int x = 0;
    for (int i=0; i < original.length; i++)
    {
      /*this creates the condition on where to start the second sound on the
       * altered silent sound file. if the end of the first sound comes before 
       * the switchpoint indicated, it will start the second sound there and create
       * a blend. in the else statement it indicates to start the second sound at the
       * switchpoint if that comes first
       */
      if (i < array1.length && i < switchPoint) {
        int value = array1[i].getValue();
        original[i].setValue(value);
      }
      else if (x < array2.length){
        int valueSecond = array2[x].getValue();
        original[i].setValue(valueSecond);
        x++;
      }
      else{
        original[i].setValue(0);
      }
    }
    
  }
  
  public Sound reverseSound()
  {
    
    //making a copy of the sound that we are choosing
    Sound originalSound = new Sound (this);
    
    SoundSample [] original = this.getSamples();
    SoundSample [] copySound = originalSound.getSamples();
    //getting the interger length in order to from the end of the sound array
    int soundLength = this.getLength();
    
    for (int i = 0; i < soundLength; i++)
    {
      int tempSound = original[soundLength - 1 - i].getValue();
      copySound[soundLength - 1 -i].setValue (original[i].getValue());
      copySound[i].setValue(tempSound);
      
      //this returns the new sound that we have created
    }
    return originalSound;
    
  }
  
  
  /*Increasing the volume by increasing the int value of each index
   * the for loop runs through each index of the sample array and
   * takes the value, multiplies it by the user's input value
   * by making it a double, it allows the user to increase
   * the volume by a certain percent
   */ 
  public void changeVolume (double input)
  {
    SoundSample [] sampleArray = this.getSamples();
    SoundSample sample = null;
    int value;
    
    for (int index = 0; index < sampleArray.length; index++)
    {
      sample = sampleArray[index];
      value = sample.getValue();
      sample.setValue((int) (value *input));
    }
  }
  
  public void findMax
  {
    int max = valueArray[0];
    
    for (int index = 0; index < valueArray.length; index++)
    {
      if (Math.abs(valueArray[index] > Math.abs(max))
            max = valueArray[index];
          }

public void normalize ()
{
 SoundSample [] sampleArray = this.getSamples();
 SoundSample sample = sampleArray [0];
 
 int value;
 int meax = soundSamples.getValue();
 
 for (int index = 1; index < sampleArray.length; index++)
 {
   sample = sampleArray[index];
   value = sample.getValue();
 }
 
 if (Math.abs(value) > Math.abs(max))
 {
   max = value;
   maxIndex = i;
 }
 
 System.out.println ("largest" +max+ "at index" +maxIndex);
 
 double multiplier = 32767.0 / max;
 this.changeVolume(multiplie);

}

public Sound clip (int start, int end)
{
  int numSamples = end - start +1;
  Sound target = new Sound(numSamples);
  
  int val;
  int targetIndex;
  
  for ( int index = start; index <= end; index++, targetIndex++)
  {
    value = this.getSampleValueAt(index);
    target.setSampleValueAt(targetIndex, val);
  }
  
  return target;
  
}


  
  
}// this } is the end of class Sound, put all new methods before this
