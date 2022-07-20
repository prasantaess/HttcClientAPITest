package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostAPI extends TestBase{

	TestBase testbase;
	String SurviceUrl;
	String Apiurl;
	String url;
	RestClient restClient;
	HashMap<String,String> headermap= new HashMap<String,String>();
	CloseableHttpResponse closeablehttpresponse;
	
	public PostAPI() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void Setup() {
		SurviceUrl =prop.getProperty("URL");
		Apiurl=     prop.getProperty("ServiceUrl");
		url= SurviceUrl+Apiurl;
		System.out.println("The Correct Url is .... "+ url);
	
	}
	
	@Test
	public void PostApiTest() throws StreamWriteException, DatabindException, IOException {
		
		// create a object of the data called Marcelling.
		
		ObjectMapper mapper = new ObjectMapper();
		Users users= new Users("morpheus","leader");
		
		// Object to Json file Convertion  //Marshalling 
		
		mapper.writeValue(new File("C:\\Users\\paull\\eclipse-workspace\\APIAutomation\\src\\test\\java\\com\\qa\\test\\PostApi.Json"),users);
		
		// Convert Json to String  
		
		String UserJsonString= mapper.writeValueAsString(users);
		System.out.println("The UserJsonString is--"+UserJsonString);
		
		// call the API
		restClient= new RestClient();
		headermap.put("Content-Type","text/plain");
		closeablehttpresponse = restClient.Post(url, UserJsonString, headermap);
		
		// 1. Get Status Call
		
		int PostStatus = closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println(PostStatus);
		
		// Get the Body 
		
		String ResponseString= EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		JSONObject jsonobject=new JSONObject(ResponseString);
		System.out.println("The Response Body is =="+jsonobject);
		
		// Get the Header Details
		
		Header[] header= closeablehttpresponse.getAllHeaders();
		Map<String,String> Headerinfo= new HashMap<String,String>();
		for(Header header1:header ) {
			Headerinfo.put(header1.getName(), header1.getValue())	;
	
		}
		System.out.println("All header Information is--->"+Headerinfo);
		
		
		
	}
	
	
	

}
