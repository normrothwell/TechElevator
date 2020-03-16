package com.techelevator;

import java.math.BigDecimal;

public interface ManageVendingTypes {
	
	public abstract String getSound ();
	public abstract String getSlot();
	public abstract String getName();
	public abstract BigDecimal getPrice();
	public abstract int getQuantity();
	
	
}
