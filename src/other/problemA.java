package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class problemA {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs = new ArrayList<>();
        String line = "";
        int n = 1;
        while ((line = br.readLine()) != null && line.length() != 0) {
            inputs.add(line);
            n++;
        }
        int cases = 1;
        for (String input : inputs) {
            System.out.print("Case " + cases + ": ");
            String[] arr = input.split(" ");
            int earth = Integer.parseInt(arr[0]);
            int mars = Integer.parseInt(arr[1]);
            System.out.println(daysTillBothAt0(earth, mars));
            cases++;
        }
    }
    private static int daysTillBothAt0(int currentEarthday, int currentMarsday) {
        // base case
        if (currentEarthday == 0 && currentMarsday == 0) {
            return 0;
        }
        int count = 687 - currentMarsday;
        currentEarthday = (currentEarthday + count) % 365;
        while (currentEarthday != 0) {
            currentEarthday = (currentEarthday + 687) % 365;
            count += 687;
        }
        return count;
    }
}
