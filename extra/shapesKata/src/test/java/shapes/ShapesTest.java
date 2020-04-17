package shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShapesTest {

	@Test
	public void edge_returns_correct_length() {
		
		Edge edge = new Edge(5);
		
		assertEquals(5, edge.getLength());
		
	}
	
	@Test
	public void rectangle_returns_correct_area() {
		
		Shape rectangle = new Rectangle(2, 5);
		double actualArea = rectangle.calculateArea();
		assertEquals(10, actualArea, 0.0);
		
	}
	
	@Test
	public void circle_returns_correct_area() {
		
		Shape circle = new Circle(2);
		double actualArea = circle.calculateArea();
		assertEquals(Math.PI * Math.pow(2, 2), actualArea, 0.0);
	}

}
