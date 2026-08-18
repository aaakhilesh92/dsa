package number;

import java.util.HashMap;
import java.util.Map;

public class CountDigits {

	public static void main(String[] args) {
		String s = "RUDRL";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray()) {
			map.merge(ch, 1, Integer::sum);
		}
		System.out.println(map);
		int u_freq = map.getOrDefault('U', 0);
		int d_freq = map.getOrDefault('D', 0);
		int l_freq = map.getOrDefault('L', 0);
		int r_freq = map.getOrDefault('R', 0);
		int diff = Math.abs(u_freq - d_freq) + Math.abs(l_freq - r_freq);
		int sum = s.length();
		System.out.println(sum - diff);
	}
}
