package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VendProcess {

	private BigDecimal balance = new BigDecimal(0);
	private List<FoodType> stock = new ArrayList<>();
	File newFile = new File("log.txt");
	PrintWriter writer;

	
	public VendProcess() {
		super();
	}

	public VendProcess(BigDecimal balance, List<FoodType> stock) {
		super();
		this.balance = balance;
		this.stock = stock;
	}

	public List<FoodType> getInitialInventory() { // pulls inventory from a CSV file and saves it to a list
		File document = new File("vendingmachine.csv");

		try {
			Scanner input = new Scanner(document);
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] inventory = line.split("\\|");
				switch (inventory[3]) {
				case "Chip":
					stock.add(new Chips(inventory[0], inventory[1], new BigDecimal(inventory[2])));
					break;
				case "Gum":
					stock.add(new Gum(inventory[0], inventory[1], new BigDecimal(inventory[2])));
					break;
				case "Drink":
					stock.add(new Drink(inventory[0], inventory[1], new BigDecimal(inventory[2])));
					break;
				case "Candy":
					stock.add(new Candy(inventory[0], inventory[1], new BigDecimal(inventory[2])));
					break;
				default:
					break;
				}

			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return stock;
	}

	public List<FoodType> getInventory() { //gets current inventory and displays it
		
		for (FoodType foodType : stock) {
			
			System.out.printf("%-25s", foodType.getSlot());
			System.out.printf("%-25s", foodType.getName());
			System.out.printf("%-25s", foodType.getPrice());
			System.out.printf("%-25s", foodType.getQuantity());
			System.out.println();
			
		}
		return stock;
	}

	public void makeSale() { //processes the sale of items
		boolean isLoop = true;
		String purchaseItem;
		Scanner input = new Scanner(System.in);
		String error = "Please make a valid selection"; //default error message. This will be changed as errors become more specific

		do {
			getInventory();
			System.out.println("Please select a product to purchase: ");
			purchaseItem = input.nextLine();
			purchaseItem = purchaseItem.toLowerCase();
			
			
			for (FoodType food : stock) { 
				String foodTest = food.getSlot().toLowerCase(); //ensures the program works whether user inputs upper or lower case letters
				if (foodTest.equals(purchaseItem)){ 
					int quantity = food.getQuantity(); //gets quantity of item selected
						if (food.getQuantity() > 0) { //ensures there is at lesat 1 available for purchase
							if ((balance.compareTo((food.getPrice())) == 1) || (balance.compareTo((food.getPrice())) == 0)) { //ensures you have enough money to purchase
								balance = balance.subtract(food.getPrice()); //takes away the cost of the item from your balance
								quantity--; //takes away 1 from the stock available
								food.setQuantity(quantity); //and sets it to the new quantity that is available for the future
								isLoop = false; 
								System.out.println(food.getSound()); //prints the correct sound based on type of item chosen
								System.out.println("\nYour current balance is $" + String.format("%.2f", balance));
								writer.println(getCurrentTimeStamp() + "\t" + food.getSlot() + "\t" + food.getName() + "\tCost of food is: $" + food.getPrice() + "\tBalance remaining is: $" + String.format("%.2f", this.balance));
							}else {
								error = "You do not have the funds to make this transaction";
								System.out.println(error);
								isLoop = false;
							}
							
						}else {
							error = "This item is sold out. Please make another selection.";
							System.out.println(error);
							isLoop = false;
						}
				}
				
			}
			if (isLoop) {
				System.out.println(error);
			}
		}while (isLoop);

	}

	public BigDecimal addMoney(BigDecimal money) throws FileNotFoundException { // used to feed more money into the machine
		
		balance = balance.add(money);
		System.out.println("\nYou fed $" + String.format("%.2f", money) + " Your current balance is $" + String.format("%.2f", balance));
		if (writer != null) {
		writer.println(getCurrentTimeStamp() + "\tYou fed $" + String.format("%.2f", money) + " Your current balance is $" + String.format("%.2f", this.balance));
		}
		return balance;
	}

	public String giveChange() { //takes big decimal value, throws it into an integer, calculates change, and prints it via a system out

		BigDecimal changeBalance = getBalance().multiply(new BigDecimal (100));
		int totalPennies = changeBalance.intValue();
		
		
		
		int quarters = totalPennies / 25;
		totalPennies = totalPennies % 25;
	    
	    int dimes = totalPennies / 10;
	    totalPennies = totalPennies % 10;
	    
	    int nickles = totalPennies / 5;
	  
		balance = balance.subtract(balance);
		if (writer != null) { //required to make testing work
		writer.println(getCurrentTimeStamp() + "\tGive change" + "\tquarters: " + quarters + "\tdimes: " + dimes + "\tnickles: " + nickles + "\tBalance: $" + String.format("%.2f", balance));
		}
		String msg = "quarters: " + quarters + "\ndimes: " + dimes + "\nnickles: " + nickles;
		return msg;

	}

	public String getCurrentTimeStamp() { //get time stamp for file writer class as each transaction is time stamped
        SimpleDateFormat sdfDate = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdfDate.format(date);
        return time;
    }
	
	public void initializeFileWriter() throws IOException { //initializes the file writer which will write to a file log.txt which is specified at the start of the class in the newFile variable
		writer = new PrintWriter(this.newFile);
		newFile.createNewFile();
	}
	
	public void closeFileWriter() { //closes file writer to ensure output is written to the file
		writer.close();
	}

	public BigDecimal getBalance() {
		return balance;
	}

}
