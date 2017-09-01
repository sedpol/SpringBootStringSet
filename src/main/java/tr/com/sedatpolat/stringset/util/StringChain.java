package tr.com.sedatpolat.stringset.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author sedpol
 *
 */
public class StringChain {
	private int counter;
	private List<String> chainedList = new ArrayList<String>();
	private List<String> unchainedList = new ArrayList<String>();

	public StringChain() {
		counter = 0;
		chainedList = new ArrayList<String>();
		unchainedList = new ArrayList<String>();
	}
	
	
	public List<String> findMaxChain(String ... str) {
		List<String> maxlist = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			counter = 0;
			unchainedList = arrayToArrayList(str);
			
			chainedList.clear();
			
			String word = str [i];
			
			chain(word);
			removeFromUnchainedList(word);
			
			findChain(word);
			
			if (chainedList.size() > maxlist.size()) {
				maxlist.clear();
				maxlist.addAll(chainedList);
			}
		}
		return maxlist;
	}
	
	private void findChain(String word ) {
		
		if (counter > unchainedList.size()) { // this means there is no string that belongs to chain
			for (String string : unchainedList) {
				//finally remaining strings may lead the chain.
				if (!chainedList.isEmpty())
					if (string.endsWith(chainedList.get(0).substring(0, 1).toString())) {
						chainPositionAt(string, 0);
						counter = 0;
					}
			}
			return;
		}
		
		counter++;
		
		if (unchainedList.isEmpty())
			return;
		
		if (chainedList.get(chainedList.size()-1).endsWith(word.substring(0, 1).toString())) {
			counter = 0;

			chain(word);
			removeFromUnchainedList(word);
			
			if (unchainedList.isEmpty())
				return;
			
			findChain(unchainedList.get(0));
			return;
		}
		
		int index = -1;
		for (int i = 0; i < chainedList.size() - 1; i++) {
			if (chainedList.get(i).endsWith(word.substring(0, 1).toString()) 
					&& word.endsWith(chainedList.get(i + 1).substring(0, 1).toString())) {
				index = i;
				break;
			}
		}
		
		if (index != -1) {
			counter = 0;
			chainPositionAt(word, index+1);
			removeFromUnchainedList(word);
			findChain(unchainedList.get(0));
			return;
		}
		
		// if word does not belong the current chain, 
		// we should try this word after adding other words into the chain
		if (unchainedList.size() > 1) {
			unchainedList.remove(word);
			unchainedList.add(word);
			
			word = unchainedList.get(0);
		}
		findChain(word);
	}
	
	private void chain(String word) {
		if (!chainedList.contains(word)) {
			chainedList.add(word);
		}
	}
	
	private void chainPositionAt(String word, int index) {
		if (!chainedList.contains(word)) {
			chainedList.add(index, word);
		}
	}

	private void removeFromUnchainedList(String word) {
		unchainedList.remove(word);
	}
	
	private List<String> arrayToArrayList (String ... str) {
		Set<String> resultList = new TreeSet<String>();
		for (String string : str) {
			resultList.add(string);
		}
		List<String> result = new ArrayList<String>();
		result.addAll(resultList);
		return result;
	}
}
