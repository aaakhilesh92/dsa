package other;

public class StreamTesting {

	public static void main(String[] args) {
		"hackerearth".chars().distinct().peek(ch -> System.out.println(ch + "++")).sorted()
				.forEach(ch -> System.out.println(ch + "**"));
	}

}
