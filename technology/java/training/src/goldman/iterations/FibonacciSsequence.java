/**
 * 
 */
package goldman.iterations;

/**
 * @author AR350758 FibonacciSsequence.java Aug 20, 2019 4:19:47 PM
 */
public class FibonacciSsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 9;
		//System.out.println(fib(n));
		fibonacciSeries(12);
	}

	static int fib(int n) {
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);

	}

	public static void fibonacciSeries(int number) {
		System.out.printf("\nFibonacci series in Java of number %s using recursion %n", number);
		for (int i = 1; i <= number; i++) {
			System.out.printf("%s ", getFibonacci(i));
		}
	}

	public static int getFibonacci(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}
}
