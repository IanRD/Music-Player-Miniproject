package AudioPlayer;
import javax.sound.sampled.*;
import java.lang.Object;
import java.io.File;
import java.net.URL;


/**
 * Audio playback
 * 
 * @Ian Dawson  
 * @v.1.0
 */
public class AudioPlayback
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class AudioPlayback
     */
    public AudioPlayback()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * reads the stuff and things
     * 
     * @int 
     * @returns something or maybe not
     */
    public void AudioPlayback()
    {
        int intFramesRead = 0;
        File fileIn = new File("ltf.mp3");

        try {
          AudioInputStream audioInputStream = 
            AudioSystem.getAudioInputStream(fileIn);
          int intBytesPerFrame = 
            audioInputStream.getFormat().getFrameSize();
            if (intBytesPerFrame == AudioSystem.NOT_SPECIFIED) {
            // some audio formats may have unspecified frame size
            // in that case we may read any amount of bytes
            intBytesPerFrame = 1;
          } 
          // Set an arbitrary buffer size of 1024 frames.
          int intNumBytes = 1024 * intBytesPerFrame; 
          byte[] audioBytes = new byte[intNumBytes];
          try {
            int intNumBytesRead = 0;
            int intnumFramesRead = 0;
            // Try to read intNumBytes bytes from the file.
            while ((intNumBytesRead = 
              audioInputStream.read(audioBytes)) != -1) {
              // Calculate the number of frames actually read.
              intnumFramesRead = intNumBytesRead / intBytesPerFrame;
              intFramesRead += intnumFramesRead;
              // Here, do something useful with the audio data that's 
              // now in the audioBytes array...
            }
          } catch (Exception ex) { 
            // Handle the error...
          }
        } catch (Exception e) {
          // Handle the error...
        }
        // put your code here
        // from a wave File
        
        File soundFile = new File("ltf.mp3");
        try{
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
    }
        catch(Exception e)
        {
        }
        // from a URL
        //URL url = new URL("http://www.zzz.com/eatfood.wav");
        //AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        // can read from a disk file and also a file contained inside a JAR (used for distribution)
        // recommended
        //URL url = this.getClass().getClassLoader().getResource("eatfood.wav");
        //AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        // start()
        clip.start();  
        // play once
        // repeat none (play once), can be used in place of start().
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
        if (clip.isRunning()) clip.stop();

     
    }
}
