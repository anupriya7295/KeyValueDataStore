package com.datastore;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.datastore.service.DataStoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = KeyValueDataStoreApplication.class)
public class KeyValueDataStoreApplicationTests {

  @Autowired
  private WebApplicationContext context;
  
  @Autowired
  private Controller service;

  protected MockMvc mvc;
  
  @Mock
  private DataStoreService datastore;

  private static final String dataStorePath = "src/test/resources/datastore.txt";

  private static final String dataStoreDeactivatedKey = "src/test/resources/datastoredeactivatedkey.json";

  private static final String dataStoreLineMap = "src/test/resources/datastorelinemap.json";


  public static JSONObject searchJson = null;

  @Before
  public void setup() throws Exception {
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//    searchJson = new JSONObject(FileUtils.readFileToString(new File(dataPath), "UTF-8"));
  }

  @Test
  public void testPing() throws Exception {
    String uri = "/datastore/ping";

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);

    MvcResult result = mvc.perform(request.contentType(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    String content = result.getResponse().getContentAsString();
    Assert.assertNotNull("testSearchPing", content);
  }
  
  
  

  
  

}
