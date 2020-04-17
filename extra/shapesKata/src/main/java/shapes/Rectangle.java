package shapes;

public class Rectangle implements Shape {

	Edge length;
	Edge width;
	
	
	public Rectangle(int x, int y) {
		this.length = new Edge(x);
		this.width = new Edge(y);
	}


	public double calculateArea() {
		return this.length.getLength() * this.width.getLength();
	}

}
