import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.media.*;
import java.lang.Object.*;
import java.lang.reflect.*;

public class MediaPlayerDemo extends JFrame {
  public static void main(String args[]) {
    Player player;
    File file = new File("enough.wav");
    player = Manager.createRealizedPlayer(file.toURI().toURL());
    player.addControllerListener(new EventHandler());
    player.start(); // start player
    
    player.close();

    Component visual = player.getVisualComponent();
    Component control = player.getControlPanelComponent();
                                   }
                                         }
                  
                                           
 