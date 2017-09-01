package tr.com.sedatpolat.stringset.dao;

import java.util.List;
import java.util.Set;

import tr.com.sedatpolat.stringset.entity.StringSet;
import tr.com.sedatpolat.stringset.output.StatisticOutput;

/**
 * 
 * @author sedpol
 *
 */
public interface StringSetDao {

	public List<StringSet> getAllStringSet();
	
	public void uploadStringSet(StringSet strSet);
	
	public void removeStringSet(Long id);

	public List<StringSet> findStringInStringSet(String string);

	public StatisticOutput getStatistic();

	public Set<String> getMostCommon();

	public Set<String> getLongestStrings();

	public Set<String> getExactlyIn(StringSet stringSet);

	public Set<String> createIntersection();

	public List<String> findLongestChain();

}
