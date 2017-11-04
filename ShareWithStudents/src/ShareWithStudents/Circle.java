// Circle.java
package ShareWithStudents;
import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintStream;
public class Circle
extends Shape
implements I_twoD
{
	private int mRadius;

	public Circle(Color color, String name, int radius)
	{
		super(color, name);
		mRadius = radius;
		mX = -1;
		mY = -1;
	}

	public float computeArea()
	{
		return (float)(3.141592653589793D * mRadius * mRadius);
	}

	public float computePerimeter()
	{
		return (float)(6.283185307179586D * mRadius);
	}

	public void print()
	{
		System.out.println("Circle (" + mName + ") radius : " + mRadius + " and color : " + mColor.toString());
	}

	public void paint(Graphics g) {}
}