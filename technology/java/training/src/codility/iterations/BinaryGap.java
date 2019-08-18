package codility.iterations;

public class BinaryGap {

	public static void main(String[] args) {
		int[] A = {1,1,1,1,1,1};
	}

	static boolean loadBalancer(int[] A) {
		//remove two elements and check if sum can be split 3
		
		if(A.length < 5)
			return false;
		
		int workerATime = 0;
		int workerBTime = 0;
		int workerCTime = 0;
		
		int startIndex = 0;
		int endIndex = A.length - 1;
		
		while(true) {
			
			workerATime = A[startIndex];
			workerBTime = A[endIndex];
			if(workerATime == workerBTime) {
				
			}
		}
		
		return false;
		
	}
}
