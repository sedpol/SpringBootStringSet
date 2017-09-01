package tr.com.sedatpolat.stringset;

import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import tr.com.sedatpolat.stringset.controller.StringSetController;
import tr.com.sedatpolat.stringset.entity.StringSet;
import tr.com.sedatpolat.stringset.service.StringService;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 
 * @author sedpol
 *
 */
@ComponentScan("tr.com.sedatpolat.stringset")
@EntityScan("tr.com.sedatpolat.stringset")
@RunWith(SpringRunner.class)
@WebMvcTest(StringSetController.class)
public class IntegrationTest {
	
	private static final MediaType JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8;

	private static final Logger LOG = Logger.getLogger(IntegrationTest.class.getName());
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	StringService stringService;
	
	private MockMvc mvc;

	private static StringSet stringSet = new StringSet();
	private static final String SEARCH_WORD = "Verto";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		LOG.info("@BeforeClass: runs before class IntegrationTest");
		Set<String> set = new TreeSet<String>();
		
		set.add(SEARCH_WORD);
		set.add("Analytics");
		set.add("Backend");
		set.add("team");
		set.add("is");
		set.add("the");
		set.add("best");
		
		stringSet.setStringSet(set);
	}
	
	@Before
	public void setUp() {
		LOG.info("@Before: runs before IntegrationTest");
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testGetAllStringSet() throws Exception {

		LOG.info("@Test: runs test: " + StringSetController.GET_ALL_STRING_SET_URL);
		mvc.perform(get(StringSetController.BASE_URL + StringSetController.GET_ALL_STRING_SET_URL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
		//		.andDo(print()) // do not open, if there are too many string to print.
				.andReturn();
	}
	
	@Test
	public void testUploadString() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.UPLOAD_URL);
		
		Gson gson = new Gson();
		
		mvc.perform(post(StringSetController.BASE_URL + StringSetController.UPLOAD_URL)
				.accept(JSON_UTF8)
				.contentType(JSON_UTF8)
				.content(gson.toJson(stringSet)))
	     		.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andExpect(jsonPath("$.success", is(true)))
				.andReturn();
	}
	
	@Test
	public void testDelete() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.DELETE_URL);
		
		
		mvc.perform(delete(StringSetController.BASE_URL + StringSetController.DELETE_URL)
				.param("id", "123456789"))
	     		.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andExpect(jsonPath("$.success", is(true)))
				.andReturn();
	}
	
	@Test
	public void testSearch () throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.SEARCH_URL);
		
		testUploadString();
		mvc.perform(get(StringSetController.BASE_URL + StringSetController.SEARCH_URL)
				.param("string", SEARCH_WORD))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.success", is(true)));
	}
	
	@Test
	public void testStatistic() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.STATISTIC_URL);
		mvc.perform(get(StringSetController.BASE_URL + StringSetController.STATISTIC_URL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.success", is(true)));
	}
	
	@Test
	public void testMostCommon() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.MOST_COMMON_URL);
		mvc.perform(get(StringSetController.BASE_URL + StringSetController.MOST_COMMON_URL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.success", is(true)));
	}

	@Test
	public void testLongestString() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.LONGEST_STRING_URL);
		mvc.perform(get(StringSetController.BASE_URL + StringSetController.LONGEST_STRING_URL)
				.accept(JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.success", is(true)));
	}
	
	@Test
	public void testExactlyIn() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.EXACTLY_IN_URL);
		Gson gson = new Gson();
		mvc.perform(put(StringSetController.BASE_URL + StringSetController.EXACTLY_IN_URL)
				.accept(JSON_UTF8)
				.contentType(JSON_UTF8)
				.content(gson .toJson(stringSet)))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.success", is(true)));
	}
	
	@Test
	public void testCreateIntersection() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.CREATE_INTERSECTION_URL);
		mvc.perform(post(StringSetController.BASE_URL + StringSetController.CREATE_INTERSECTION_URL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.success", is(true)));
	}
	
	@Test
	public void testFindLongestchain() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.FIND_LONGEST_CHAIN_URL);
		mvc.perform(get(StringSetController.BASE_URL + StringSetController.FIND_LONGEST_CHAIN_URL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.success", is(true)));
	}
	
	@After
	public void tearDown() {
		LOG.info("@After: runs after IntegrationTest");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {

		LOG.info("@AfterClass: runs After class IntegrationTest");
	}
}
