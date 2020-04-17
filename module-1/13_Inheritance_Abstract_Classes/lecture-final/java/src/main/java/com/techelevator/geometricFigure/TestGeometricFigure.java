package com.techelevator.geometricFigure;

import java.util.ArrayList;
import java.util.List;

public class TestGeometricFigure {

	public static void main(String[] args) {
		List <GeometricFigure> figureList = new ArrayList<>();
		
		figureList.add(new Rectangle(2, 4));
		figureList.add(new Triangle(4, 2));
		figureList.add(new Rectangle (6, 10));
		figureList.add(new Triangle (10, 6));
		
		for (int i = 0; i < figureList.size(); i++) {
			System.out.println(figureList.get(i).toString());
		}
		
		System.out.println("\nWith a for each loop:");
		for (GeometricFigure figure: figureList) {
			System.out.println(figure);  // toString is the default
		}

	}

}
