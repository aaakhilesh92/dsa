package other;

public class ShortestPalindrome {
    public static void main(String[] args) {
        String word = "abcdefgfeacb";
        System.out.println(change(word));
        int[] lps = new int[word.length()];
        computeLPSArray(word, word.length(), lps);

        System.out.println(lps);
    }
    static int change(String s) {
        int n = s.length();
        int count1 = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) {
                continue;
            }
            // changing logic
            count1 += 1;
        }
        int count2 = getShortestPalindrome(s);

        return count1 < count2 ? count1 : count2;
    }
    public static int getShortestPalindrome(String word) {
        if (word == null || word.equals("")) {
            return 0;
        }

        char[] wordArr = word.toCharArray();

        return getShortestPalindrome(wordArr);
    }

    private static int getShortestPalindrome(char[] word) {
        int len = word.length;
        int doublePlusSentinelLen = (len << 1) + 1;

        char sentinel = (char) 8;
        char[] reversedWord = reverse(word);
        char[] palindromicBase = new char[doublePlusSentinelLen];

        // Set palindromicBase = reversedWord + sentinel + word
        System.arraycopy(reversedWord, 0, palindromicBase, 0, len);
        palindromicBase[len] = sentinel;
        System.arraycopy(word, 0, palindromicBase, len + 1, len);

        // Compute preprocessed table
        int[] table = new int[doublePlusSentinelLen + 1];
        computeTable(table, doublePlusSentinelLen, palindromicBase);

        // Generate output
        int longestPalindromicSuffix = Math.min(len, table[doublePlusSentinelLen]);
        int numCharsToAppend = len - longestPalindromicSuffix;
        /*
         * int shortestPalindromeLen = len + numCharsToAppend; char[]
         * shortestPalindrome = new char[shortestPalindromeLen];
         * 
         * for (int i = 0; i < len; i++) { shortestPalindrome[i] = word[i]; }
         * 
         * for (int i = len, j = 0; i < shortestPalindromeLen; i++, j++) {
         * shortestPalindrome[i] = word[numCharsToAppend - j - 1]; }
         */

        return numCharsToAppend;
    }

    private static void computeTable(int[] table, int len, char[] word) {
        table[0] = -1;

        for (int i = 0; i < len; ++i) {
            int k = table[i];

            while (k >= 0 && word[k] != word[i]) {
                k = table[k];
            }

            table[i + 1] = k + 1;
        }
    }

    private static char[] reverse(char[] charArr) {
        int length = charArr.length;
        char[] str = new char[length];
        System.arraycopy(charArr, 0, str, 0, length);

        for (int leftI = 0, rightI = length - 1; leftI < rightI; leftI++, rightI--) {
            swapChar(str, leftI, rightI);
        }

        return str;
    }

    private static void swapChar(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void computeLPSArray(String pat, int M, int lps[]) {
        lps[0] = 0;

        for (int i = 1; i < M; i++) {
            int l = 0, h = i;
            int len = 0;
            while (l < h) {
                if (pat.charAt(l) == pat.charAt(h)) {
                } else {
                    len++;
                }
                l++;
                h--;
            }
            lps[i] = len;
        }
    }
}
