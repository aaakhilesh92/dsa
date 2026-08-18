package number;

public class DigitSums {

	public static void main(String[] args) {
		sum(999);

	}

	public static void sum(int num) {
		int sum = 0;
		while (num > 0 || sum > 9) {
			if (num == 0) {
				num = sum;
				sum = 0;
			}
			sum += num % 10;
			num /= 10;
		}
		System.out.println("Sum: " + sum);
	}

	public static void sum2(int num) {
		int sum = 0;
		if (num != 0) {
			sum = num % 9 == 0 ? 9 : num % 9;
		}
		System.out.println("Sum: " + sum);
	}
}
