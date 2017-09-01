package tr.com.sedatpolat.stringset.output;

import java.util.List;

/**
 * 
 * @author sedpol
 *
 */
public class StringListOutput extends BaseOutput {
	private static final long serialVersionUID = 1L;
	private List<String> stringList;

	public StringListOutput() {
	}
	
	public List<String> getStringList() {
		return stringList;
	}
	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}
}
