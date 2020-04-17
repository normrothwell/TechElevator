package com.techelevator.farm;

public interface Farm {
	// interfaces can have constants declared in them.
	public final String FARM_NAME = "Fred's Fantastic Farm";
	public String getName();  // contract that says anyone who implements this interface
	public String getSound(); // must provide method bodies for these methods

	
}
