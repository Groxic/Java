/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

public class Problem10 {
	public static final int MAX = 2000000;
	
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 0; i < MAX; i++) {
			if (ExtraMath.isPrime(i)) {
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println("sum == " + sum);
	}
}
