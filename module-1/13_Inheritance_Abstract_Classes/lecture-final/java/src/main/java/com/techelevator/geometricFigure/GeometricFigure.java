package com.techelevator.geometricFigure;

public abstract class GeometricFigure {

	private int height;
	private int width;
	private String figureType;
	
	public GeometricFigure(int height, int width, String figureType) {
		this.height = height;
		this.width = width;
		this.figureType = figureType;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String getFigureType() {
		return figureType;
	}
	
	public String toString() {
		return "This " + figureType + " is " +
			width + " by " + height + " and has an area of " +
				getArea();
	}

	public abstract double getArea();
	
}
