package DeliveryDriver;

public class PostalServiceFirstClass implements DeliveryDriver {
	
	

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = 0;
		if (weight <= 2) {
			rate = distance * 0.035;
		}else if (weight <= 8) {
			rate = distance * 0.04;
		}else if (weight <= 15) {
			rate = distance * 0.047;
		}else if (weight <= 48) {
			rate = distance * 0.195;
		}else if (weight <= 148) {
			rate = distance * 0.45;
		}else rate = distance * .5;
		return rate;
	}

	@Override
	public String service() {
		return "Postal Service (1st class)";
	}

}