package number;

/*
Given a number N and a number K, the task is to find the largest number smaller than or equal to N which is divisible by K.
Examples: 

Input: N = 45, K = 6
Output: 42
42 is the largest number smaller than 
or equal to 45 which is divisible by 6.

Input: N = 11, K = 3
Output: 9
*/
public class LargestNumberSEtoNDivisibleByK {

	public static void main(String[] args) {
		System.out.println(findNum(45, 6));
	}

	static int findNum(int N, int K) {
		return N % K == 0 ? N : N - N % K;
	}

}
