package tr.com.sedatpolat.stringset.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.sedatpolat.stringset.entity.StringSet;
import tr.com.sedatpolat.stringset.output.BaseOutput;
import tr.com.sedatpolat.stringset.output.StatisticOutput;
import tr.com.sedatpolat.stringset.output.StringListOutput;
import tr.com.sedatpolat.stringset.output.StringSetListOutput;
import tr.com.sedatpolat.stringset.output.StringSetOutput;
import tr.com.sedatpolat.stringset.service.StringService;

/**
 * 
 * @author sedpol
 *
 */
@RestController
@RequestMapping(StringSetController.BASE_URL)
public class StringSetController {
	
	private static final Logger LOG = Logger.getLogger(StringSetController.class.getName());

	public static final String BASE_URL 				= "/string";
	public static final String GET_ALL_STRING_SET_URL 	= "/getAllStringSet";
	public static final String UPLOAD_URL 				= "/upload";
	public static final String DELETE_URL 				= "/delete";
	public static final String SEARCH_URL 				= "/search";
	public static final String STATISTIC_URL 			= "/statistic";
	public static final String MOST_COMMON_URL 			= "/mostCommon";
	public static final String LONGEST_STRING_URL 		= "/longestString";
	public static final String EXACTLY_IN_URL 			= "/exactlyIn";
	public static final String CREATE_INTERSECTION_URL 	= "/createIntersection";
	public static final String FIND_LONGEST_CHAIN_URL	= "/findLongestchain";
	
	@Autowired
	StringService stringService;

	@RequestMapping(value = GET_ALL_STRING_SET_URL, 
					method = RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StringSetListOutput getAllStringSet() {
		StringSetListOutput output = new StringSetListOutput();
		try {
			output.setStringSets(stringService.getAllStringSet());
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}

	@RequestMapping(value = UPLOAD_URL, method = RequestMethod.POST,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BaseOutput upload (@RequestBody StringSet stringSet) {
		BaseOutput output = new BaseOutput();
		try {
			stringService.uploadStringSet(stringSet);
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}
	
	@RequestMapping(value = DELETE_URL, method = RequestMethod.DELETE,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BaseOutput delete (@RequestParam(value = "id", required = true) Long id) {
		BaseOutput output = new BaseOutput();
		try {
			stringService.removeStringSet(id);
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}
	
	@RequestMapping(value = SEARCH_URL, method = RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StringSetListOutput search (@RequestParam(value = "string", required = true) String string) {
		StringSetListOutput output = new StringSetListOutput();
		try {
			output.setStringSets(stringService.findStringInStringSet(string));
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}
	
	@RequestMapping(value = STATISTIC_URL, method = RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StatisticOutput getStatistic () {
		StatisticOutput output = new StatisticOutput();
		try {
			output = stringService.getStatistic();
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		
		return output;
	}

	@RequestMapping(value = MOST_COMMON_URL, method = RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StringSetOutput getMostCommon () {
		StringSetOutput output = new StringSetOutput();
		try {
			output.setStringSet(stringService.getMostCommon());
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}
	
	@RequestMapping(value = LONGEST_STRING_URL, method = RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StringSetOutput getLongestStrings () {
		StringSetOutput output = new StringSetOutput();
		try {
			output.setStringSet(stringService.getLongestStrings());
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}
	
	@RequestMapping(value = EXACTLY_IN_URL, method = RequestMethod.PUT,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StringSetOutput getExactlyIn (@RequestBody StringSet stringSet) {
		StringSetOutput output = new StringSetOutput();
		try {
			output.setStringSet(stringService.getExactlyIn(stringSet));
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}

	@RequestMapping(value = CREATE_INTERSECTION_URL, method = RequestMethod.POST,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StringSetOutput createIntersection () {
		StringSetOutput output = new StringSetOutput();
		try {
			output.setStringSet(stringService.createIntersection());
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}
	
	@RequestMapping(value = FIND_LONGEST_CHAIN_URL, method = RequestMethod.GET,
					produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StringListOutput findLongestChain () {
		
		StringListOutput output = new StringListOutput();
		try {
			output.setStringList(stringService.findLongestChain());
			output.markedAsSuccess();
		} catch (Exception e) {
			LOG.error(e);
			output.markedAsFailed();
		}
		return output;
	}
}
