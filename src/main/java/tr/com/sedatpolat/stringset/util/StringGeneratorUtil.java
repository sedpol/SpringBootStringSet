package tr.com.sedatpolat.stringset.util;

import java.math.BigInteger;
import java.util.Random;

/**
 * 
 * @author sedpol
 *
 */
public class StringGeneratorUtil {

	private static Random random = new Random();
	
	public static String generate () {
        return new BigInteger(random.nextInt(200), random).toString(32);
	}
}
