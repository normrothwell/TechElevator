package staticex;

public class Widget {
	
	// Never do this (setting to public). 
	// Just proving a point
	public static String thisVar = "Woof";
	
	// Whoever calls this method can do
	// so like this: Widget.aStatMethod()
	public static int aStatMethod() {
		return 100;
	}

}
