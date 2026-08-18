package string;

//Modify string by replacing all occurrences of given characters by specified replacing characters
public class StringReplacewithGivenCharacter {
	public static void main(String[] args) {
		String S = "aabbgg";
		char[][] charArray = { { 'a', 'b' }, { 'b', 'g' }, { 'g', 'a' } };
		replaceCharacters(S, charArray);
	}

	static void replaceCharacters(String s, char[][] p) {
		// Store the size of string and the number of pairs
		int n = s.length(), k = p.length;

		// Initialize 2 character arrays
		char[] arr = new char[26];
		char[] brr = new char[26];

		// Traverse the string s Update arrays arr[] and brr[]
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			arr[ch - 'a'] = ch;
			brr[ch - 'a'] = ch;
		}

		// Traverse the array of pairs p
		for (int j = 0; j < p.length; j++) {

			// a -> Character to be replaced
			// b -> Replacing character
			char a = p[j][0], b = p[j][1];

			// Iterate over the range [0, 25]
			for (int i = 0; i < 26; i++) {
				char ch = arr[i];
				// If it is equal to current character, then replace it in the array b
				if (arr[i] == a) {
					brr[i] = b;
				}
			}
		}

		// Print the array brr[]
		for (int i = 0; i < s.length(); i++) {
			System.out.print(brr[s.charAt(i) - 'a']);
		}
	}
}
