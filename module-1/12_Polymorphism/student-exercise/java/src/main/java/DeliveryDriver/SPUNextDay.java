package DeliveryDriver;

public class SPUNextDay implements DeliveryDriver {
	
	public SPUNextDay () {
	}

	@Override
	public double calculateRate(int distance, double weight) {
		return ((weight*.075)*distance);
	}

	@Override
	public String service() {
		return "SPU Next Day";
	}

}