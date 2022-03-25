package cst8284.genericTable;

public abstract class BasicShape implements Comparable<BasicShape> {
	
	private double width;
	protected BasicShape(double width) {setWidth(width);}
	
	public double getWidth(){return width;}
	public void setWidth(double width){this.width = width;}
			
	@Override
	public String toString(){
		return ("BasicShape extends " + super.toString());
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
	public abstract int compareTo();
}
