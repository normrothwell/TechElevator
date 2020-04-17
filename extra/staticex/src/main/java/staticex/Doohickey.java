package staticex;

public class Doohickey {
	
	private static int copies = 0;
	
	public Doohickey() {
		copies ++;
	}
	
	public static int getCopies() {
		return copies;
	}
	
}
