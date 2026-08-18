package string;

public class StringIsSubStringNtimes {

    public static void main(String[] args) {
        System.out.println(getSubStringLength("ababab", "ab"));
    }

    public static int getSubStringLength(String str, String pat) {
        int result = -1;
        if (str == null || pat == null || str.equals("") || str.equals("")) {
            return result;
        }

        int p_length = pat.length();
        int s_length = str.length();
        if (s_length < p_length || s_length % p_length != 0) {
            return result;
        }
        int l = p_length;
        String tmp = pat;
        boolean isMultipleStr = false;
        while (tmp.length()<= s_length) {
            if (tmp.equals(str)) {
                isMultipleStr = true;
                break;
            } else {
                tmp += pat;
            }
        }

        if (isMultipleStr) {
            int[] lps = new int[p_length];
            computeLPSArray(pat, p_length, lps);
            int len = lps[p_length - 1];
            if (len > 0 && p_length % (p_length - len) == 0) {
                result = pat.substring(0, p_length - len).length();
            } else {
                result = pat.length();
            }
        }
        return result;
    }

    public static void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
