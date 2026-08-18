package string;

import java.util.Stack;

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

public class ConvertLongStringToSmall2 {

    public static void main(String[] args) {
        String ss = "<div><div><i>aaaa</b></div></div>";
        Stack<String> st = new Stack<>();
        String[] arr = ss.split(">");
        String res = "";
        for (String s : arr) {
            System.out.print(s + ",");
            if (s.indexOf("</") != -1) {
                int index = s.indexOf("</");
                String s2 = s.substring(index + 2);
                String s1 = st.pop();
                if (!s1.equals(s2)) {
                    res = s1;
                    break;
                }
            } else {
                st.push(s.substring(1));
            }
        }
        System.out.println();
        System.out.println("res:" + res);
    }

}
