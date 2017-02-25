public class Problem4 {
	public static void main(String[] args) {
		System.out.println("Largest palindrome product of two three digit numbers = " + run(999, 100));
	}
	
	public static int run(int max, int min) {
		int num = 0;
		int largest = 0;
		for (int i = max; i >= min; i--) {
			for (int k = i; k >= min; k--) {
				num = k * i;
				if (isPalindrome(num)) {
					largest = num > largest ? num : largest;
					System.out.println(num + " = " + i + " * " + k);
				}
			}
		}
		return largest;
	}
	
	public static boolean isPalindrome(int num) {
		String s = num + "";
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
				return false;
			}
		}
		return true;
	}
}
