
public class Search {
	// Returns the index of an occurrence of target in a,
	// or a negative number if the target is not found.
	// Precondition: elements of a are in sorted order
	public static int binarySearch(int[] a, int target) {
		int min = 0;
		int max = a.length - 1;

		while (min <= max) {
			int mid = (min + max) / 2;
			System.out.println(mid);
			;
			if (a[mid] < target) {
				min = mid + 1;
			} else if (a[mid] > target) {
				max = mid - 1;
			} else
				return mid; // target found
		}

		return -(min + 1); // target not found
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { -30, -9, -6, -4, -2, -1, 0, 2, 4, 10, 12, 17, 22, 30 }, -5));
	}
}
