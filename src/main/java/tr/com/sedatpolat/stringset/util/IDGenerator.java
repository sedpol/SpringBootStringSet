package tr.com.sedatpolat.stringset.util;

/**
 * 
 * @author sedpol
 *
 */
public class IDGenerator {

	public static synchronized Long generate () {
		return System.nanoTime();
	}
}
