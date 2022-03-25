package cst8284.solidObject;

public class Circle extends BasicShape {

	public Circle() {
		this(1.0);
	}
	
	public Circle(double width) {
		super(width);
	}
	
	public Circle(Circle circle) {
		this(circle.getWidth());
	}
	
	@Override
	public double getArea() {
		return(Math.PI * ((this.getWidth() * this.getWidth())/4));
	}
	@Override
	public double getPerimeter() {
		return(Math.PI * (this.getWidth()));
	}
	@Override
	public String toString() {
		return("Circle extends " + super.toString());
	}
	@Override
	public boolean equals(Object obj) {
		return((obj instanceof Circle) && ((Circle)obj).getWidth() == this.getWidth());
		
//		if(!(obj instanceof Circle))
//			return false;
//		Circle circle = new Circle((Circle)obj);
//		return (circle.getWidth() == this.getWidth());
		
//		if(obj instanceof Circle) {
//			BasicShape shape = (Circle)obj;
//			if(shape.getWidth() == this.getWidth())
//				return true;
//		
//		}
//		return false;
	}
}
