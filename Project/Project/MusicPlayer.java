/**
 * Media Player
 * 
 * @Ian Dawson
 * @1.0
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
import sun.audio.*;

public class MusicPlayer extends Thread implements ActionListener {

    //Actions for the JFrame (javax)
    JComboBox playlist;
    JButton play, loop, stop, open, open2;
    JFrame playerFrame;
    
    //Audio input
    AudioInputStream songInput;
    Clip songClip;
    Clip songClipDos; //2Clipz!!
    File songFile;
    
    //File
    String filePath, str;
    JTextField tf;
    URL u;
    
    /**
     * Music player layout
     * Pre: extends thread from javax
     * none
     * returns none
     */
    MusicPlayer() {
        playerFrame = new JFrame("DawsonBox 2.0");
        playerFrame.setLayout(null);
        playerFrame.setSize(640, 300);
        playerFrame.setVisible(true);
        playerFrame.getContentPane().setBackground(Color.cyan);  //Whatever color
        
        tf = new JTextField();
        tf.setBounds(25, 50, 565, 40); //Box bounds
        tf.setFont(new Font("Arial", Font.BOLD, 20));
        
        playerFrame.add(tf);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        play = new JButton("play");
        play.setBounds(100, 150, 100, 30); //Play button position relative to the frame
        
        play.addActionListener(this);
        playerFrame.add(play);
        
        loop = new JButton("loop");
        loop.setBounds(250, 150, 100, 30);
        loop.addActionListener(this); //Loop button position relative to the frame
        
        playerFrame.add(loop);
        stop = new JButton("stop");
        stop.setBounds(400, 150, 100, 30);
   
        stop.addActionListener(this);
        playerFrame.add(stop); //Stop button position relative to the frame
        
        open = new JButton("open");
        open.setBounds(100, 200, 400, 30); //Open button position relative to the frame
        
        open2 = new JButton("open2");
        open2.setBounds(100, 100, 400, 30); //Open button position relative to the frame
        
        open.addActionListener(this);
        playerFrame.add(open);
        playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close
        open2.addActionListener(this);
        playerFrame.add(open2);
        playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close
        
    }

     /**
     * Performs actions for music player
     * Pre: MusicPlayer, javax
     * ActionEvent ae, needed to perform
     * returns none
     */
    public void actionPerformed(ActionEvent ae) {
        String filePath;
        
        if (ae.getActionCommand().equals("open")) {
            FileDialog fd = new FileDialog(playerFrame, "Open Box", FileDialog.LOAD);
            fd.setSize(300, 300);
            fd.setVisible(true);
            String s1 = "ltf.wav";
            String sng = fd.getFile();
            filePath = fd.getDirectory() + fd.getFile();
            if (sng.toLowerCase().endsWith(s1)) { //Error message
                tf.setText(sng);
                songFile = new File(filePath);
            } else {
                JOptionPane.showMessageDialog(playerFrame, "GUH A LA BUH");
            }
            try {
                songClip = AudioSystem.getClip();
                songFile = new File(filePath);
                songInput = AudioSystem.getAudioInputStream(songFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if (ae.getActionCommand().equals("open2")) {
            FileDialog fd = new FileDialog(playerFrame, "Open Box", FileDialog.LOAD);
            fd.setSize(300, 300);
            fd.setVisible(true);
            String s1 = "go.wav";
            String sng = fd.getFile();
            String sng2 = fd.getFile();
            filePath = fd.getDirectory() + fd.getFile();
            if (sng.toLowerCase().endsWith(s1)) { //Error message
                tf.setText(sng);
                tf.setText(sng2);
                songFile = new File(filePath);
                songFile = new File(filePath);
            } else {
                JOptionPane.showMessageDialog(playerFrame, "GUH A LA BUH");
            }
            try {
                songClip = AudioSystem.getClip();
                songFile = new File(filePath);
                songInput = AudioSystem.getAudioInputStream(songFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        if (ae.getActionCommand().equals("play")) { //Play
            try {
                songInput = AudioSystem.getAudioInputStream(songFile);
                songClip.close();
                songClip = AudioSystem.getClip();
                songClip.open(songInput);
                songClip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if (ae.getActionCommand().equals("loop")) { //Loop
            try {
                songInput = AudioSystem.getAudioInputStream(songFile);
                songClip.close();
                songClip = AudioSystem.getClip();
                songClip.open(songInput);
                songClip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if (ae.getActionCommand().equals("stop")) { //Stop
            songClip.stop();
            songClip.close();

        }
    }

    public static void main(String args[]) {
        new MusicPlayer();
    }
}
