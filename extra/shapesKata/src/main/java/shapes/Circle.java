package shapes;

public class Circle implements Shape {

	Edge radius;

	public Circle(int r) {
		this.radius = new Edge(r);
	}

	public double calculateArea() {
		return Math.PI * Math.pow(this.radius.getLength(), 2);
	}

}
