package DeliveryDriver;

public class PostalServiceThirdClass implements DeliveryDriver {
	
	

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = 0;
		if (weight <= 2) {
			rate = distance * 0.002;
		}else if (weight <= 8) {
			rate = distance * 0.0022;
		}else if (weight <= 15) {
			rate = distance * 0.0024;
		}else if (weight <= 48) {
			rate = distance * 0.0150;
		}else if (weight <= 148) {
			rate = distance * 0.016;
		}else rate = distance * .017;
		return rate;
	}

	@Override
	public String service() {
		return "Postal Service (Third class)";
	}

}