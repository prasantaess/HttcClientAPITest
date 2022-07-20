package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApi extends TestBase {

	TestBase testbase;
	String ActualURL;
	String ServiceUrl;
	String URL;
	RestClient restClient;
	public GetApi() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void Setup() throws IOException {
		testbase = new TestBase();
		ActualURL = prop.getProperty("URL");
		ServiceUrl = prop.getProperty("ServiceUrl");
		URL = ActualURL + ServiceUrl;
		System.out.println("Actual Url is..."+URL);
		
	}
	@Test
	public void getApiTest() throws ClientProtocolException, IOException {
		restClient=new RestClient();
		restClient.get(URL);
		
		
	}

}
