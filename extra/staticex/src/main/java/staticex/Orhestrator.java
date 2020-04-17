package staticex;

public class Orhestrator {

	public static void main(String[] args) {
		
		Widget widget1 = new Widget();
		Widget widget2 = new Widget();
		
		System.out.println("Value of static member:");
		System.out.println("Widget 1:" + widget1.thisVar);
		System.out.println("Widget 2:" + widget2.thisVar);	
		System.out.println("************************");
		
		System.out.println("Changing static member value using Widget 2 ONLY to Meow");
		widget2.thisVar = "Meow";
		System.out.println("************************");
		
		System.out.println("Value of static member:");
		System.out.println("Widget 1:" + widget1.thisVar);
		System.out.println("Widget 2:" + widget2.thisVar);	
		System.out.println("************************");
		
		// Noticed that even though we used the widget2
		// reference to change the value of thisVar, 
		// IT GETS CHANGED FOR EVERYONE! (Because it's static).
		
		Doohickey dh1 = new Doohickey();
		System.out.println("current # of Doohickey objects: " + Doohickey.getCopies());
		
		Doohickey dh2 = new Doohickey();
		System.out.println("current # of Doohickey objects: " + Doohickey.getCopies());

		Doohickey dh3 = new Doohickey();
		System.out.println("current # of Doohickey objects: " + Doohickey.getCopies());

		
		
	}

}
