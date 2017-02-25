// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

// What is the 10001st prime number?
// Answer: 104743

public class Problem7 {
	public static void main(String[] args) {
		int find = 10001;
		int count = 1;
		int currentNumber = 2;
		while (count < find) {
			currentNumber++;
			if (ExtraMath.isPrime(currentNumber)) {
				count++;
			}
		}
		System.out.println("#" + count + " = " + currentNumber);
	}
}
