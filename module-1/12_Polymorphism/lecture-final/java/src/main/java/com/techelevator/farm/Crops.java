package com.techelevator.farm;

import java.math.BigDecimal;

public class Crops implements Sellable {
	private String name;
	private String unit;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public BigDecimal getPrice() {
		if (unit.equals("bushel")) {
			return BigDecimal.valueOf(4.00);
		} else if (unit.equals("peck")) {
			return BigDecimal.valueOf(1.25);
		} else if (unit.equals("bale")) {
			return BigDecimal.valueOf(75.00);
		}
		return BigDecimal.valueOf(23.99);
	}
	
	

}
