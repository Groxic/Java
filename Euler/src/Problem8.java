import java.util.*;
import java.io.*;

public class Problem8 {
	
	private static final int SEARCH_LEN = 13;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("numbers.txt");
		Scanner number = new Scanner(file);
		String numberString = number.next();
		number.close();
		long max = 0;
		for (int i = 0; i < numberString.length() - SEARCH_LEN; i++) {
			long product = 1;
			for (int j = 0; j < SEARCH_LEN; j++) {
				int num = Character.getNumericValue(numberString.charAt(i + j));
				product *= num;
				System.out.print(num + ", ");
			}
			System.out.println(product);
			if (product > max) {
				max = product;
			}
		}
		System.out.println("max = " + max);
	}
}
