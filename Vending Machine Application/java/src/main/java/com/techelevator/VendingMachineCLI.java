package com.techelevator;



import java.io.IOException;
import java.math.BigDecimal;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	private static final String FEED_MENU_OPTION_10 = "$10";
	private static final String FEED_MENU_OPTION_5 = "$5";
	private static final String FEED_MENU_OPTION_2 = "$2";
	private static final String FEED_MENU_OPTION_1 = "$1";
	private static final String[] FEED_MENU_OPTIONS = {FEED_MENU_OPTION_10, FEED_MENU_OPTION_5, FEED_MENU_OPTION_2, FEED_MENU_OPTION_1};
	
	
	private Menu menu;
	
	private VendProcess vending = new VendProcess();
	private boolean purchaseLoop = true;
	

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		vending.initializeFileWriter();
		vending.getInitialInventory();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			System.out.println(choice);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vending.getInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseLoop = true;
				while (purchaseLoop) {
				String purchaseMenu = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (purchaseMenu.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
						String feedMenu = (String) menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
							if (feedMenu.equals(FEED_MENU_OPTION_10)){
								BigDecimal money = new BigDecimal(10);
								vending.addMoney(money);
							}else if (feedMenu.equals(FEED_MENU_OPTION_5)) {
								BigDecimal money = new BigDecimal(5);
								vending.addMoney(money);
							}else if (feedMenu.equals(FEED_MENU_OPTION_2)) {
								BigDecimal money = new BigDecimal(2);
								vending.addMoney(money);
							}else if (feedMenu.equals(FEED_MENU_OPTION_1)) {
								BigDecimal money = new BigDecimal(1);
								vending.addMoney(money);
							}else System.out.println("Please select a valid option");
					}else if (purchaseMenu.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						vending.makeSale();
					}else if (purchaseMenu.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						System.out.println(vending.giveChange());
						purchaseLoop = false;
					}
					}
				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for shopping!");
				vending.closeFileWriter();
				System.exit(0);

			}

		}
	}

	public static void main(String[] args) throws IOException {
		
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
