package cst8284.solidObject;

public class Square extends BasicShape {
	
	public Square() {
		this(1.0);
		
	}
	
	public Square(double width) {
		super(width);
		
	}
	
	public Square(Square square) {
		this(square.getWidth());
		
	}
	@Override
	public double getArea() {
		return(this.getWidth() * this.getWidth());
		
	}
	@Override
	public double getPerimeter() {
		return(4 * getWidth());
		
	}
	
	@Override
	public String toString() {
		return("Square extends " + super.toString());
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return((obj instanceof Square) && ((Square)obj).getWidth() == this.getWidth());
		//return (super.equals(obj) || (^))
		
//		if(!(obj instanceof Square))
//			return false;
//		Square square = new Square((Square)obj);
//		return (square.getWidth() == this.getWidth());
	}
}
