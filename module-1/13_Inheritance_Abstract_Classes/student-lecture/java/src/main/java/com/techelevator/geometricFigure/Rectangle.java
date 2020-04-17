package com.techelevator.geometricFigure;

public class Rectangle extends GeometricFigure {

	public Rectangle(int height, int width) {
		super(height, width, "Rectange");
		
	}

	@Override
	public double getArea() {
		return (super.getWidth() * super.getHeight());
	}

}
