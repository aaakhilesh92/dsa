package number;

import java.util.Arrays;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
        String ss = "DIY|akahia";
        if(ss.contains("|")) {
            System.out.println("yes");
        }
        String[] arr = ss.split("\\|");
        System.out.println(arr[0]);
        String ss2 = "diy,ivr,cst";
        String[] arr2 = ss2.split(",");
        System.out.println(arr2[0]);
        HashSet<String> set = new HashSet<String>(Arrays.asList(arr2));
        System.out.println(set.toString());
        if(set.contains("DIY".toLowerCase())) {
            System.out.println("klajlk");
        }
        System.out.println(" ".isEmpty());
    }

}
