/*
The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 ... + 10)^2 = 55^2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

public class Problem6 {
	public static void main(String[] args) {
		int sum = sumOfSquares(100);
		int squareSum = squareOfSum(100);
		System.out.println("Sum of squares: " + sum);
		System.out.println("Square of sum: " + squareSum);
		System.out.println("Difference = " + (squareSum - sum));
	}
	
	public static int sumOfSquares(int max) {
		int sum = 0;
		for (int i = 1; i <= max; i++) {
			sum += i * i;
		}
		return sum;
	}
	
	public static int squareOfSum(int max) {
		int sum = 0;
		for (int i = 1; i <= max; i++) {
			sum += i;
		}
		return sum * sum;
	}
}
