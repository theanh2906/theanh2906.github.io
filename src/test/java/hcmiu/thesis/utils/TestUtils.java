package hcmiu.thesis.utils;

import java.util.List;

public class TestUtils {
	public static void main(String[] args) {
		String query = "index=1&index=2&name=11";
		List<Integer> listInt = StringUtil.getDigitsFromQuery(query);
		listInt.forEach(System.out::println);
	}
}
