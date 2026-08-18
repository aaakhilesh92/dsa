package string;

public class LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {
        String str = "aaikaikajakuajkajoajakuabuau";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isConsonant(arr[i])) {
                arr[i] = 'a';
            }
        }
        String result = new String(arr);
        System.out.println(result);
    }

    public static boolean isConsonant(char ch) {
        boolean result = false;
        if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
            result = true;
        }
        return result;
    }
}
