package tr.com.sedatpolat.stringset.entity;

import java.util.Set;

import tr.com.sedatpolat.stringset.util.IDGenerator;

/**
 * 
 * @author sedpol
 *
 */
public class StringSet {
	private Long id;
	private Set<String> stringSet;
	
	public StringSet() {
		this.id = IDGenerator.generate();
	}
	
	public Long getId() {
		return id;
	}

	public Set<String> getStringSet() {
		return stringSet;
	}

	public void setStringSet(Set<String> stringSet) {
		this.stringSet = stringSet;
	}
	
	@Override
	public String toString() {
		return stringSet.toString();
	}
}
