package com.techelevator.geometricFigure;

public class Triangle extends GeometricFigure {

	
	public Triangle(int height, int width) {
		super(height, width, "Triangle");
	}

	@Override
	public double getArea() {
		return 0.5 * super.getHeight() * super.getWidth();
	}


}
