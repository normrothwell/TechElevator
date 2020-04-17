package fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Test;

public class fizzbuzztest {
	FizzBuzz fb = new FizzBuzz();

	@Test
	public void one_should_return_one() {
		String actual = fb.evaluate(1);
		String expected = "1";
		assertEquals(expected, actual);

	}

	@Test
	public void two_should_return_two() {
		String actual = fb.evaluate(2);
		String expected = "2";
		assertEquals(expected, actual);
	}
	
	@Test
	public void three_should_return_Fizz() {
		String actual = fb.evaluate(3);
		String expected = "Fizz";
		assertEquals(expected, actual);
	}
	
	@Test
	public void five_should_return_Buzz() {
		String actual = fb.evaluate(5);
		String expected = "Buzz";
		assertEquals(expected, actual);
	}
	
	@Test
	public void fifteen_should_return_FizzBuzz() {
		String actual = fb.evaluate(15);
		String expected = "FizzBuzz";
		assertEquals(expected, actual);
	}
	

}
