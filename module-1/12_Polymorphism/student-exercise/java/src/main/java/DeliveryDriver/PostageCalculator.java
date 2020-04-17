package DeliveryDriver;

import java.util.Scanner;

public class PostageCalculator {

	public static void main(String[] args) {
		
		double weightInOunces = 0;
		double weightInPounds = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the weight of the package: ");
		double weight = Double.parseDouble(input.nextLine());
		System.out.println("Is this in (p)ounds or (o)unces: ");
		String weightType = input.nextLine();
		
		if (weightType.equals("p") || weightType.equals("P")){
			weightInOunces = weight*16;
			weightInPounds = weight;
		}else if (weightType.equals("o") || weightType.equals("O")) {
			weightInOunces = weight;
			weightInPounds = weight/16;
		}else System.out.println("Please enter a valid weight type");
		
		System.out.println("Please enter how far this package is traveling in miles: ");
		int distance = Integer.parseInt(input.nextLine());
		
		
		FedEx fedex = new FedEx();
		PostalServiceFirstClass firstClass = new PostalServiceFirstClass();
		PostalServiceSecondClass secondClass = new PostalServiceSecondClass();
		PostalServiceThirdClass thirdClass = new PostalServiceThirdClass();
		SPUFourDay fourDay = new SPUFourDay();
		SPUTwoDay twoDay = new SPUTwoDay();
		SPUNextDay nextDay = new SPUNextDay();
		
		
		
		
		
		
		System.out.println(firstClass.service() + "\t$" + String.format("%.2f", firstClass.calculateRate(distance, weightInOunces)));
		System.out.println(secondClass.service() + "\t$" + String.format("%.2f", secondClass.calculateRate(distance, weightInOunces)));
		System.out.println(thirdClass.service() + "\t$" + String.format("%.2f", thirdClass.calculateRate(distance, weightInOunces)));
		System.out.println(fedex.service() + "\t\t\t\t$" + String.format("%.2f", fedex.calculateRate(distance, weightInOunces)));
		System.out.println(fourDay.service() + "\t\t\t$" + String.format("%.2f", fourDay.calculateRate(distance, weightInPounds)));
		System.out.println(twoDay.service() + "\t\t\t$" + String.format("%.2f", twoDay.calculateRate(distance, weightInPounds)));
		System.out.println(nextDay.service() + "\t\t\t$" + String.format("%.2f", nextDay.calculateRate(distance, weightInPounds)));
		

		
		
		input.close();
	}

}
