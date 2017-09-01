package tr.com.sedatpolat.stringset.output;

import java.util.Set;

/**
 * 
 * @author sedpol
 *
 */
public class StringSetOutput extends BaseOutput {
	private static final long serialVersionUID = 1L;
	private Set<String> stringSet;

	public StringSetOutput() {
	}
	
	public Set<String> getStringSet() {
		return stringSet;
	}
	public void setStringSet(Set<String> stringSet) {
		this.stringSet = stringSet;
	}
}
