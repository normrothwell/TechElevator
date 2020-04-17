package DeliveryDriver;

public class PostalServiceSecondClass implements DeliveryDriver {
	
	

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = 0;
		if (weight <= 2) {
			rate = distance * 0.0035;
		}else if (weight <= 8) {
			rate = distance * 0.004;
		}else if (weight <= 15) {
			rate = distance * 0.0047;
		}else if (weight <= 48) {
			rate = distance * 0.0195;
		}else if (weight <= 148) {
			rate = distance * 0.045;
		}else rate = distance * .05;
		return rate;
	}

	@Override
	public String service() {
		return "Postal Service (2nd class)";
	}

}