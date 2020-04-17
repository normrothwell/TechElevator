package com.techelevator;

import java.util.ArrayList;
import java.util.List;

//******************************   Nathan Newcomb  ***************************************************************

public class KataPotter {

	private double basePrice = 8.00;
	private double[] discounts = { 1.0, 0.95, 0.9, 0.8, 0.75 };

	public double getCost(int[] bookArr) {
		List<Integer> bookList = getBookListAsListOfIndividualBooks(bookArr);
		double bestPrice = getCostSummedOverSublistsSizeN(bookList, 1);
		for (int i = 2; i <= 5; i++) {
			double currentPrice = getCostSummedOverSublistsSizeN(bookList, i);
			if (currentPrice <= bestPrice) {

				bestPrice = currentPrice;
			}
		}
		return bestPrice;
	}

	public double getCostSummedOverSublistsSizeN(List<Integer> bookList, int n) {
		List<List<Integer>> sublists = getSublistsOfLengthOfLengthN(bookList, n);
		double totalCost = 0.0;
		for (List<Integer> sublist : sublists) {
			totalCost += sublist.size() * basePrice * discounts[(sublist.size() - 1)];
		}
		return totalCost;
	}

	public List<Integer> getBookListAsListOfIndividualBooks(int[] arr) {
		List<Integer> bookList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= arr[i]; j++)
				bookList.add(i + 1);
		}
		return bookList;
	}

	public List<List<Integer>> getSublistsOfLengthOfLengthN(List<Integer> bookList, int n) {
		List<List<Integer>> sublists = new ArrayList<List<Integer>>();
		for (Integer book : bookList) {
			boolean thisBookGotAdded = false;
			for (List<Integer> sublist : sublists) {
				if (!sublist.contains(book) && sublist.size() < n) {
					sublist.add(book);
					thisBookGotAdded = true;
					break;
				}
			}
			if (!thisBookGotAdded) {
				List<Integer> tempList = new ArrayList<>();
				tempList.add(book);
				sublists.add(tempList);
			}
		}
		return sublists;
	}

	//************************  Guan He ******************************************************************************

	import java.util.Set;

	class KataPotter2 {
		private double bookPrice = 8d;
		private double[] discounts = { 1d, 0.95, 0.9, 0.8, 0.75 };

		public double getCost(int[] booksArr) {
			double totalPrice = 0d;
			List<Integer> booksList = new ArrayList<>();

			for (int i = 0; i < booksArr.length; i++) {
				for (int j = 0; j <= booksArr[i]; j++) {
					if (j != 0) {
						booksList.add(i + 1);
					}
				}
			}

			totalPrice = booksList.size() * bookPrice;
			if (booksList.size() > 0) {
				List<List<Set<Integer>>> comboSetsListStore = createComboSetsListStore(booksList);

				for (List<Set<Integer>> comboSetList : comboSetsListStore) {
					double comboPrice = 0d;

					for (Set<Integer> comboSet : comboSetList) {
						comboPrice += comboSet.size() * bookPrice * discounts[(comboSet.size() - 1)];
					}

					if (totalPrice > comboPrice) {
						totalPrice = comboPrice;
					}
				}
			} else {
				totalPrice = 0d;
			}

			return totalPrice;
		}

		private List<List<Set<Integer>>> createComboSetsListStore(List<Integer> booksList) {
			List<List<Set<Integer>>> comboSetsListStore = new ArrayList<List<Set<Integer>>>();

			for (int i = 2; i <= 5; i++) {
				comboSetsListStore.add(createComboSetsList(booksList, i));
			}

			return comboSetsListStore;
		}

		private List<Set<Integer>> createComboSetsList(List<Integer> booksList, int maxSetSize) {
			List<Set<Integer>> comboSetsList = new ArrayList<Set<Integer>>();
			comboSetsList.add(new HashSet<Integer>());

			for (Integer book : booksList) {
				boolean bookAdded = false;
				for (Set<Integer> comboSet : comboSetsList) {
					if (!comboSet.contains(book) && comboSet.size() < maxSetSize) {
						bookAdded = true;
						comboSet.add(book);
						break;
					}
				}

				if (!bookAdded) {
					Set<Integer> comboSet = new HashSet<Integer>();
					comboSet.add(book);
					comboSetsList.add(comboSet);
				}
			}

			return comboSetsList;
		}
	}

	//**********************************  Tom Philips   ******************************************************

	class KataPotter3 {

		public double getCost(int[] books) {
			double price = 8.0;
			double totalPrice = 0;
			double discount;
			int totalNumberOfBooks = 0;

			// Find largest number
			int max = books[0];
			for (int i = 0; i < books.length; i++) {
				if (books[i] > max) {
					max = books[i];
				}
				totalNumberOfBooks += books[i];
			}

//				// If eight books remain and 3 of them are value 2, make 2 groups of 4
//				if (totalNumberOfBooks == 8) {
//					int twoOfEachCopy = 0;
//					for (int book : books) {
//						if (book == 2) {
//							twoOfEachCopy++;
//						}
//					}
//					// Add two groups of 4 at 20% discount to total price
//					if (twoOfEachCopy == 3) {
//						totalPrice += 2 * (4 * 8 * 0.8);
//						return totalPrice;
//					}
//				}
			// Iterate over sets of books
			int numberOfBooksInSet = 0;
			double tempPrice = price;
			for (int i = 0; i < max; i++) {

				// Iterate over each book in a set
				for (int j = 0; j < books.length; j++) {
					if (books[j] > 0) {
						numberOfBooksInSet++;
						books[j]--;
					}

				}

				// Apply discount

			}
			if (numberOfBooksInSet == 5) {
				discount = 0.25;
				tempPrice = price - (price * discount);
			} else if (numberOfBooksInSet == 4) {
				discount = 0.20;
				tempPrice = price - (price * discount);
			} else if (numberOfBooksInSet == 3) {
				discount = 0.10;
				tempPrice = price - (price * discount);
			} else if (numberOfBooksInSet == 2) {
				discount = 0.05;
				tempPrice = price - (price * discount);
			}

			totalPrice += numberOfBooksInSet * tempPrice;
			numberOfBooksInSet = 0;
			tempPrice = price;

			return totalPrice;
		}



}