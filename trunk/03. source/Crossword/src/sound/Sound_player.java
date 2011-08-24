/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author NickOcean
 */
//Create Sound Player
public class Sound_player {
    //Create Clip Object
    Clip clip;
    public Clip Player(){
        //Create one Thread
        Thread thread=new Thread(new Runnable() {
         public void run() {
         //Create File object
         File file = new File("src/sound/Endless love - Edition.wav");
         //Create AudioInputStream Object
         AudioInputStream ain =null;
         try{
            ain=AudioSystem.getAudioInputStream(file);
            DataLine.Info info =new DataLine.Info(Clip.class,ain.getFormat( ));
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ain);
         }catch(Exception e){}
         finally {
            try {
                    ain.close();
                } catch (IOException ex) {   }
            }
        }
        });
        thread.start();
        try {
            thread.join();
            // audioLength = (int)(clip.getMicrosecondLength( )/1000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Game_4x4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clip;
    }
   
}
