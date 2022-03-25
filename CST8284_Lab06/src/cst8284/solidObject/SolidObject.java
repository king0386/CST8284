package cst8284.solidObject;

public class SolidObject<T extends BasicShape> {

	// TODO: Use the UML diagram to create the members required in the space below

	private T shape;
	private double depth;
	
	protected SolidObject(T shape, double depth) {
		
		this(shape);
		this.setDepth(depth);
	}
	
	protected SolidObject(T shape) {
	
		this.setBasicShape(shape);
		this.setDepth(shape.getWidth());
	}
	
	public double getDepth() {
		return depth;
	}
	
	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	public T getBasicShape() {
		return shape;
	}
	
	public void setBasicShape(T shape) {
		this.shape = shape;
	}
	
	public double getVolume() {
		return (this.getBasicShape().getArea() * this.getDepth());
	}
	
	public double getSurfaceArea() {
		return (this.getBasicShape().getPerimeter() * this.getDepth() + this.getBasicShape().getArea() * 2);
	}
	
	
	
	// the toString() method is provided for you -- do not remove
	public String toString() {
		String solidTypeEquivalent = "unknown   ";
		switch (getBasicShape().getClass().getSimpleName()) { //changed getShape to getBasicShape
		   case "Circle": solidTypeEquivalent = "cylinder "; break;
		   case "Square": solidTypeEquivalent = "block     "; break;
		   case "Triangle": solidTypeEquivalent = "prism    "; break;
		}
		return solidTypeEquivalent;
	}

}
