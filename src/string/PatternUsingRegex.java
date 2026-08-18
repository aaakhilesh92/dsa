package string;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUsingRegex {

    public static void main(String[] args) {
        String pat = "ak@i";
        String[] arr = {"akhilesh", "akhi", "akki", "akhy"};
        pattern_searching(arr, pat);

        // 1st way
        Pattern p = Pattern.compile(".s");// . represents single character
        Matcher m = p.matcher("as");
        boolean b = m.matches();
        System.out.println(b);

        // 2nd way
        b = Pattern.compile(".s").matcher("as").matches();
        System.out.println(b);

        // 3rd way
        b = Pattern.matches(".s", "as");
        System.out.println(b);

        Pattern pattern = Pattern.compile("w3schools",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools! W3Schools");
        boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
        System.out.println(matcher.groupCount());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        String pat1 = "\\d{10}";
        System.out.println(Pattern.matches(pat1, "9134567890"));

        String text = "This is the text to be searched "
                + "for occurrences of the http:// pattern.";

        String patternString = "This is the";

        pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(text);

        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("matches   = " + matcher.matches());
    }

    public static void pattern_searching(String[] arr, String pat) {
        Set<String> set = new HashSet<>();
        pat = pat.replace('@', '.') + ".*";
        Pattern p = Pattern.compile(pat);
        for (String s : arr) {
            if (p.matcher(s).matches()) {
                set.add(s);
            }
        }
        System.out.println(set);
        System.out.println("pattern_searching done");
    }

}
