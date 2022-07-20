package com.qa.client;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import org.testng.Assert;
public class RestClient extends TestBase {
	
	// 1. Calling The Get Method
	
	public RestClient() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public void get(String Url) throws ClientProtocolException, IOException {
	
		// Get Status Code
		CloseableHttpClient httpClient =	HttpClients.createDefault();
		HttpGet httpget = new HttpGet(Url); // Http Get Request
		CloseableHttpResponse closeableHttpResponse= httpClient.execute(httpget); // Hit the Get Url 
		
		int statusCode= closeableHttpResponse.getStatusLine().getStatusCode(); // get the Status Code 
		System.out.println("Status code is-->"+statusCode);

		
		// get body
		String ResponseString= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8"); // Give the entire string 
		JSONObject Responsejsonobject= new JSONObject(ResponseString);
		System.out.println("Response Json from API--->"+Responsejsonobject);
		
		String data3= TestUtil.getValueByJPath(Responsejsonobject,"");
		System.out.println(data3);
		
		String page= TestUtil.getValueByJPath(Responsejsonobject,"/per_page");
		System.out.println(page);
		
		String data= TestUtil.getValueByJPath(Responsejsonobject,"data[0]");
		System.out.println(data);
		
		String data1= TestUtil.getValueByJPath(Responsejsonobject,"data[0]/avatar");
		System.out.println(data1);
		
		// Get header
		Header[] headerArray= closeableHttpResponse.getAllHeaders();
		Map<String,String> allHeader= new HashMap<String,String>();
		for(Header Header: headerArray ) {
			allHeader.put(Header.getName(), Header.getValue());
			
		}
		System.out.println("Header Details..."+allHeader );
		
		
		
	}
	
	public CloseableHttpResponse Post(String url, String EntryString, HashMap<String,String> Headermap) throws ClientProtocolException, IOException {
		
		
		
		//Step 1: Create the Client First. 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// Step 2: Make the Post Method 
		
		HttpPost httpPost = new HttpPost(url);
		
		// Step 3: For payload or Body 
		httpPost.setEntity(new StringEntity(EntryString));
		
		
		// Step 4: Setup The header
		
		for(Map.Entry<String, String> entry : Headermap.entrySet() ) {
			
			httpPost.addHeader(entry.getKey(), entry.getValue());
			
		}
		
		// Step 5: Execute 
		
		CloseableHttpResponse closeablehttpresponse= httpClient.execute(httpPost);
		return closeablehttpresponse;
	}

}
