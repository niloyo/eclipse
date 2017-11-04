// Shape.java
package ShareWithStudents;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape
{
	protected Color mColor;
	String mName;
	protected int mX;
	protected int mY;

	public Shape(Color color, String name)
	{
		mColor = color;
		mName = name;
	}

	public String getName() {
		return mName;
	}

	public Color getColor() {
		return mColor;
	}

	public void setName(String name) {
		mName = name;
	}

	public void setColor(Color color) { mColor = color; }

	public abstract void print();

	public abstract void paint(Graphics paramGraphics);

	public void setPos(int x, int y) {
		mX = x;
		mY = y;
	}
}