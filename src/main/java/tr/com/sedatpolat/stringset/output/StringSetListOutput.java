package tr.com.sedatpolat.stringset.output;

import java.util.List;

import tr.com.sedatpolat.stringset.entity.StringSet;

/**
 * 
 * @author sedpol
 *
 */
public class StringSetListOutput extends BaseOutput {
	private static final long serialVersionUID = 1L;
	private List<StringSet> stringSets;

	public StringSetListOutput() {
	}
	
	public List<StringSet> getStringSets() {
		return stringSets;
	}
	public void setStringSets(List<StringSet> stringSets) {
		this.stringSets = stringSets;
	}
}
