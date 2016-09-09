
/** https://docs.oracle.com/javase/7/docs/api/java/awt/Button.html **\
 * Graphic interface
 * 
 * @Ian
 * @v.1.0
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class Basic extends Applet 
{
public void paint(Graphics g)
{
setBackground(Color.black);
g.setColor(Color.red);
Font whatever = new Font ("Bold", Font.BOLD, 26);
setFont(whatever);
g.drawString("Media Player", 50, 100);
}
/*songList object = new songList();
songList.myMethod();  // non static method*/
}