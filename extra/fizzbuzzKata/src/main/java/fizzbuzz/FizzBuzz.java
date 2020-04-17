package fizzbuzz;

public class FizzBuzz {
	
	public FizzBuzz() {
		System.out.println("object instantiated");
	}

	public String evaluate(Integer i) {
		
		String output = i.toString();
		
		if (i%15 == 0) {
			output = "FizzBuzz";
		}else if (i%3 == 0) {
			output = "Fizz";
		}
		else if (i%5 ==0) {
			output = "Buzz";
		}
		
		
		return output;
	}

}
