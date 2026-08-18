package string;

/*
 * Write a function that transforms string into a new string. 
 * New string does not contain repeating letters but contains a number after every 
 * letter that means how many times the letter was repeated in the original string

""  ->  ""
"aab"  ->  "a2b1"
"aaaabbbaab"  ->  "a4b3a2b1"

public String encode(String input) {
}
 * 
 * */

public class ConvertLongStringToSmall {

    public static void main(String[] args) {
        System.out.println(transform("aab"));
        System.out.println(transform("aaaabbbaab"));
    }
    public static String transform(String input) {
        if (input == null) {
            return null;
        }
        if ("".equals(input)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int c = 1;
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (prev == input.charAt(i)) {
                c++;
            } else {
                sb.append(prev);
                sb.append(c);
                c = 1;
                prev = input.charAt(i);
            }
        }
        sb.append(prev);
        sb.append(c);
        return sb.toString();
    }

}
