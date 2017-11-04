
// Cube.java
package ShareWithStudents;
import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintStream;

public class Cube
extends Square
implements I_threeD
{
	public Cube(Color color, String name, int side)
	{
		super(color, name, side);
	}

	public float computeVolume()
	{
		return mSide * mSide * mSide;
	}

	public void print() {
		System.out.println("Cube (" + mName + ") side : " + mSide + " and color : " + mColor.toString());
	}

	public void paint(Graphics g)
	{
		int step = 20;
	}
}

