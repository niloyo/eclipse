import java.awt.*;
import java.util.Random;
import java.applet.*;
public class DrawingPolygons extends Applet
{
	private int HEIGHT = 800;
	private int WIDTH = 800;
	private int CENTERX = WIDTH/2;
	private int CENTERY = HEIGHT/2;
	private int count = 0;
	public void paint(Graphics g)
	{
		int height_triangle = (int)(Math.sqrt(3)*WIDTH/2.0);
		int x[] = { WIDTH/2, 0, WIDTH };
		int y[] = { 0, height_triangle, height_triangle };
		g.setColor(Color.CYAN);
		g.fillPolygon (x, y, 3);

		recursion(g, true, x[0], y[0], x[1], y[1], x[2], y[2]);

		this.setSize(WIDTH, HEIGHT);

	}

	private Random randomNumber = new Random();


	private Color getRandomColor() {
		return new Color(randomNumber.nextFloat(),
				randomNumber.nextFloat(), randomNumber.nextFloat());
	}

	float get_length(float x1, float y1, float x2, float y2) {
		return (float)Math.sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) );
	}

	public void recursion(Graphics g, Boolean orientation, float x1, float y1, float x2, float y2, float x3, float y3 ) {
		//System.out.println("incoming " + x1 + " " +  y1 + " " +  x2 + " " + y2 + " " + x3 
				//+ " " + y3 + orientation + " length" + get_length(x1, y1, x2, y2) );
		if(get_length(x1, y1, x2, y2) < 4) {
			// if length of a side less than 4 return
			return;
		}
		int[] x = new int[3];
		int[] y = new int[3];
		if(orientation) {
			// if orienation is upside , draw downside and vice versa
			// calculate the co-ordianates of all points
			x[0] = (int)(x2 + (x3-x2)/2.0);
			x[1] = (int) (x2 + (x3-x2)/4.0 );
			x[2] = (int) (x2 + 3.0*(x3-x2)/4.0) ;
			y[0]	=  (int)y2;
			y[1] = (int)(y1 + (y2-y1)/2.0);
			y[2] = y[1] ; 
			g.setColor(getRandomColor());
			g.fillPolygon (x, y, 3);


		}else {////
			x[0] =  (int)(x2 + (x3-x2)/2.0);
			x[1] = (int) (x2 + (x3-x2)/4.0 );
			x[2] = (int) (x2 + 3.0*(x3-x2)/4.0);
			y[0] = (int)y2;
			y[1] = (int)(y2 + (y1-y2)/2.0);
			y[2] = y[1];
			g.setColor(getRandomColor());
			g.fillPolygon (x, y, 3);
		}

		//orientation = !orientation;
		//System.out.println(x[0] + " " +  y[0] + " " +  x[1] + " " + y[1] + " " + x[2] 
			//	+ " " + y[2] + orientation + " length" + get_length(x1, y1, x2, y2) );
		// set orientation opposite
		recursion(g, !orientation, x[0], y[0], x[1], y[1], x[2], y[2]);
		


	}
}	