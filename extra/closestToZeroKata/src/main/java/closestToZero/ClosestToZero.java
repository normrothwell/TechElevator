package closestToZero;

public class ClosestToZero {

	public int evaluate(int[] testArray) {
		// TODO Auto-generated method stub
		
		int currentMin = testArray[0];
		
		for (int i=0; i < testArray.length;i++) {
			
			if (Math.abs(testArray[i]) < Math.abs(currentMin)) {
				currentMin = testArray[i];
			}
			
		}
		
		return currentMin;
	}

}
