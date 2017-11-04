// Assignment4.java
package ShareWithStudents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

public class Assignment4 extends JFrame implements MouseListener {
	final int NUMBER_OF_SHAPES = 3;

	JToolBar mToolbar;
	ShapeSelected mSelectedAction;
	JToggleButton mCircleButton;
	JToggleButton mCubeButton;
	JToggleButton mSquareButton;
	DrawPanel mDrawPanel;
	static ArrayList mShapes = new ArrayList();

	public static void main(String[] args) {
		new Assignment4();
	}

	private JToggleButton addButton(String title, final ShapeSelected shapeSelected)
	{
		JToggleButton button = new JToggleButton(title);
		button.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == 1)
				{
					switch (Assignment4.3.$SwitchMap$ShareWithStudents$ShapeSelected[mSelectedAction.ordinal()]) {
					case 1:
						mCircleButton.setSelected(false);
						break;
					case 2:
						mCubeButton.setSelected(false);
						break;
					case 3:
						mSquareButton.setSelected(false);
					}


					mSelectedAction = shapeSelected;
				}
				else if (ev.getStateChange() == 2) {
					mSelectedAction = ShapeSelected.None;
				}

			}
		});
		mToolbar.add(button);

		return button;
	}

	public Assignment4() {
		int WIDTH = 1000;
		int HEIGHT = 800;

		mSelectedAction = ShapeSelected.None;

		JFrame guiFrame = new JFrame();

		guiFrame.setDefaultCloseOperation(3);
		guiFrame.setTitle("SHAPE GUI");
		guiFrame.setSize(1000, 800);

		guiFrame.setLocationRelativeTo(null);

		mToolbar = new JToolBar();
		mToolbar.setBorder(new EtchedBorder());

		mDrawPanel = new DrawPanel();

		mDrawPanel.setBackground(Color.blue);
		mDrawPanel.paintDisplay(mShapes);

		guiFrame.add(mDrawPanel);
		guiFrame.add(mToolbar, "North");

		mCircleButton = addButton("Circle", ShapeSelected.Circle);
		mCubeButton = addButton("Cube", ShapeSelected.Cube);
		mSquareButton = addButton("Square", ShapeSelected.Square);

		JButton button = new JButton("Quit");
		button.setToolTipText("Quit the program");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mToolbar.add(button);

		guiFrame.addMouseListener(this);

		guiFrame.setVisible(true);
	}

	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();

		switch (3.$SwitchMap$ShareWithStudents$ShapeSelected[mSelectedAction.ordinal()]) {
		case 1:
			Circle circle = new Circle(Color.yellow, "crl", 50);
			circle.setPos(x, y - 50);
			mShapes.add(circle);
			break;
		case 2:
			Cube cube = new Cube(Color.red, "cb", 100);
			cube.setPos(x, y - 50);
			mShapes.add(cube);
			break;
		case 3:
			Square square = new Square(Color.green, "sq", 100);
			square.setPos(x, y - 50);
			mShapes.add(square);
		}


		mDrawPanel.paintDisplay(mShapes);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
