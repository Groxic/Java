/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

public class Problem9 {
	public static final int MAX_SUM = 1000;

	public static void main(String[] args) {
		for (int b = 1; b < MAX_SUM; b++) {
			for (int a = 1; a < b; a++) {
				double c = Math.sqrt(a * a + b * b);
				if (a < b && b < c && a + b + c == MAX_SUM) {
					System.out.println(a + " < " + b + " < " + c + " = " + MAX_SUM);
					System.out.println(a * b * c);
				}
			}
		}
	}
}
