package number;

/*
 * Largest number smaller than or equal to n and digits in non-decreasing order
 * 
	Input  : n = 200
	Output : 199
	If the given number is 200, the largest 
	number which is smaller or equal to it 
	having digits in non decreasing order is
	199.
	
	Input  : n = 139
	Output : 139
 */
public class LargestNumNonDecDigits {
	public static void main(String[] args) {
		// nondecdigits(200);
		nondecdigits(5664);
		// nondecdigits(140);
	}

	static void nondecdigits(int num) {
		String s = Integer.toString(num);
		int m = s.length();

		/* array to store digits of number */
		int[] a = new int[m];

		/* conversion of characters of string int number */
		for (int i = 0; i < m; i++) {
			a[i] = (int) s.charAt(i) - (int) '0';
		}

		/*
		 * variable holds the value of index after which all digits are set 9
		 */
		int level = m - 1;
		for (int i = m - 1; i > 0; i--) {
			/*
			 * Checking the condition if the digit is less than its left digit
			 */
			if (a[i] < a[i - 1]) {
				a[i - 1]--;
				level = i - 1;
			}
		}

		int result = 0;
		for (int i = 0; i <= level; i++) {
			result = result * 10 + a[i];
		}

		for (int i = level + 1; i < m; i++) {
			result = result * 10 + 9;
		}
		System.out.println("Result : " + result);

	}
}
