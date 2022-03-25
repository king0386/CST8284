package test.cst8284.shape;

import static org.junit.Assert.*;

import org.junit.Test;
import cst8284.shape.*;

public class TestRectangle {

//	2. Using the new subclass you created in question 1, make JUnit tests to test the following:
//		a. Instantiate a Rectangle object and a Square object having equal width and height
//		(if comparing a Circle/Ellipse or Square/Rectangle) or length (if comparing Triangles),
//		and use assertEquals() to show that the two objects have the same perimeter to within 1e-12.
//	
//		b. Instantiate a Rectangle object and a Square object using the default constructor for each,
//		and use assertEquals() to show that the two objects have the same area to within 1e-12.
//		Of course, your unit test code should be in its own separate package. (2 marks ea.)
	
	
	Rectangle rectangle = new Rectangle(4.0, 4.0);
	Square square = new Square (4.0);
	
	Rectangle rectangle1 = new Rectangle();
	Square sqaure1 = new Square();
	
	@Test
	public void testRectangleSquarePerimeter() {
		assertEquals(square.getPerimeter(), rectangle.getPerimeter(), 1e-12);
		
	}
	
	@Test
	public void testRectangleSquareArea() {
		assertEquals(square.getArea(), rectangle.getArea(), 1e-12);
	}
	
	
}
