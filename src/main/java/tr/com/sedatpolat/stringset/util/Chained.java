package tr.com.sedatpolat.stringset.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author sedpol
 *
 */
public class Chained {

	public static void main(String[] args) {

		List<String[]> list = new ArrayList<>();

		list.add(new String[] { "for", "geer", "rig", "raf" });
		list.add(new String[] { "aaa", "bbb", "baa", "aab" });
		list.add(new String[] { "aaa" });
		list.add(new String[] { "aaa", "bbb" });
		list.add(new String[] { "aab", "bac", "aaa", "cda" });
		list.add(new String[] { "geek", "king" });
		list.add(new String[] { "geek", "kink", "kick" });
		list.add(new String[] { "aa", "cd", "dc" });
		list.add(new String[] { "ab", "bc", "cd", "db", "bf", "fg", "ga" });
		list.add(new String[] { "abb" });
		list.add(new String[] { "ab", "bc", "cd", "db", "bf", "fg", "fg" });
		list.add(new String[] { "ab", "bc", "cd", "db", "bf", "fg", "gh" });

		testTheCases(list);
	}

	private static void testTheCases(List<String[]> list) {
		for (String[] testCase : list) {
			Boolean[] visited = new Boolean[testCase.length];

			for (int i = 0; i < testCase.length; i++) {
				visited[i] = false;
			}
			visited[0] = true;

			List<String> stringList = new ArrayList<String>();
			
			System.out.println("For list: " + Arrays.toString(testCase));
			System.out.println(checkChain(testCase[0], testCase, visited));
			System.out.println(stringList);
		}
	}

	public static boolean checkChain(String chained, String[] arr, Boolean[] visited) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == true) {
				count++;
			} else {
				if (chained.charAt(chained.length() - 1) == arr[i].charAt(0)) {
					visited[i] = true;
					if (checkChain(chained + arr[i], arr, visited) == false) {
						visited[i] = false;
					} else {
						return true;
					}
				}
			}
		}
		if (count == arr.length && chained.charAt(0) == chained.charAt(chained.length() - 1)) {
			return true;
		} else {
			return false;
		}
	}
}