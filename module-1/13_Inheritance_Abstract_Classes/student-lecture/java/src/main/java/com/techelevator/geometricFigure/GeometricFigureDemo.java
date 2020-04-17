package com.techelevator.geometricFigure;

import java.util.ArrayList;
import java.util.List;

public class GeometricFigureDemo {

	public static void main(String[] args) {
		List <GeometricFigure> figures = new ArrayList<>();
		
		figures.add(new Rectangle (2, 4));
		figures.add(new Triangle (4, 2));
		figures.add(new Rectangle (6, 10));
		figures.add(new Triangle (10, 6));
		
		
		for (GeometricFigure figure: figures) {
			System.out.println(figure);
		}
	}

}
