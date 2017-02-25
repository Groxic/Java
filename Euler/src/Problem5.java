// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class Problem5 {
	public static void main(String[] args) {
		boolean found = false;
		int i = 1;
		while (!found) {
			i++;
			found = true;
			for (int k = 2; k <= 20; k++) { // Test all numbers from 1-20
				if (i % k != 0) {
					found = false;
				}
			}
		}
		System.out.println(i);
	}
}
