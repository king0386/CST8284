package cst8284.shape;

public class Rectangle extends Square {
	
	private double height;
	
	public Rectangle() {
		this(1.0, 1.0);
	}
	
	public Rectangle(double width, double height) {
		super(width);
		this.setHeight(height);
	}
	
	public Rectangle(Rectangle rectangle) {
		this(rectangle.getWidth(), rectangle.getHeight());
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	@Override
	public double getArea() {
		return(this.getWidth() * this.getHeight());
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (this.getWidth() + this.getHeight());
	}
	
	@Override
	public String toString() {
		return("Rectangle extends " + super.toString()); //There for my curiosity	
	}
	
	@Override
	public boolean equals(Object obj) {
		return((obj instanceof Rectangle) && (super.equals(obj)) && this.getHeight() == ((Rectangle)obj).getHeight());
	}
	
}
