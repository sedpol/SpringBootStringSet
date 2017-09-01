package tr.com.sedatpolat.stringset.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.sedatpolat.stringset.dao.StringSetDao;
import tr.com.sedatpolat.stringset.entity.StringSet;
import tr.com.sedatpolat.stringset.output.StatisticOutput;

/**
 * 
 * @author sedpol
 *
 */
@Service
public class StringService {

	@Autowired
	private StringSetDao stringSetDao;

	public List<StringSet> getAllStringSet() {
		return stringSetDao.getAllStringSet();
	}

	public void uploadStringSet (StringSet strSet) {
		stringSetDao.uploadStringSet(strSet);
		
	}
	
	public void removeStringSet(Long id) {
		stringSetDao.removeStringSet(id);
	}
	
	public List<StringSet> findStringInStringSet(String string) {
		return stringSetDao.findStringInStringSet(string);
	}

	public StatisticOutput getStatistic() {
		return stringSetDao.getStatistic();
	}

	public Set<String> getMostCommon() {
		return stringSetDao.getMostCommon();
	}

	public Set<String> getLongestStrings() {
		return stringSetDao.getLongestStrings();
	}

	public Set<String> getExactlyIn(StringSet stringSet) {
		return stringSetDao.getExactlyIn(stringSet);
	}

	public Set<String> createIntersection() {
		return stringSetDao.createIntersection();
	}

	public List<String> findLongestChain() {
		return stringSetDao.findLongestChain();
	}
}
