package closestToZero;

import static org.junit.Assert.*;

import org.junit.Test;

public class closestToZeroTests {
	
	ClosestToZero ctz = new ClosestToZero();
	@Test
	public void zero_should_return_zero() {
		int expectedResult = 0;
		int testArray [] = new int[1];
		testArray[0] = 0;
		int actualResult = ctz.evaluate(testArray);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void negativeOne_should_return_negativeOne() {
		int expectedResult = -1;
		int testArray [] = {-1};
		int actualResult = ctz.evaluate(testArray);
		assertEquals(expectedResult, actualResult);		
	}
	
	@Test
	public void twoPositves_should_return_smallest_positive() {
		int expectedResult = 1;
		int testArray [] = {2,1};
		int actualResult = ctz.evaluate(testArray);
		assertEquals(expectedResult, actualResult);		
	}
	
	@Test
	public void returns_ctz_of_negative_numbers() {
		int expectedResult = -1;
		int testArray [] = {-2,-1};
		int actualResult = ctz.evaluate(testArray);
		assertEquals(expectedResult, actualResult);		
	}
	
	@Test
	public void combo_of_positive_and_negative_numbers() {
		int expectedResult = -1;
		int testArray [] = {-2,-1, 4, 9};
		int actualResult = ctz.evaluate(testArray);
		assertEquals(expectedResult, actualResult);	
	}
	
	@Test
	public void negativeOneAndPositiveOne() {
		int expectedResult = -1;
		int testArray [] = {-2,-1, 1, 9};
		int actualResult = ctz.evaluate(testArray);
		assertEquals(expectedResult, actualResult);		
	}
	

}
