package DeliveryDriver;

public class SPUFourDay implements DeliveryDriver {
	
	public SPUFourDay () {
	}

	@Override
	public double calculateRate(int distance, double weight) {
		return ((weight*.005)*distance);
	}

	@Override
	public String service() {
		return "SPU 4 day";
	}

}