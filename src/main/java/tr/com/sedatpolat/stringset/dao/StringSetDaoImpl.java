package tr.com.sedatpolat.stringset.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import tr.com.sedatpolat.stringset.db.StringSetDB;
import tr.com.sedatpolat.stringset.entity.StringSet;
import tr.com.sedatpolat.stringset.output.StatisticOutput;

/**
 * 
 * @author sedpol
 *
 */
@Repository
public class StringSetDaoImpl implements StringSetDao {

	@Override
	public List<StringSet> getAllStringSet() {
		return StringSetDB.getStringSetList();
	}

	@Override
	public void uploadStringSet(StringSet stringSet) {
		StringSetDB.addInToStringSetList(stringSet);
		
	}

	@Override
	public void removeStringSet(Long id) {
		StringSetDB.removeFromStringSetList(id);
	}

	@Override
	public List<StringSet> findStringInStringSet(String string) {
		return StringSetDB.findStringInStringSet(string);
	}

	@Override
	public StatisticOutput getStatistic() {
		return StringSetDB.calculateStatistic();
	}

	@Override
	public Set<String> getMostCommon() {
		return StringSetDB.findMostCommon();
	}
	
	@Override
	public Set<String> getLongestStrings() {
		return StringSetDB.findLongestStrings();
	}

	@Override
	public Set<String> getExactlyIn(StringSet stringSet) {
		return StringSetDB.findExactlyIn(stringSet);
	}

	@Override
	public Set<String> createIntersection() {
		return StringSetDB.createIntersection();
	}

	@Override
	public List<String> findLongestChain() {
		return StringSetDB.findLongestChain();
	}
}
