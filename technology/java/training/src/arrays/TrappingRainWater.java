/**
 * 
 */
package arrays;

/**
 * @author AR350758 TrappingRainWater.java Aug 30, 2019 2:44:48 PM
 */
public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Maximum water that can be accumulated is " + findWater(arr));

		int[] arr1 = new int[] { 2, 0, 2 };
		System.out.println("Maximum water that can be accumulated is " + findWater(arr1));

		int[] arr2 = new int[] { 3, 0, 0, 2, 0, 4 };
		System.out.println("Maximum water that can be accumulated is " + findWater(arr2));

	}

	private static int findWater(int[] arr) {
		int waterQty = 0;
		int[] leftBlock = new int[arr.length];
		int[] rightBlock = new int[arr.length];

		leftBlock[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			leftBlock[i] = Math.max(leftBlock[i - 1], arr[i]);
		}

		rightBlock[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightBlock[i] = Math.max(rightBlock[i + 1], arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			waterQty += Math.min(leftBlock[i], rightBlock[i]) - arr[i];
		}

		return waterQty;
	}
	
	private static int findWater1(int[] arr){
	    int waterQty = 0;
	    
	    int leftMax = 0;
	    int rightMax = 0;
	    int leftIndex = 0;
	    int rightIndex = arr.length - 1;
	    
	    while(leftIndex <= rightIndex){
	      
	      if(arr[leftIndex] < arr[rightIndex]){
	        if(leftMax < arr[leftIndex]){
	          leftMax = arr[leftIndex];
	        }else{
	          waterQty += leftMax - arr[leftIndex];        
	        }
	        
	        leftIndex++;
	      }else{
	      
	        if(rightMax < arr[rightIndex]){
	          rightMax = arr[rightIndex];
	        }else{
	          waterQty += rightMax - arr[rightIndex];
	        }
	        
	        rightIndex--;
	      }
	      
	    
	    }
	    return waterQty;
	  }
}
