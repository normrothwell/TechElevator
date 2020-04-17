package com.techelevator.geometricFigure;

public class Rectangle extends GeometricFigure {

	public Rectangle(int height, int width) {
		super(height, width, "Rectangle");
	}

	@Override
	public double getArea() {
		return super.getHeight() * super.getWidth();
	}

}
