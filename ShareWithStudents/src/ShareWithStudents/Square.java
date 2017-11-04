package ShareWithStudents;
import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintStream;
public class Square
extends Shape
implements I_twoD
{
	protected int mSide;

	Square(Color color, String name, int side)
	{
		super(color, name);
		mSide = side;
	}

	public float computeArea()
	{
		return mSide * mSide;
	}

	public float computePerimeter()
	{
		return 4.0F * mSide;
	}

	public void print() {
		System.out.println("Square (" + mName + ") side : " + mSide + " and color : " + mColor.toString());
	}

	public void paint(Graphics g) {}
}