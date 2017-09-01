package tr.com.sedatpolat.stringset;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import tr.com.sedatpolat.stringset.controller.StringSetController;
import tr.com.sedatpolat.stringset.entity.StringSet;
import tr.com.sedatpolat.stringset.service.StringService;
import tr.com.sedatpolat.stringset.util.StringGeneratorUtil;
/**
 * 
 * @author sedpol
 *
 */
@ComponentScan("tr.com.sedatpolat.stringset")
@EntityScan("tr.com.sedatpolat.stringset")
@RunWith(SpringRunner.class)
@WebMvcTest(StringSetController.class)
public class UploadStressTest {

private static final Logger LOG = Logger.getLogger(UploadStressTest.class.getName());
	private static final MediaType JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8;

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	StringService stringService;
	
	private MockMvc mvc;
	
	private static List<StringSet> stringSets = new ArrayList<StringSet>();
	
	@BeforeClass
	public static void setUpBeforeClass() {
		LOG.info("@BeforeClass: runs before class UploadStressTest");
		
		StringSet stringSet = new StringSet();
		
		Set<String> set = new TreeSet<String>();

		Random rand = new Random();

		int x = 10000;
		int y = 0;
		for (int i = 0; i < x; i++) {

			set = new TreeSet<String>();

			y = rand.nextInt(100) + 10;

			for (int j = 0; j < y; j++) {
				set.add(StringGeneratorUtil.generate());
			}

			stringSet = new StringSet();
			stringSet.setStringSet(set);
			stringSets.add(stringSet);
		}
	}
	
	@Before
	public void setUp() {
		LOG.info("@Before: runs before UploadStressTest");
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testUploadString() throws Exception {
		LOG.info("@Test: runs test: " + StringSetController.UPLOAD_URL);
		LOG.info("@Test: stringSets size: " + stringSets.size());
		
		Gson gson = new Gson();
		
		for (StringSet stringSet : stringSets) {
			mvc.perform(post(StringSetController.BASE_URL + StringSetController.UPLOAD_URL)
					.accept(JSON_UTF8)
					.contentType(JSON_UTF8)
					.content(gson.toJson(stringSet)))
		     		.andExpect(status().isOk())
					.andExpect(content().contentType(JSON_UTF8))
					.andExpect(jsonPath("$.success", is(true)))
					.andReturn();
		}
	}
	
	@After
	public void tearDown() {
		LOG.info("@After: runs after UploadStressTest");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {

		LOG.info("@AfterClass: runs After class UploadStressTest");
	}
}
