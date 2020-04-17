package DeliveryDriver;

public class SPUTwoDay implements DeliveryDriver {
	
	public SPUTwoDay () {
	}

	@Override
	public double calculateRate(int distance, double weight) {
		return ((weight*.05)*distance);
	}

	@Override
	public String service() {
		return "SPU 2 day";
	}

}