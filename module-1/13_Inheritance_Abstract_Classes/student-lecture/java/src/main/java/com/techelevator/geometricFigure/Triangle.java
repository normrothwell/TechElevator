package com.techelevator.geometricFigure;

public class Triangle extends GeometricFigure {

	public Triangle(int height, int width) {
		super(height, width, "Triangle");
		
	}

	@Override
	public double getArea() {
		
		return ((super.getHeight() * super.getWidth()) * 0.5);
	}

}
