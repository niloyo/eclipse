import java.util.Scanner;

public class Circle {
	
	private double radius;
	private final double PI = 3.14;
	
	
	public Circle() {
		super();
		this.radius = 0.0;
	}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return PI*radius*radius;
	}
	
	public double getDiamemeter() {
		return 2*radius;
	}
	
	public double getCircumference() {
		return 2*PI*radius;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius , which should a positive number ");
		double radius ;
		radius = sc.nextDouble();
		if(radius < 0) {
			System.out.println("radius is negative number ");
			return;
		}
		Circle circle = new Circle(radius);
		if(radius >= 0) {
			System.out.println("Area of circle is "+ circle.getArea());
			System.out.println("Diameter of circle is "+ circle.getDiamemeter() );
			System.out.println("Circumference of circle is "+ circle.getCircumference());
		}
	}
	
	
	
	

}
