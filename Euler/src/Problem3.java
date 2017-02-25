public class Problem3 {
	public static void main(String[] args) {
		test(600851475143L);
	}

	public static void test(long n) {
		long k = 2;
		long m = 0;
		while (n > k) {
			while (n % k == 0) {
				m = k;
				n /= k;
			}
			if (k > 2) {
				k += 2;
			}
			else {
				k += 3;
			}
		}
		System.out.println(n + ", " + k + ", " + m + "\n");
	}
}