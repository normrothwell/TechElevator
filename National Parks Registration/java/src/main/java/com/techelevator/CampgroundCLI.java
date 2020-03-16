package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;

public class CampgroundCLI {
	
	private static final String PARK_MENU_OPTION_VIEW = "View Campgrounds";
	private static final String PARK_MENU_OPTION_SEARCH = "Look for Reservation";
	private static final String PARK_MENU_OPTION_RETURN = "Go Back to Previous Screen";
	private static final String[] PARK_MENU_OPTIONS = {PARK_MENU_OPTION_VIEW, PARK_MENU_OPTION_SEARCH, PARK_MENU_OPTION_RETURN};
	
	private final String HEADER_ID = "ID#";
	private final String HEADER_NAME = "Name";
	private final String HEADER_OPEN = "Open";
	private final String HEADER_CLOSE ="Close";
	private final String HEADER_DAILYFEE = "Daily Fee";

	private Menu menu;
	private boolean reservationLoop;
	private boolean parkLoop;
	private ParkDAO parkDAO;
	private Park chosenPark = null;
	private CampgroundDAO campgroundDAO;
	private ReservationDAO reservationDAO;
	private SiteDAO siteDAO;
	private int campgroundId = 0;
	private double campgroundFee = 0;
	private int siteId = 0;


	public CampgroundCLI(DataSource datasource) {
		parkDAO = new JDBCParkDAO(datasource);
		campgroundDAO = new JDBCCampgroundDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);
	}
	
	

	public void run() {
		System.out.println("________________________________");
		System.out.println("|                               |");
		System.out.println("|     Welcome to the Parks      |");
		System.out.println("|      Reservation System       |");
		System.out.println("|_______________________________|");
		
		Menu menu = new Menu(System.in, System.out);
		List <Park> parks = new ArrayList<>();
		parks = parkDAO.getAllParks();
		String parkNames[] = new String[parks.size()+1];
		List <Integer> sites = new ArrayList<>();
		List <Site> sitesToBook = new ArrayList<>();
		
		for (int x = 0; x<parks.size();x++) {
			parkNames[x] = parks.get(x).getParkName();
		}
		parkNames[parks.size()] = "Quit";
		
		
		while (true) {
			parkLoop = true;
			while (parkLoop) {	
				String choice = (String) menu.getChoiceFromOptions(parkNames);
				chosenPark = parkDAO.findParkByName(choice);
				if (choice.equals("Quit")){
					System.out.println("Thank you for Staying");
					System.exit(0);
				}
				if (chosenPark != null) {
					parkLoop = false;
				}

			}
			System.out.println("\n");
			parkDAO.printParkInformation(chosenPark);
			List <Campground> campgrounds = new ArrayList<>();
			campgrounds = campgroundDAO.listAllCampgrounds(chosenPark.getParkId());
			reservationLoop = true;
			
						
			while (reservationLoop) {
				String parkMenuChoice = (String) menu.getChoiceFromOptions(PARK_MENU_OPTIONS);
					if (parkMenuChoice.equals(PARK_MENU_OPTION_VIEW)){
						System.out.println("\n***Park Campgrounds***");
						System.out.printf("%-4s %-31s %-15s %-15s %-6s\n", HEADER_ID, HEADER_NAME, HEADER_OPEN, HEADER_CLOSE, HEADER_DAILYFEE);
						for (Campground list: campgrounds) {
							campgroundDAO.printCampgroundInformation(list);
						}
						
					}else if  (parkMenuChoice.equals(PARK_MENU_OPTION_SEARCH)){
						System.out.println("\n***Park Campgrounds***");
						System.out.printf("%-4s %-31s %-15s %-15s %-6s\n", HEADER_ID, HEADER_NAME, HEADER_OPEN, HEADER_CLOSE, HEADER_DAILYFEE);
						for (Campground list: campgrounds) {
							campgroundDAO.printCampgroundInformation(list);
						}
						handleCampgroundInput(campgrounds);
						if (campgroundId != 0) {
							sites = reservationDAO.handleReservation(campgroundId);
							
							campgroundFee = campgroundDAO.getFee(campgroundId);
							sitesToBook = siteDAO.getAvailableReservations(sites, campgroundFee);
							
							System.out.println("\nSite ID | Max Occupancy | Accessible | Max RV Length | Utilities | Cost");
							System.out.println("--------|---------------|------------|---------------|-----------|------");
							double bookingFee = reservationDAO.bookingFee(campgroundFee);
							for (Site list: sitesToBook) {
								
								siteDAO.printSiteInformation(list, bookingFee);
							}
						
							handleSiteInput(sitesToBook);
							reservationDAO.bookSite(siteId, campgroundFee);
							reservationLoop = false;
						}
						
					}else if (parkMenuChoice.equals(PARK_MENU_OPTION_RETURN)) {
						reservationLoop = false;
						
					}
				}

		}
}
	
	private void handleSiteInput(List<Site> sitesToBook) {
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease Select the site ID you want to book: ");
		siteId = Integer.parseInt(input.nextLine());
		verifySiteInput(siteId, sitesToBook);
		
	}


	private void verifySiteInput(int siteId, List<Site> sitesToBook) {
		boolean isFound = false;
		
		int siteIds[] = new int[sitesToBook.size()];
	
		for (int x = 0; x<sitesToBook.size();x++) {
			siteIds[x] = sitesToBook.get(x).getSiteId();
		}
		for (int x = 0; x<siteIds.length;x++) {
			if (siteIds[x] == siteId) {
				isFound = true;
			}
		}
		if (!isFound) {;
			System.out.println("Please enter a valid site ID\n");
			handleSiteInput(sitesToBook);
			}
		
	}



	public void handleCampgroundInput(List <Campground> campgrounds) {
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease Select the campground ID you want to book (or enter 0 to go back): ");
		campgroundId = Integer.parseInt(input.nextLine());
		if (campgroundId != 0) {
			verifyCampgroundInput(campgroundId, campgrounds);
		}
	}




	
	private void verifyCampgroundInput(int campgroundId, List <Campground> campgrounds) {
			boolean isFound = false;
			
			int campgroundIds[] = new int[campgrounds.size()];
		
			for (int x = 0; x<campgrounds.size();x++) {
				campgroundIds[x] = campgrounds.get(x).getCampgroundId();
			}
			for (int x = 0; x<campgroundIds.length;x++) {
				if (campgroundIds[x] == campgroundId) {
					isFound = true;
				}
			}
				
			if (!isFound) {;
				System.out.println("Please enter a valid campground ID\n");
				handleCampgroundInput(campgrounds);
				}
		}
	



	public static void main(String[] args) {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
		
	}


}
