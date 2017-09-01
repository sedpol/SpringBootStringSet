package tr.com.sedatpolat.stringset.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import tr.com.sedatpolat.stringset.entity.StringSet;
import tr.com.sedatpolat.stringset.output.StatisticOutput;
import tr.com.sedatpolat.stringset.util.CollectionUtils;
import tr.com.sedatpolat.stringset.util.StringChain;
import tr.com.sedatpolat.stringset.util.StringGeneratorUtil;

/**
 * 
 * @author sedpol
 *
 */
public class StringSetDB {

	public static List<StringSet> stringSetList = new ArrayList<StringSet>();

	private StringSetDB() {
	}
	
	static {
		Random rand = new Random();

		int x = rand.nextInt(100);
		int y = 0;

		Set<String> set = null;
		StringSet stringSet = null;

		for (int i = 0; i < x; i++) {

			set = new TreeSet<String>();

			y = rand.nextInt(100) + 10;

			for (int j = 0; j < y; j++) {
				set.add(StringGeneratorUtil.generate());
			}

			stringSet = new StringSet();
			stringSet.setStringSet(set);
//			stringSetList.add(stringSet);
		}
	}

	public static void addInToStringSetList(StringSet stringSet) {
		stringSetList.add(stringSet);
	}

	public static void removeFromStringSetList(Long id) {
		StringSet removedSet = null;
		for (StringSet stringSet : stringSetList) {
			if (stringSet.getId().longValue() == id) {
				removedSet = stringSet;
				break;
			}
		}
		stringSetList.remove(removedSet);
	}

	public static List<StringSet> getStringSetList() {
		return stringSetList;
	}

	public static List<StringSet> findStringInStringSet(String string) {
		List<StringSet> resultSets = new ArrayList<StringSet>();
		for (StringSet stringSet : stringSetList) {
			if (stringSet.getStringSet().contains(string))
				resultSets.add(stringSet);
		}
		return resultSets;
	}

	public static StatisticOutput calculateStatistic() {
		
		StatisticOutput output = new StatisticOutput();
		
		if (stringSetList.isEmpty())
			return output;
		
		Random random = new Random();
		
		StringSet stringSet = stringSetList.get(random.nextInt(stringSetList.size()));

		List<Integer> lengtList = new ArrayList<Integer>();

		int sumOfLength = 0;

		for (String string : stringSet.getStringSet()) {
			lengtList.add(string.length());
			sumOfLength += string.length();
		}

		Collections.sort(lengtList);

		output.setLengthOfTheShortestString(lengtList.get(0));
		output.setLengthOfTheLongestString(lengtList.get(lengtList.size() - 1));
		
		int size = lengtList.size();
		double median = 0;
		if (size % 2 == 0)
			median = (lengtList.get(size / 2 - 1) + lengtList.get(size / 2)) / 2;
		else
			median = lengtList.get(size / 2);
		output.setMedianLength(median);

		output.setAverageLength((double) sumOfLength / size);
		output.setNumberOfString(size);
		
		return output;
	}

	public static Set<String> findMostCommon () {
		
		Map<String, Integer> counterMap = new HashMap<String, Integer>();
		for (StringSet stringSet : stringSetList) {
		
			for (String string : stringSet.getStringSet()) {
				if (counterMap.containsKey(string)) {
					counterMap.put(string, (Integer)counterMap.get(string) + 1);
				} else {
					counterMap.put(string, 0);
				}
			}
		}
		int maxValue = 0;
		
		for (Integer value : counterMap.values()) {
			if (value > maxValue)
				maxValue = value;
		}
		
		Set<String> mostCommonStringList = new TreeSet<String>();

		for (String key : counterMap.keySet()) {
			if (counterMap.get(key) == maxValue)
				mostCommonStringList.add(key);
		}
		
		return mostCommonStringList;
	}
	
	public static Set<String> findLongestStrings() {
		Set<String> stringList = new TreeSet<String>();
		
		String tempString = "";
		for (StringSet stringSet : stringSetList) {
			for (String string : stringSet.getStringSet()) {
				if (string.length() > tempString.length()) {
					tempString = string;
					stringList.clear(); // new largest comes
					stringList.add(string);
				} else if (string.length() == tempString.length())  {
					stringList.add(string);
				}
			}
		}
		return stringList;
	}

	public static Set<String> findExactlyIn(StringSet stringSet) {
		Set<String> stringList = new TreeSet<String>();
		
		for (StringSet ss : stringSetList) {
			for (String string : stringSet.getStringSet()) {
				if (ss.getStringSet().contains(string)) {
					stringList.add(string);
				}
			}
		}
		return stringList;
	}

	public static Set<String> createIntersection() {
		Set<String> set = new TreeSet<String>();
		if (stringSetList.size() < 2)
			return set;
		
		for (String string1 : stringSetList.get(stringSetList.size() - 1).getStringSet()) {
			if (stringSetList.get(stringSetList.size() - 2).getStringSet().contains(string1))
				set.add(string1);
		}
		StringSet stringSet = new StringSet();
		stringSet.setStringSet(set);
		stringSetList.add(stringSet);
		return set;
	}

	public static List<String> findLongestChain() {
		StringChain stringChain = new StringChain();
		List<StringSet> allStringSet = getStringSetList();
		
		List<String> longestChain = new ArrayList<String>();
		List<String> tempChain = null;
		for (StringSet stringSet : allStringSet) {
			
			if (longestChain.size() > stringSet.getStringSet().size())
				continue;
			
			tempChain = stringChain.findMaxChain(CollectionUtils.setToArray(stringSet.getStringSet()));
			if (tempChain.size() > longestChain.size())
				longestChain = tempChain;
		}
		return longestChain;
	}
}
