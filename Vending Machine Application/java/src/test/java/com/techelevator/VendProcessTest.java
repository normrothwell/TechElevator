package com.techelevator;

//This tests for information given to us and not for any general test file input

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class VendProcessTest {

	List<FoodType> stock;
	File document;

	// Testing the add function
	@Test
	public void test_add_5() throws FileNotFoundException {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), new ArrayList<FoodType>());
		double actual = test.addMoney(BigDecimal.valueOf(5)).doubleValue();
		double expected = 5.0;
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test_add_1() throws FileNotFoundException {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), new ArrayList<FoodType>());
		double actual = test.addMoney(BigDecimal.valueOf(1)).doubleValue();
		double expected = 1.0;
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test_add_2() throws FileNotFoundException {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), new ArrayList<FoodType>());
		double actual = test.addMoney(BigDecimal.valueOf(2)).doubleValue();
		double expected = 2.0;
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test_add_10() throws FileNotFoundException {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), new ArrayList<FoodType>());
		double actual = test.addMoney(BigDecimal.valueOf(10)).doubleValue();
		double expected = 10.0;
		assertEquals(expected, actual, 0.0001);
	}

	// Testing the give change function

	@Test
	public void test_give_change_for_1_dollar() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(1), new ArrayList<FoodType>());
		String actual = test.giveChange();

		String expected = "quarters: 4" + "\ndimes: 0" + "\nnickles: 0";
		assertEquals(expected, actual);
	}

	@Test
	public void test_give_change_for_5_cents() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0.05), new ArrayList<FoodType>());
		String actual = test.giveChange();

		String expected = "quarters: 0" + "\ndimes: 0" + "\nnickles: 1";
		assertEquals(expected, actual);
	}

	@Test
	public void test_give_change_for_10_cents() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0.1), new ArrayList<FoodType>());
		String actual = test.giveChange();

		String expected = "quarters: 0" + "\ndimes: 1" + "\nnickles: 0";
		assertEquals(expected, actual);
	}

	@Test
	public void test_give_change_for_1_dollar_90_cents() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(1.90), new ArrayList<FoodType>());
		String actual = test.giveChange();

		String expected = "quarters: 7" + "\ndimes: 1" + "\nnickles: 1";
		assertEquals(expected, actual);
	}

	@Test
	public void test_give_change_for_0_dollars() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), new ArrayList<FoodType>());
		String actual = test.giveChange();

		String expected = "quarters: 0" + "\ndimes: 0" + "\nnickles: 0";
		assertEquals(expected, actual);
	}

	// Tests for the vendingmachine.csv file import

	@Test
	public void getInventory_returns_potato_crisp_from_a1() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), stock);
		assertEquals("Potato Crisps", test.getInventory().get(0).getName());
	}

	@Test
	public void getInventory_returns_305_from_potato_crisps_in_A1() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), stock);
		assertEquals(new BigDecimal("3.05"), test.getInventory().get(0).getPrice());
	}

	@Test
	public void getInventory_returns_150_for_cowtales_in_b2() {
		VendProcess test = new VendProcess(BigDecimal.valueOf(0), stock);
		assertEquals(new BigDecimal("1.50"), test.getInventory().get(6).getPrice());
	}

	// Tests imported file makes it into the list object
//	
	@Before
	public void test_load_inventory() {
		document = new File("vendingmachine.csv");
		stock = new ArrayList<>();
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
	}
}
