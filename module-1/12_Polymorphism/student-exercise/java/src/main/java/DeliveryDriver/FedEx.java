package DeliveryDriver;

public class FedEx implements DeliveryDriver {

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = 20;
		if (distance > 500) {
			rate += 5;
		}
		if (weight > 48) {
			rate += 3;
		}
		return rate;
	}

	@Override
	public String service() {
		return "FedEx";
	}

}
