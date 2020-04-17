package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		
		List<FlowerShopOrder> orders = new ArrayList<>();
		FlowerShopOrder dailyOrder = new FlowerShopOrder("Roses", 2);
		File document = new File(".\\data-files\\FlowerInput.csv");
		double orderTotal = 0;
		
		try {
			Scanner input = new Scanner(document);
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] individualOrder = line.split(",");
				int flower = Integer.parseInt(individualOrder[1]);
				orders.add(new FlowerShopOrder(individualOrder[0], flower));
		}
		
		for (FlowerShopOrder flowers:orders) {
			double orderCost = dailyOrder.flowerCost(flowers.getNumRoses());
			System.out.println(String.format("The cost for the " + flowers.getBouquetType() + " bouqet with " + flowers.getNumRoses() + " roses is $" + "%.2f", orderCost));
			
		}
		

		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

}
}
