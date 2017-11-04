
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawCircles extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private Point[] points;
	private Color[] colorArray;
	private int[] radiusArray;
	private int TOTAL = 500;
	private int currentIndex = 0;
	private Point mousePt;

	private static final int W = 640;
	private static final int H = 480;
	private Point origin = new Point(W / 2, H / 2);

	private Random randomNumber = new Random();

	private int currentRadius = 30;

	private Color getRandomColor() {
		return new Color(randomNumber.nextFloat(),
				randomNumber.nextFloat(), randomNumber.nextFloat());
	}


	public DrawCircles() {
		points = new Point[TOTAL];
		radiusArray = new int[TOTAL];
		colorArray = new Color[TOTAL];

		setBackground(Color.WHITE);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				mousePt = e.getPoint();
				repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				super.mouseReleased(e);
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int dx = e.getX() - mousePt.x;
				int dy = e.getY() - mousePt.y;
				origin.setLocation(origin.x + dx, origin.y + dy);
				mousePt = e.getPoint();
				if(currentIndex < 500) {
					points[currentIndex] =  new Point(e.getX(), e.getY());
					radiusArray[currentIndex] = currentRadius;
					colorArray[currentIndex] = getRandomColor();
					currentIndex +=1;
					repaint();
				}
				repaint();
			}
			
		});

		this.addKeyListener(this);
		this.setFocusable(true);

	}



	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//System.out.println("current radius " + currentRadius);
		for (int i = 0 ; i < currentIndex ; i++) {
			Point point  = points[i];
			g2.setColor(colorArray[i]);
			g2.fillOval(point.x, point.y, radiusArray[i], radiusArray[i]);
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		

	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		

	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		//System.out.println(String.valueOf(keyCode));
		switch( keyCode ) { 
		case KeyEvent.VK_UP:
			// handle up 
			if(currentRadius + 5 <= 150 ) {
				currentRadius += 5;
				repaint();
			}

			break;
		case KeyEvent.VK_DOWN:
			// handle down 
			if(currentRadius - 5 >= 20 ) {
				currentRadius -= 5;
				repaint();
			}
			break;
		
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.add(new DrawCircles());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(400, 400);
				frame.setVisible(true);
			}
		});
	}


}