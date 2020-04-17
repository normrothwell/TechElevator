package com.techelevator.farm;

public interface Farm {
	public final String FARMNAME = "Joe's Jumping Jamboree"; //interfaces can only have constants declared as variables
	public String getName();  // contract that says anyone who implements this interface
	public String getSound(); // must provide method bodies for these methods
	

}
