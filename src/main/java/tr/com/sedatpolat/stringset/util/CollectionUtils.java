package tr.com.sedatpolat.stringset.util;

import java.util.Set;

/**
 * 
 * @author sedpol
 *
 */
public class CollectionUtils {

	public static String [] setToArray(Set<String> strings) {
		return strings.toArray(new String [strings.size()]);
	}
}
