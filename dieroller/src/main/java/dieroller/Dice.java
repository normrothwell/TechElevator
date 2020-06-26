package dieroller;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Dice {

	public static void main(String[] args) throws IOException {
		

			Scanner input = new Scanner(System.in);
			System.out.println("Enter how many six sided dice to roll: ");
			int numDice = Integer.parseInt(input.nextLine());
		
			int sumDice = 0;
			for (int x = 0; x<numDice; x++) {
				Random num = new Random();
				int result = num.nextInt((6-1)+1)+1;
				sumDice+=result;
				System.out.println(result);
			}
		System.out.println(sumDice);
		input.close();
	}

}
