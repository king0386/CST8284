package cst8284.solidObject;

public class Triangle extends BasicShape {
	
	public Triangle() {
		this(1.0);
	}
	
	public Triangle(double width) {
		super(width);
	}
	
	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}
	
	@Override
	public double getArea() {
		return((Math.sqrt(3)/4) * (getWidth() * getWidth()));
	}
	
	@Override
	public double getPerimeter() {
		return(3 * getWidth());
	}
	
	@Override
	public String toString() {
		return("Triangle extends " + super.toString());
	}
	
	@Override
	public boolean equals(Object obj) {
		return((obj instanceof Triangle) && ((Triangle)obj).getWidth() == this.getWidth());
		
//		if(!(obj instanceof Triangle))
//			return false;
//		Triangle triangle = new Triangle((Triangle)obj);
//		return (triangle.getWidth() == this.getWidth());
	}
}
