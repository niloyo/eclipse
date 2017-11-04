// DrawPanel.java
package ShareWithStudents;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

class DrawPanel
extends JPanel
{
	ArrayList mShapes;

	DrawPanel() {}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Shape s : mShapes) {
			s.paint(g);
		}
	}

	public void paintDisplay(ArrayList shapes) {
		mShapes = shapes;
		repaint();
	}
}
