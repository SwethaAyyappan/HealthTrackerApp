import java.awt.*;
import javax.swing.*;


public class Javaapplet extends JApplet {
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.drawString("WELCOME TO APPLETS",50,50);
		g.drawLine(20,30, 20, 300);
		
		g.setColor(Color.red);
		g.drawRect(70, 100, 30, 30);
	}

}
